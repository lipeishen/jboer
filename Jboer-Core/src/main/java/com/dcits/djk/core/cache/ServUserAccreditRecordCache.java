package com.dcits.djk.core.cache;

import java.util.List;
import java.util.Map;

import com.dcits.djk.core.util.RedisBaseUtil;

public class ServUserAccreditRecordCache {

	private final static String keyPrefix = "bh.serv.user.accredit.record.";

	public static Map<String, String> getServMainInfoByCon(String userId, String serviceId) {
		String key = keyPrefix + serviceId + userId;
		Map<String, String> servMainMap = null;
		servMainMap = RedisBaseUtil.hgetAll(key);
		return servMainMap;
	}
	
	public static void putServMainInfoByMap(Map<String,String > map){
		
		try {
			if (map != null) {
				String serviceId = map.get("serviceId");
				String userId = map.get("userId");
				String key = keyPrefix + serviceId + userId;
				RedisBaseUtil.hmset(key, map);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void putServMainInfoByServMainInfoByCon(List<Map<String, String>> servMainList) {
		if (servMainList == null || servMainList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < servMainList.size(); i++) {
				try {
					Map<String, String> servMainMap = servMainList.get(i);
					if (servMainMap != null) {
						String serviceId = servMainMap.get("serviceId");
						String userId = servMainMap.get("userId");
						String key = keyPrefix + serviceId + userId;
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

}
