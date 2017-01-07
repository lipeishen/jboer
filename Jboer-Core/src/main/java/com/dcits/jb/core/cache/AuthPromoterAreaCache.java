package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;


public class AuthPromoterAreaCache {
	private final static String keyPrefix = "bh.auth.promoter.area.";
	public static Map<String,String> getPromoterAreaByPromoterAreaId(String promoterAreaId){
		Map<String,String> routerMap = null;
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+promoterAreaId);
		for (String key : keys) {
			routerMap = RedisBaseUtil.hgetAll(key);
		}
		return routerMap;
	}
	
	public static void putPromoterAreaByPromoterAreaMap(Map<String,String> promoterAreaMap){
		String promoterAreaId = promoterAreaMap.get("areaId");
		String orgId = promoterAreaMap.get("orgId");
		String key = keyPrefix+orgId+"."+promoterAreaId;
		RedisBaseUtil.hmset(key, promoterAreaMap);
	}
	
	public static void putPromoterAreaBypromoterAreaList(List<Map<String,String>> areaList){
		if(areaList == null||areaList.size() < 1){
			return;
		}
		for(int i = 0;i < areaList.size();i++){
			Map<String,String> promoterAreaMap = areaList.get(i);
			if(promoterAreaMap != null){
				String promoterAreaId = promoterAreaMap.get("areaId");
				String orgId = promoterAreaMap.get("orgId");
				String key = keyPrefix+orgId+"."+promoterAreaId;
				RedisBaseUtil.hmset(key,promoterAreaMap);
			}
		}
	}
	
	public static List<Map<String,String>> getPromoterAreaListByOrgId(String orgId){
		List<Map<String,String>> promoterAreaList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+orgId+".*");
		for(String key:keys){
			Map<String,String> promoterAreaMap = RedisBaseUtil.hgetAll(key);
			promoterAreaList.add(promoterAreaMap);
		}
		return promoterAreaList;
	}
	
	public static List<Map<String,String>> getPromoterAreaBypromoterAreaList(){
		List<Map<String,String>> promoterAreaList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		for(String key:keys){
			Map<String,String> promoterAreaMap = RedisBaseUtil.hgetAll(key);
			promoterAreaList.add(promoterAreaMap);
		}
		return promoterAreaList;
	}
	
	public static void deletePromoterAreaBypromoterAreaId(String promoterAreaId){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+promoterAreaId);
		if(keys != null){
			for (String key : keys) {
				RedisBaseUtil.del(key);
			}
		}
	}
	
	public static void deletePromoterAreaBypromoterAreaList(List<Map<String,String>> promoterAreaList){
		if(promoterAreaList == null||promoterAreaList.size() < 1){
			return;
		}
		for(int i = 0;i < promoterAreaList.size();i++){
			try{
				Map<String,String> promoterAreaMap = promoterAreaList.get(i);
				String promoterAreaId = promoterAreaMap.get("areaId");
				Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+promoterAreaId);
				if(keys != null){
					for (String key : keys) {
						RedisBaseUtil.del(key);
					}
				}
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deletePromoterAreaAll(){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if(keys != null){
			for(String key:keys){
				RedisBaseUtil.del(key);
			}
		}
	}
}
