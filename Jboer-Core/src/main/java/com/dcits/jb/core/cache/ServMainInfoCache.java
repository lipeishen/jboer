package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class ServMainInfoCache {
	private final static String keyPrefix = "bh.serv.main.info.";

	public static Map<String, String> getServMainInfoByServiceId(String serviceId) {
		String key = keyPrefix + serviceId;
		Map<String, String> servMainMap = null;
		servMainMap = RedisBaseUtil.hgetAll(key);
		return servMainMap;
	}

	public static void putServMainInfoByServMainMap(Map<String, String> servMainMap) {
		String serviceId = servMainMap.get("serviceId");
		String key = keyPrefix + serviceId;
		if (servMainMap != null) {
			RedisBaseUtil.hmset(key, servMainMap);
		}
	}

	public static void putServMainInfoByServMainList(List<Map<String, String>> servMainList) {
		if (servMainList == null || servMainList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < servMainList.size(); i++) {
				try {
					Map<String, String> servMainMap = servMainList.get(i);
					if (servMainMap != null) {
						String serviceId = servMainMap.get("serviceId");
						String key = keyPrefix + serviceId;
						RedisBaseUtil.hmset(key, servMainMap);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Map<String, String>> getServMainInfoByServMainList() {
		List<Map<String, String>> servMainList = new ArrayList<Map<String, String>>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					Map<String, String> servMainMap = RedisBaseUtil.hgetAll(key);
					servMainList.add(servMainMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servMainList;
	}

	public static void deleteServMainInfoByServiceId(String serviceId) {
		String key = keyPrefix + serviceId;
		RedisBaseUtil.del(key);
	}

	public static void deleteServMainInfoByServMainList(List<Map<String, String>> servMainList) {
		if (servMainList == null || servMainList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < servMainList.size(); i++) {
				try {
					Map<String, String> servMainMap = servMainList.get(i);
					String serviceId = servMainMap.get("serviceId");
					String key = keyPrefix + serviceId;
					RedisBaseUtil.del(key);
				} catch (Exception ex) {
					ex.printStackTrace();
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteServMainInfoAll() {
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					try {
						RedisBaseUtil.del(key);
					} catch (Exception ex) {
						ex.printStackTrace();
						continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
