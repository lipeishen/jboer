package com.dcits.jb.core.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.dcits.jb.core.env.RedisConfigEnv;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSlotBasedConnectionHandler;
import redis.clients.util.JedisClusterCRC16;

public class RedisBaseUtil {
	// Redis服务器IP
	private final static String ADDR = RedisConfigEnv.getRedisIp();
	// Redis的端口号
	private final static String PORT = RedisConfigEnv.getRedisPort();
	// 访问密码
	// private static boolean IS_AUTH = RedisConfigEnv.getRedisNeedPassword();
	// private static String AUTH = RedisConfigEnv.getRedisPassword();
	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxTotal个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private final static int MAX_TOTAL = RedisConfigEnv.getRedisMaxConnect();
	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private final static int MAX_IDLE = RedisConfigEnv.getRedisMacIdle();
	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private final static int MAX_WAIT_MILLIS = RedisConfigEnv.getRedisTimeout();
	private final static int TIMEOUT = RedisConfigEnv.getRedisTimeout();
	private final static int SOTIMEOUT = RedisConfigEnv.getRedisSoTimeout();
	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private final static boolean TEST_ON_BORROW = RedisConfigEnv.getRedisIsTest();
	private static Set<HostAndPort> redisClusterNodes = new HashSet<HostAndPort>();
	private static List<HostAndPort> redisMasterNodes = null;
	private static JedisSlotBasedConnectionHandler jsbch = null;

	// 初始化Redis连接池
	static {
		try {
			String[] addrs = ADDR.split(",");
			String[] ports = PORT.split(",");

			for (int i = 0; i < addrs.length; i++) {
				String addr = addrs[i];
				int port = 6379;
				try {
					String portstr = ports[i];
					port = Integer.parseInt(portstr);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				redisClusterNodes.add(new HostAndPort(addr, port));
			}
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setMaxTotal(MAX_TOTAL);
			poolConfig.setMaxIdle(MAX_IDLE);
			poolConfig.setMaxWaitMillis(MAX_WAIT_MILLIS);
			poolConfig.setTestOnBorrow(TEST_ON_BORROW);
			jsbch = new JedisSlotBasedConnectionHandler(redisClusterNodes, poolConfig, TIMEOUT, SOTIMEOUT);
			setMasterList();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Jedis getJedis() {
		try {
			return jsbch.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Jedis getJedis(String key) {
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			return jsbch.getConnectionFromSlot(slot);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void setMasterList() {
		Jedis jedis = getJedis();
		redisMasterNodes = new ArrayList<HostAndPort>();
		if (jedis != null) {
			try {
				String info = jedis.clusterNodes();
				info = info.replace("myself,", "");
				String[] redisClients = info.split("\n");
				for (int i = 0; i < redisClients.length; i++) {
					String redisClient = redisClients[i];
					if (redisClient.contains("master") && !redisClient.contains("fail")) {
						String[] elements = redisClient.split(" ");
						String url = elements[1];
						String host = url.substring(0, url.indexOf(":"));
						String portstr = url.substring(url.indexOf(":") + 1);
						int port = 6379;
						try {
							port = Integer.parseInt(portstr);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						redisMasterNodes.add(new HostAndPort(host, port));

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static Set<String> getKeys(String keys) {
		Set<String> keyset = new HashSet<String>();
		for (int i = 0; i < redisMasterNodes.size(); i++) {
			Jedis jedis = null;
			try {
				HostAndPort hap = redisMasterNodes.get(i);
				jedis = jsbch.getConnectionFromNode(hap);
				Set<String> keysets = jedis.keys(keys);
				if (keysets != null) {
					for (String key : keysets) {
						keyset.add(key);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					jedis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return keyset;
	}

	public static Map<String, String> hgetAll(String key) {
		Jedis jedis = null;
		Map<String, String> valueMap = null;
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			if (jedis.exists(key)) {
				valueMap = jedis.hgetAll(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return valueMap;
	}

	public static void hmset(String key, Map<String, String> valueMap) {
		Jedis jedis = null;
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			jedis.hmset(key, valueMap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void hmset(String key, Map<String, String> valueMap, int expireTime) {
		Jedis jedis = null;
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			jedis.hmset(key, valueMap);
			jedis.expire(key, expireTime);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void del(String key) {
		Jedis jedis = null;
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			if (jedis.exists(key)) {
				jedis.del(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static String get(String key) {
		Jedis jedis = null;
		String value = "";
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			if (jedis.exists(key)) {
				value = jedis.get(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	public static void set(String key, String value) {
		Jedis jedis = null;
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void set(String key, String value, int expireTime) {
		Jedis jedis = null;
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			jedis.set(key, value);
			jedis.expire(key, expireTime);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void rpush(String key, String value) {
		Jedis jedis = null;
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			jedis.rpush(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void rpush(String key, String[] values) {
		Jedis jedis = null;
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			jedis.rpush(key, values);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static String lindex(String key, long index) {
		Jedis jedis = null;
		String value = "";
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			if (jedis.exists(key)) {
				value = jedis.lindex(key, index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	public static List<String> lrange(String key, long from, long to) {
		Jedis jedis = null;
		List<String> valueList = null;
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			if (jedis.exists(key)) {
				valueList = jedis.lrange(key, from, to);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return valueList;
	}

	public static void lrem(String key, long count, String value) {
		Jedis jedis = null;
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			if (jedis.exists(key)) {
				jedis.lrem(key, count, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void lpush(String key, String value) {
		Jedis jedis = null;
		try {
			int slot = JedisClusterCRC16.getSlot(key);
			jedis = jsbch.getConnectionFromSlot(slot);
			// if(jedis.exists(key)){
			jedis.lpush(key, value);
			// }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	// public static void main(String[] arg){
	//
	//
	// }
}