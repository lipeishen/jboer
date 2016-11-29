package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;


public class SysDictProvinceCache {
	private final static String keyPrefix = "bh.sys.dict.province.";

	public static Map<String, String> getProvinceByprovince_code(String province_code) {
		String key = keyPrefix + province_code;
		Map<String, String> routerMap = null;
		routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}

	public static void putDictProvinceByProvinceMap(Map<String, String> provinceMap) {
		String province_code = provinceMap.get("province_code");
		String key = keyPrefix + province_code;
		RedisBaseUtil.hmset(key, provinceMap);
	}

	public static void putDictProvinceByProvinceList(List<Map<String, String>> provinceList) {
		if (provinceList == null || provinceList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < provinceList.size(); i++) {
				Map<String, String> provinceMap = provinceList.get(i);
				if (provinceMap != null) {
					String province_code = provinceMap.get("province_code");
					String key = keyPrefix + province_code;
					RedisBaseUtil.hmset(key, provinceMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Map<String, String>> getDictProvinceByProvinceList() {
		List<Map<String, String>> provinceList = new ArrayList<Map<String, String>>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					Map<String, String> provinceMap = RedisBaseUtil.hgetAll(key);
					provinceList.add(provinceMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return provinceList;
	}

	public static void deleteDictProvinceByprovince_code(String province_code) {
		String key = keyPrefix + province_code;
		RedisBaseUtil.del(key);
	}

	public static void deleteDictProvinceByProvinceList(List<Map<String, String>> provinceList) {
		if (provinceList == null || provinceList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < provinceList.size(); i++) {
				try {
					Map<String, String> provinceMap = provinceList.get(i);
					String province_code = provinceMap.get("province_code");
					String key = keyPrefix + province_code;
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

	public static void deleteDictProvinceAll() {
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
