package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class MedicalAbroadProductAreaCache {
	private final static String keyPrefix = "bh.medicalabroad.product.area.";
	public static Map<String,String> getProductAreaInfoByProductAreaId(String productAreaId){
		String key = keyPrefix+productAreaId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putProductAreaInfoByProductAreaMap(Map<String,String> areaMap){
		String productAreaId = areaMap.get("productAreaId");
		String key = keyPrefix+productAreaId;
		if(areaMap != null){
			RedisBaseUtil.hmset(key,areaMap);
		}
	}
	
	public static void putProductAreaInfoByProductAreaList(List<Map<String,String>> areaList){
		if(areaList == null||areaList.size() < 1){
			return;
		}
		for(int i = 0;i < areaList.size();i++){
			Map<String,String> useinfoMap = areaList.get(i);
			if(useinfoMap != null){
				String productAreaId = useinfoMap.get("productAreaId");
				String key = keyPrefix+productAreaId;
				RedisBaseUtil.hmset(key,useinfoMap);
			}
		}
	}
	
	public static List<Map<String,String>> getProductAreaInfoByProductAreaList(){
		List<Map<String,String>> areaList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		for(String key:keys){
			Map<String,String> areaMap = RedisBaseUtil.hgetAll(key);
			areaList.add(areaMap);
		}
		return areaList;
	}
	
	public static void deleteProductAreaInfoByProductAreaId(String productAreaId){
		String key = keyPrefix+productAreaId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteProductAreaInfoByProductAreaList(List<Map<String,String>> areaList){
		if(areaList == null||areaList.size() < 1){
			return;
		}
		for(int i = 0;i < areaList.size();i++){
			try{
				Map<String,String> areaMap = areaList.get(i);
				String productAreaId = areaMap.get("productAreaId");
				String key = keyPrefix+productAreaId;
				RedisBaseUtil.del(key);
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deleteProductAreaInfoAll(){
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
