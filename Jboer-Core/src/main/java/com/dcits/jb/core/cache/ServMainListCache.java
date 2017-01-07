package com.dcits.jb.core.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.dcits.jb.core.util.RedisBaseUtil;
import com.dcits.jb.core.util.StringUtil;

public class ServMainListCache {
	private final static String keyPrefix = "bh.serv.main.list.";

	public static String[] getServMainArrayByGroupId(String groupId) {
		String key = keyPrefix + groupId;
		String[] servMainArray = null;
		String servMains = RedisBaseUtil.get(key);
		if (servMains != null && !servMains.equals("")) {
			servMainArray = servMains.split(",");
		}
		return servMainArray;
	}

	public static String getServMainsByGroupId(String groupId) {
		String key = keyPrefix + groupId;
		String servMains = null;
		servMains = RedisBaseUtil.get(key);
		return servMains;
	}

	public static void putServMainArrayByGroupId(String groupId, String[] servMainArray) {
		String key = keyPrefix + groupId;
		if (servMainArray != null && servMainArray.length > 0) {
			String servMains = StringUtil.strarrayToStr(servMainArray);
			RedisBaseUtil.set(key, servMains);
		}
	}

	public static void putServMainArrayByGroupId(String groupId, String servMains) {
		String key = keyPrefix + groupId;
		if (servMains != null && !servMains.equals("")) {
			RedisBaseUtil.set(key, servMains);
		}

	}

	public static void putServMainArrayByServMainMap(Map<String, String> servMainMap) {
		if (servMainMap == null) {
			return;
		}
		try {
			Set<Entry<String, String>> keyvalueset = servMainMap.entrySet();
			if (keyvalueset != null) {
				for (Entry<String, String> entry : keyvalueset) {
					try {
						String key = keyPrefix + entry.getKey();
						String value = entry.getValue();
						if (value != null && !value.equals("")) {
							RedisBaseUtil.set(key, value);
						}
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

	public static void putServMainArrayByServMainMapArray(Map<String, String[]> servMainMap) {
		if (servMainMap == null) {
			return;
		}
		try {
			Set<Entry<String, String[]>> keyvalueset = servMainMap.entrySet();
			for (Entry<String, String[]> entry : keyvalueset) {
				try {
					String key = keyPrefix + entry.getKey();
					String[] values = entry.getValue();
					String value = StringUtil.strarrayToStr(values);
					if (value != null && !value.equals("")) {
						RedisBaseUtil.set(key, value);
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

	public static Map<String, String> getServMainMapAll() {
		Map<String, String> servMainMap = new HashMap<String, String>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			for (String key : keys) {
				String servMains = RedisBaseUtil.get(key);
				String groupId = key.replaceAll(keyPrefix, "");
				servMainMap.put(groupId, servMains);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servMainMap;
	}

	public static Map<String, String[]> getServMainMapArrayAll() {
		Map<String, String[]> servMainMap = new HashMap<String, String[]>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			for (String key : keys) {
				String servMains = RedisBaseUtil.get(key);
				String[] servMainArray = StringUtil.strToStrarray(servMains);
				String groupId = key.replaceAll(keyPrefix, "");
				servMainMap.put(groupId, servMainArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servMainMap;
	}

	public static void deleteServMainArrayByGroupId(String groupId) {
		String key = keyPrefix + groupId;
		RedisBaseUtil.del(key);
	}

	public static void deleteServMainArrayByServMainMap(String groupIds) {
		if (groupIds == null || groupIds.equals("")) {
			return;
		}
		try {
			String[] groupIdArray = StringUtil.strToStrarray(groupIds);
			for (int i = 0; i < groupIdArray.length; i++) {
				try {
					String groupId = groupIdArray[i];
					String key = keyPrefix + groupId;
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

	public static void deleteServMainArrayByAreaMap(String[] groupIdArray) {
		if (groupIdArray == null || groupIdArray.length < 1) {
			return;
		}
		try {
			for (int i = 0; i < groupIdArray.length; i++) {
				try {
					String groupId = groupIdArray[i];
					String key = keyPrefix + groupId;
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

	public static void deleteServMainArrayAll() {
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
