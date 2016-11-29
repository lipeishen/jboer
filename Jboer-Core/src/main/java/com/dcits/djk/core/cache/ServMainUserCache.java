package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

import redis.clients.jedis.ShardedJedis;

public class ServMainUserCache {
	private final static String keyPrefix = "bh.serv.main.userlist.";

	public static List<Map<String, String>> getUserServMainListByUserId(String userId) {
		if (userId == null || userId.equals("")) {
			return null;
		}
		String key = keyPrefix + userId + ".*";
		List<Map<String, String>> valueMap = null;
		try {
			Set<String> keys = RedisBaseUtil.getKeys(key);
			if (keys == null) {
				return null;
			}
			valueMap = new ArrayList<Map<String, String>>();
			for (String keya : keys) {
				Map<String, String> userMap = RedisBaseUtil.hgetAll(keya);
				valueMap.add(userMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valueMap;
	}

	public static Map<String, String> getUserServMainByUserIdAndServId(String userId, String serviceId) {
		if (userId == null || userId.equals("")) {
			return null;
		}
		if (serviceId == null || serviceId.equals("")) {
			return null;
		}
		String key = keyPrefix + userId + "." + serviceId;
		Map<String, String> serviceMap = null;
		serviceMap = RedisBaseUtil.hgetAll(key);
		return serviceMap;
	}

	public static void setUserServMainByUserId(String userId, Map<String, String> valueMap, int times) {
		if (userId == null || userId.equals("")) {
			return;
		}
		if (valueMap == null) {
			return;
		}
		if (times < 1) {
			return;
		}
		String serviceId = valueMap.get("serviceId");
		if (serviceId == null || serviceId.equals("")) {
			return;
		}
		String key = keyPrefix + userId + "." + serviceId;
		RedisBaseUtil.hmset(key, valueMap, times);
		// jedis.expire(key,times);

	}

	public static void deleteUserServMainListByUserId(String userId) {
		if (userId == null || userId.equals("")) {
			return;
		}
		String key = keyPrefix + userId + ".*";
		try {
			Set<String> keys = RedisBaseUtil.getKeys(key);
			if (keys == null) {
				return;
			}
			for (String keya : keys) {
				try {
					RedisBaseUtil.del(keya);
				} catch (Exception ex) {
					ex.printStackTrace();
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
