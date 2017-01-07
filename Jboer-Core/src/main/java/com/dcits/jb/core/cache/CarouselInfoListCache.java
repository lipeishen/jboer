package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.dcits.jb.core.util.RedisBaseUtil;
import com.dcits.jb.core.util.StringUtil;

public class CarouselInfoListCache {
	private final static String keyPrefix = "bh.sys.carousel.infolist.";

	public static String[] getCarouselArrayByCarouselGroupId(String carouselGroupId) {
		String key = keyPrefix + carouselGroupId;
		String[] carouselGroupArray = null;
		String carouselGroup = RedisBaseUtil.get(key);
		if (carouselGroup != null && !carouselGroup.equals("")) {
			carouselGroupArray = carouselGroup.split(",");
		}
		return carouselGroupArray;
	}
	
	public static List<Map<String,String>> getCarouselInfoListByCarouselGroupId(String carouselGroupId) {
		String key = keyPrefix + carouselGroupId;
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		String[] carouselGroupArray = null;
		String carouselGroup = RedisBaseUtil.get(key);
		if (carouselGroup != null && !carouselGroup.equals("")) {
			carouselGroupArray = carouselGroup.split(",");
			for(int i=0;i<carouselGroupArray.length;i++){
				String carouselId=carouselGroupArray[i];
				if(carouselId.equals("")){
					continue;
				}
				String key2 = "bh.sys.carousel.info."+carouselId;
				Map<String,String> routerMap = RedisBaseUtil.hgetAll(key2);
				list.add(routerMap);
			}
		}
		return list;
	}

	public static String getCarouselsByCarouselGroupId(String carouselGroupId) {
		String key = keyPrefix + carouselGroupId;
		String carouselGroups = null;
		carouselGroups = RedisBaseUtil.get(key);
		return carouselGroups;
	}

	public static void putCarouselArrayByCarouselGroupId(String carouselGroupId, String[] carouselGroupArray) {
		String key = keyPrefix + carouselGroupId;
		if (carouselGroupArray != null && carouselGroupArray.length > 0) {
			String carouselGroups = StringUtil.strarrayToStr(carouselGroupArray);
			RedisBaseUtil.set(key, carouselGroups);
		}

	}

	public static void putCarouselArrayByCarouselGroupId(String carouselGroupId, String carouselGroups) {
		String key = keyPrefix + carouselGroupId;
		if (carouselGroups != null && !carouselGroups.equals("")) {
			RedisBaseUtil.set(key, carouselGroups);
		}

	}

	public static void putCarouselArrayByCarouselMap(Map<String, String> carouselGroupMap) {
		if (carouselGroupMap == null) {
			return;
		}
		Set<Entry<String, String>> keyvalueset = carouselGroupMap.entrySet();
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

	public static void putCarouselArrayByCarouselMapArray(Map<String, String[]> carouselGroupMap) {
		if (carouselGroupMap == null) {
			return;
		}
		try {
			Set<Entry<String, String[]>> keyvalueset = carouselGroupMap.entrySet();
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

	public static Map<String, String> getCarouselMapAll() {
		Map<String, String> carouselGroupMap = new HashMap<String, String>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			for (String key : keys) {
				String carouselGroups = RedisBaseUtil.get(key);
				carouselGroupMap.put(key, carouselGroups);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carouselGroupMap;
	}

	public static Map<String, String[]> getCarouselMapArrayAll() {
		Map<String, String[]> carouselGroupMap = new HashMap<String, String[]>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			for (String key : keys) {
				String carouselGroups = RedisBaseUtil.get(key);
				String[] carouselGroupArray = StringUtil.strToStrarray(carouselGroups);
				carouselGroupMap.put(key, carouselGroupArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carouselGroupMap;
	}

	public static void deleteCarouselArrayByCarouselGroupId(String carouselGroupId) {
		String key = keyPrefix + carouselGroupId;
		RedisBaseUtil.del(key);
	}

	public static void deleteCarouselArrayByCarouselMap(String carouselGroupIds) {
		if (carouselGroupIds == null || carouselGroupIds.equals("")) {
			return;
		}
		String[] carouselGroupIdArray = StringUtil.strToStrarray(carouselGroupIds);
		for (int i = 0; i < carouselGroupIdArray.length; i++) {
			try {
				String carouselGroupId = carouselGroupIdArray[i];
				String key = keyPrefix + carouselGroupId;
				RedisBaseUtil.del(key);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}
	}

	public static void deleteCarouselArrayByAreaMap(String[] carouselGroupIdArray) {
		if (carouselGroupIdArray == null || carouselGroupIdArray.length < 1) {
			return;
		}
		for (int i = 0; i < carouselGroupIdArray.length; i++) {
			try {
				String carouselGroupId = carouselGroupIdArray[i];
				String key = keyPrefix + carouselGroupId;
				RedisBaseUtil.del(key);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}

	}

	public static void deleteCarouselArrayAll() {
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
