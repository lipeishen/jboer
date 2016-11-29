package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class MedicalAbroadProductOrgCache {
	private final static String keyPrefix = "bh.medicalabroad.product.org.";
	public static Map<String,String> getProductOrgInfoByProductOrgId(String productOrgId){
		String key = keyPrefix+productOrgId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putProductOrgInfoByProductOrgMap(Map<String,String> areaMap){
		String productOrgId = areaMap.get("productOrgId");
		String key = keyPrefix+productOrgId;
		if(areaMap != null){
			RedisBaseUtil.hmset(key,areaMap);
		}
	}
	
	public static void putProductOrgInfoByProductOrgList(List<Map<String,String>> areaList){
		if(areaList == null||areaList.size() < 1){
			return;
		}
		for(int i = 0;i < areaList.size();i++){
			Map<String,String> useinfoMap = areaList.get(i);
			if(useinfoMap != null){
				String productOrgId = useinfoMap.get("productOrgId");
				String key = keyPrefix+productOrgId;
				RedisBaseUtil.hmset(key,useinfoMap);
			}
		}
	}
	
	public static List<Map<String,String>> getProductOrgInfoByProductOrgList(){
		List<Map<String,String>> areaList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		for(String key:keys){
			Map<String,String> areaMap = RedisBaseUtil.hgetAll(key);
			areaList.add(areaMap);
		}
		return areaList;
	}
	
	public static void deleteProductOrgInfoByProductOrgId(String productOrgId){
		String key = keyPrefix+productOrgId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteProductOrgInfoByProductOrgList(List<Map<String,String>> areaList){
		if(areaList == null||areaList.size() < 1){
			return;
		}
		for(int i = 0;i < areaList.size();i++){
			try{
				Map<String,String> areaMap = areaList.get(i);
				String productOrgId = areaMap.get("productOrgId");
				String key = keyPrefix+productOrgId;
				RedisBaseUtil.del(key);
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deleteProductOrgInfoAll(){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if(keys != null){
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
}
