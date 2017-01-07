package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class EhrDataSourceCache {
	private final static String keyPrefix = "bh.auth.ehrdatasource.main.";

	// private final static int times = 60*60*24*2;
	public static Map<String, String> getDataSourceById(String dataSourceCode) {
		String key = keyPrefix + dataSourceCode;
		Map<String, String> routerMap =RedisBaseUtil.hgetAll(key);;
		return routerMap;
	}

	public static void putDataSourceByMap(String dataSourceCode, Map<String, String> sourceMap) {
		String key = keyPrefix + dataSourceCode;
			if (sourceMap != null) {
				RedisBaseUtil.hmset(key, sourceMap);
			}
	}

	public static void putDataSourceByList(List<Map<String, String>> sourceList) {
		if (sourceList == null || sourceList.size() < 1) {
			return;
		}
			for (int i = 0; i < sourceList.size(); i++) {
				try {
					Map<String, String> sourceMap = sourceList.get(i);
					if (sourceMap != null) {
						String dataSourceCode = sourceMap.get("dataSourceCode");
						String key = keyPrefix + dataSourceCode;
						RedisBaseUtil.hmset(key, sourceMap);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}

	public static List<Map<String, String>> getDataSourceByList() {
		List<Map<String, String>> sourceList = new ArrayList<Map<String, String>>();
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys!=null) {
				for (String key : keys) {
					Map<String, String> sourceMap = RedisBaseUtil.hgetAll(key);
					sourceList.add(sourceMap);
				}
			}
			
		return sourceList;
	}

	public static void deleteDataSourceBydataSourceCode(String dataSourceCode) {
		String key = keyPrefix + dataSourceCode;
		RedisBaseUtil.del(key);
	}

	public static void deleteDataSourceByUserList(List<Map<String, String>> DataSourceList) {
		if (DataSourceList == null || DataSourceList.size() < 1) {
			return;
		}
			for (int i = 0; i < DataSourceList.size(); i++) {
				try {
					Map<String, String> DataSourceMap = DataSourceList.get(i);
					String dataSourceCode = DataSourceMap.get("dataSourceCode");
					String key = keyPrefix + dataSourceCode;
					RedisBaseUtil.del(key);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}

	public static void deleteDataSourceAll() {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys!=null) {
				for (String key : keys) {
					RedisBaseUtil.del(key);
				}
			}
	}
}
