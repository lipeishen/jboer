package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;


public class SysDictCountryCache {
	private final static String keyPrefix = "bh.sys.dict.country.";

	public static Map<String, String> getCountryBycountry_code(String country_code) {
		String key = keyPrefix + country_code;
		Map<String, String> routerMap = null;
		routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}

	public static void putDictCountryByCountryMap(Map<String, String> countryMap) {
		String country_code = countryMap.get("country_code");
		String key = keyPrefix + country_code;
		if (countryMap != null) {
			RedisBaseUtil.hmset(key, countryMap);
		}

	}

	public static void putDictCountryByCountryList(List<Map<String, String>> countryList) {
		if (countryList == null || countryList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < countryList.size(); i++) {
				Map<String, String> countryMap = countryList.get(i);
				if (countryMap != null) {
					String country_code = countryMap.get("country_code");
					String key = keyPrefix + country_code;
					RedisBaseUtil.hmset(key, countryMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Map<String, String>> getDictCountryByCountryList() {
		List<Map<String, String>> countryList = new ArrayList<Map<String, String>>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					Map<String, String> countryMap = RedisBaseUtil.hgetAll(key);
					countryList.add(countryMap);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryList;
	}

	public static void deleteDictCountryBycountry_code(String country_code) {
		String key = keyPrefix + country_code;
		RedisBaseUtil.del(key);

	}

	public static void deleteDictCountryByCountryList(List<Map<String, String>> countryList) {
		if (countryList == null || countryList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < countryList.size(); i++) {
				try {
					Map<String, String> countryMap = countryList.get(i);
					String country_code = countryMap.get("country_code");
					String key = keyPrefix + country_code;
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

	public static void deleteDictCountryAll() {
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
