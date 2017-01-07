package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class SysDictCityCache {
	private final static String keyPrefix = "bh.sys.dict.city.";

	public static Map<String, String> getCityBycity_code(String city_code) {
		String key = keyPrefix + city_code;
		Map<String, String> routerMap = null;
		routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}

	public static Map<String, String> getCityByProvinceId(String provinceId) {
		String key = keyPrefix + provinceId;
		Map<String, String> routerMap = null;
		routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}

	public static void putDictCityByCityMap(Map<String, String> cityMap) {
		String city_code = cityMap.get("city_code");
		String key = keyPrefix + city_code;
		RedisBaseUtil.hmset(key, cityMap);
	}

	public static void putDictCityByCityList(List<Map<String, String>> cityList) {
		if (cityList == null || cityList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < cityList.size(); i++) {
				Map<String, String> cityMap = cityList.get(i);
				if (cityMap != null) {
					String city_code = cityMap.get("city_code");
					String key = keyPrefix + city_code;
					RedisBaseUtil.hmset(key, cityMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Map<String, String>> getDictCityByCityList() {
		List<Map<String, String>> cityList = new ArrayList<Map<String, String>>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					Map<String, String> cityMap = RedisBaseUtil.hgetAll(key);
					cityList.add(cityMap);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cityList;
	}

	public static void deleteDictCityBycity_code(String city_code) {
		String key = keyPrefix + city_code;
		RedisBaseUtil.del(key);

	}

	public static void deleteDictCityByCityList(List<Map<String, String>> cityList) {
		if (cityList == null || cityList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < cityList.size(); i++) {
				Map<String, String> cityMap = cityList.get(i);
				String city_code = cityMap.get("city_code");
				String key = keyPrefix + city_code;
				RedisBaseUtil.del(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteDictCityAll() {
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					RedisBaseUtil.del(key);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
