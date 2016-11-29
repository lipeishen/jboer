package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class MedicalAbroadProductCache {
	private final static String keyPrefix = "bh.medicalabroad.product.info.";
	public static Map<String,String> getProductInfoByProductId(String productId){
		String key = keyPrefix+productId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putProductInfoByProductMap(Map<String,String> productMap){
		String productId = productMap.get("productId");
		String key = keyPrefix+productId;
		if(productMap != null){
			RedisBaseUtil.hmset(key,productMap);
		}
	}
	
	public static void putProductInfoByProductList(List<Map<String,String>> productList){
		if(productList == null||productList.size() < 1){
			return;
		}
		for(int i = 0;i < productList.size();i++){
			Map<String,String> useinfoMap = productList.get(i);
			if(useinfoMap != null){
				String productId = useinfoMap.get("productId");
				String key = keyPrefix+productId;
				RedisBaseUtil.hmset(key,useinfoMap);
			}
		}
	}
	
	public static List<Map<String,String>> getProductInfoByProductList(){
		List<Map<String,String>> productList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		for(String key:keys){
			Map<String,String> productMap = RedisBaseUtil.hgetAll(key);
			productList.add(productMap);
		}
		return productList;
	}
	
	public static void deleteProductInfoByProductId(String productId){
		String key = keyPrefix+productId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteProductInfoByProductList(List<Map<String,String>> productList){
		if(productList == null||productList.size() < 1){
			return;
		}
		for(int i = 0;i < productList.size();i++){
			try{
				Map<String,String> productMap = productList.get(i);
				String productId = productMap.get("productId");
				String key = keyPrefix+productId;
				
				RedisBaseUtil.del(key);
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deleteProductInfoAll(){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		for(String key:keys){
			try{
				RedisBaseUtil.del(key);
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
	}
}
