package com.dcits.djk.core.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.dcits.djk.core.util.RedisBaseUtil;
import com.dcits.djk.core.util.StringUtil;

public class MedicalAbroadProductOrgListCahce {
	private final static String keyPrefix = "bh.medicalabroad.product.orgList.";

	public static String[] getProductOrgArrayByAreaId(String productAreaId) {
		String key = keyPrefix + productAreaId;
		String[] productOrgArray = null;
		String productOrg = RedisBaseUtil.get(key);
		if (productOrg != null && !productOrg.equals("")) {
			productOrgArray = productOrg.split(",");
		}
		return productOrgArray;
	}

	public static String getProductOrgsByAreaId(String productAreaId) {
		String key = keyPrefix + productAreaId;
		String productOrgs = null;
		productOrgs = RedisBaseUtil.get(key);
		return productOrgs;
	}

	public static void putProductOrgArrayByAreaId(String productAreaId, String[] productOrgArray) {
		String key = keyPrefix + productAreaId;
		if (productOrgArray != null && productOrgArray.length > 0) {
			String productOrgs = StringUtil.strarrayToStr(productOrgArray);
			RedisBaseUtil.set(key, productOrgs);
		}

	}

	public static void putProductOrgArrayByAreaId(String productAreaId, String productOrgs) {
		String key = keyPrefix + productAreaId;
		if (productOrgs != null && !productOrgs.equals("")) {
			RedisBaseUtil.set(key, productOrgs);
		}

	}

	public static void putProductOrgArrayByProductOrgMap(Map<String, String> productOrgMap) {
		if (productOrgMap == null) {
			return;
		}
		Set<Entry<String, String>> keyvalueset = productOrgMap.entrySet();
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

	public static void putProductOrgArrayByProductOrgMapArray(Map<String, String[]> productOrgMap) {
		if (productOrgMap == null) {
			return;
		}
		try {
			Set<Entry<String, String[]>> keyvalueset = productOrgMap.entrySet();
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

	public static Map<String, String> getProductOrgMapAll() {
		Map<String, String> productOrgMap = new HashMap<String, String>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			for (String key : keys) {
				String productOrgs = RedisBaseUtil.get(key);
				productOrgMap.put(key, productOrgs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productOrgMap;
	}

	public static Map<String, String[]> getProductOrgMapArrayAll() {
		Map<String, String[]> productOrgMap = new HashMap<String, String[]>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			for (String key : keys) {
				String productOrgs = RedisBaseUtil.get(key);
				String[] productOrgArray = StringUtil.strToStrarray(productOrgs);
				productOrgMap.put(key, productOrgArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productOrgMap;
	}

	public static void deleteProductOrgArrayByAreaId(String productAreaId) {
		String key = keyPrefix + productAreaId;
		RedisBaseUtil.del(key);
	}

	public static void deleteProductOrgArrayByProductOrgMap(String productAreaIds) {
		if (productAreaIds == null || productAreaIds.equals("")) {
			return;
		}
		String[] productAreaIdArray = StringUtil.strToStrarray(productAreaIds);
		for (int i = 0; i < productAreaIdArray.length; i++) {
			try {
				String productAreaId = productAreaIdArray[i];
				String key = keyPrefix + productAreaId;
				RedisBaseUtil.del(key);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}
	}

	public static void deleteProductOrgArrayByAreaMap(String[] productAreaIdArray) {
		if (productAreaIdArray == null || productAreaIdArray.length < 1) {
			return;
		}
		for (int i = 0; i < productAreaIdArray.length; i++) {
			try {
				String productAreaId = productAreaIdArray[i];
				String key = keyPrefix + productAreaId;
				RedisBaseUtil.del(key);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}

	}

	public static void deleteProductOrgArrayAll() {
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
