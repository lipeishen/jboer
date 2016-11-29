package com.dcits.djk.core.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.dcits.djk.core.util.RedisBaseUtil;
import com.dcits.djk.core.util.StringUtil;

public class MedicalAbroadProductListCache {
	private final static String keyPrefix = "bh.medicalabroad.product.infolist.";

	public static String[] getProductArrayByOrgId(String orgId) {
		String key = keyPrefix + orgId;
		String[] productArray = null;
		String product = RedisBaseUtil.get(key);
		if (product != null && !product.equals("")) {
			productArray = product.split(",");
		}
		return productArray;
	}

	public static String getProductsByOrgId(String orgId) {
		String key = keyPrefix + orgId;
		String products = null;
		products = RedisBaseUtil.get(key);
		return products;
	}

	public static void putProductArrayByOrgId(String orgId, String[] productArray) {
		String key = keyPrefix + orgId;
		if (productArray != null && productArray.length > 0) {
			String products = StringUtil.strarrayToStr(productArray);
			RedisBaseUtil.set(key, products);
		}

	}

	public static void putProductArrayByOrgId(String orgId, String products) {
		String key = keyPrefix + orgId;
		if (products != null && !products.equals("")) {
			RedisBaseUtil.set(key, products);
		}
	}

	public static void putProductArrayByProductMap(Map<String, String> productMap) {
		if (productMap == null) {
			return;
		}
		try {
			Set<Entry<String, String>> keyvalueset = productMap.entrySet();
			for (Entry<String, String> entry : keyvalueset) {
				String key = keyPrefix + entry.getKey();
				String value = entry.getValue();
				if (value != null && !value.equals("")) {
					RedisBaseUtil.set(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void putProductArrayByProductMapArray(Map<String, String[]> productMap) {
		if (productMap == null) {
			return;
		}
		try {
			Set<Entry<String, String[]>> keyvalueset = productMap.entrySet();
			for (Entry<String, String[]> entry : keyvalueset) {
				String key = keyPrefix + entry.getKey();
				String[] values = entry.getValue();
				String value = StringUtil.strarrayToStr(values);
				if (value != null && !value.equals("")) {
					RedisBaseUtil.set(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map<String, String> getProductMapAll() {
		Map<String, String> productMap = new HashMap<String, String>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					String products = RedisBaseUtil.get(key);
					productMap.put(key, products);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productMap;
	}

	public static Map<String, String[]> getProductMapArrayAll() {
		Map<String, String[]> productMap = new HashMap<String, String[]>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					String products = RedisBaseUtil.get(key);
					String[] productArray = StringUtil.strToStrarray(products);
					productMap.put(key, productArray);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productMap;
	}

	public static void deleteProductArrayByOrgId(String orgId) {
		String key = keyPrefix + orgId;
		RedisBaseUtil.del(key);
	}

	public static void deleteProductArrayByHospitalMap(String orgIds) {
		if (orgIds == null || orgIds.equals("")) {
			return;
		}
		try {
			String[] orgIdArray = StringUtil.strToStrarray(orgIds);
			for (int i = 0; i < orgIdArray.length; i++) {
				String orgId = orgIdArray[i];
				String key = keyPrefix + orgId;
				RedisBaseUtil.del(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteProductArrayByHospitalMap(String[] orgIdArray) {
		if (orgIdArray == null || orgIdArray.length < 1) {
			return;
		}
		try {
			for (int i = 0; i < orgIdArray.length; i++) {
				String orgId = orgIdArray[i];
				String key = keyPrefix + orgId;
				RedisBaseUtil.del(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteProductArrayAll() {
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			for (String key : keys) {
				RedisBaseUtil.del(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
