package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class ServiceRouterCache {
	private final static String keyPrefix = "bh.sys.serv.router.";

	public static Map<String, String> getRouterInfoByServiceName(String serviceName) {
		String key = keyPrefix + serviceName;
		Map<String, String> routerMap = null;
		routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}

	public static void putRouterInfoByRouterMap(Map<String, String> routerMap) {
		String serviceName = routerMap.get("serviceName");
		String key = keyPrefix + serviceName;
		if (routerMap != null) {
			RedisBaseUtil.hmset(key, routerMap);
		}

	}

	public static void putRouterInfoByRouterList(List<Map<String, String>> routerList) {
		if (routerList == null || routerList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < routerList.size(); i++) {
				try {
					Map<String, String> routerMap = routerList.get(i);
					if (routerMap != null) {
						String serviceName = routerMap.get("serviceName");
						String key = keyPrefix + serviceName;
						RedisBaseUtil.hmset(key, routerMap);
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

	public static List<Map<String, String>> getRouterInfoByRouterList() {
		List<Map<String, String>> routerList = new ArrayList<Map<String, String>>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					Map<String, String> routerMap = RedisBaseUtil.hgetAll(key);
					routerList.add(routerMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return routerList;
	}

	public static void deleteRouterInfoByServiceName(String serviceName) {
		String key = keyPrefix + serviceName;
		RedisBaseUtil.del(key);

	}

	public static void deleteRouterInfoByRouterList(List<Map<String, String>> routerList) {
		if (routerList == null || routerList.size() < 1) {
			return;
		}
		for (int i = 0; i < routerList.size(); i++) {
			try {
				Map<String, String> routerMap = routerList.get(i);
				String serviceName = routerMap.get("serviceName");
				String key = keyPrefix + serviceName;
				RedisBaseUtil.del(key);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}
	}

	public static void deleteRouterInfoAll() {
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
		for (String key : keys) {
			try {
				RedisBaseUtil.del(key);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}

	}
}
