package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class MedicalAbroadAreaCache {
	private final static String keyPrefix = "bh.medicalabroad.area.info.";
	public static Map<String,String> getAreaInfoByAreaId(String areaId){
		String key = keyPrefix+areaId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putAreaInfoByAreaMap(Map<String,String> areaMap){
		String areaId = areaMap.get("areaId");
		String key = keyPrefix+areaId;
		if(areaMap != null){
			RedisBaseUtil.hmset(key,areaMap);
		}
	}
	
	public static void putAreaInfoByAreaList(List<Map<String,String>> areaList){
		if(areaList == null||areaList.size() < 1){
			return;
		}
		for(int i = 0;i < areaList.size();i++){
			Map<String,String> useinfoMap = areaList.get(i);
			if(useinfoMap != null){
				String areaId = useinfoMap.get("areaId");
				String key = keyPrefix+areaId;
				RedisBaseUtil.hmset(key,useinfoMap);
			}
		}
	}
	
	public static List<Map<String,String>> getAreaInfoByAreaList(){
		List<Map<String,String>> areaList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		for(String key:keys){
			Map<String,String> areaMap = RedisBaseUtil.hgetAll(key);
			areaList.add(areaMap);
		}
		return areaList;
	}
	
	public static void deleteAreaInfoByAreaId(String areaId){
		String key = keyPrefix+areaId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteAreaInfoByAreaList(List<Map<String,String>> areaList){
		if(areaList == null||areaList.size() < 1){
			return;
		}
		for(int i = 0;i < areaList.size();i++){
			try{
				Map<String,String> areaMap = areaList.get(i);
				String areaId = areaMap.get("areaId");
				String key = keyPrefix+areaId;
				RedisBaseUtil.del(key);
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deleteAreaInfoAll(){
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
