package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class AuthPromoterInfoCache {
	private final static String keyPrefix = "bh.auth.promoter.info.";
	
	public static Map<String,String> getPromoterInfoByPromoterId(String promoterId){
		Map<String,String> routerMap = null;
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+promoterId+".*");
		for(String key:keys){
			routerMap = RedisBaseUtil.hgetAll(key);
		}
		return routerMap;
	}
	
	public static Map<String,String> getPromoterInfoByMobilePhone(String mobilePhone){
		Map<String,String> routerMap = null;
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+mobilePhone+".*");
		for(String key:keys){
			routerMap = RedisBaseUtil.hgetAll(key);
		}
		return routerMap;
	}
	
	public static List<Map<String,String>> getPromoterInfoListByType(String promoterType){
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+promoterType);
		for(String key:keys){
			Map<String, String> promoterMap = RedisBaseUtil.hgetAll(key);
			list.add(promoterMap);
		}
		return list;
	}
	
	public static List<Map<String,String>> getPromoterInfoListByAreaId(String areaId){
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+areaId+".*");
		for(String key:keys){
			Map<String, String> promoterMap = RedisBaseUtil.hgetAll(key);
			list.add(promoterMap);
		}
		return list;
	}
	
	public static void putPromoterInfoByPromoterMap(Map<String,String> useinfoMap){
		if(useinfoMap != null){
			String promoterId = useinfoMap.get("promoterId");
			String areaId = useinfoMap.get("areaId");
			String promoterMobilePhone = useinfoMap.get("promoterMobilePhone");
			String promoterType = useinfoMap.get("promoterType");
			String key = keyPrefix+areaId+"."+promoterId+"."+promoterMobilePhone+"."+promoterType;
			RedisBaseUtil.hmset(key,useinfoMap);
		}
	}
	
	public static void putPromoterInfoByPromoterList(List<Map<String,String>> useinfoList){
		if(useinfoList == null||useinfoList.size() < 1){
			return;
		}
		for(int i = 0;i < useinfoList.size();i++){
			Map<String,String> useinfoMap = useinfoList.get(i);
			try{
				if(useinfoMap != null){
					String promoterId = useinfoMap.get("promoterId");
					String areaId = useinfoMap.get("areaId");
					String promoterMobilePhone = useinfoMap.get("promoterMobilePhone");
					String promoterType = useinfoMap.get("promoterType");
					String key = keyPrefix+areaId+"."+promoterId+"."+promoterMobilePhone+"."+promoterType;
					RedisBaseUtil.hmset(key,useinfoMap);
				}
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static List<Map<String,String>> getPromoterInfoByPromoterList(){
		List<Map<String,String>> promoterList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		for(String key:keys){
			Map<String,String> promoterMap = RedisBaseUtil.hgetAll(key);
			promoterList.add(promoterMap);
		}
		return promoterList;
	}
	
	public static void deletePromoterInfoByPromoterId(String promoterId){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+promoterId+".*");
		for(String key:keys){
			try{
				RedisBaseUtil.del(key);
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deletePromoterInfoByPromoterList(List<Map<String,String>> promoterinfoList){
		if(promoterinfoList == null||promoterinfoList.size() < 1){
			return;
		}
		for(int i = 0;i < promoterinfoList.size();i++){
			try{
				Map<String,String> promoterinfoMap = promoterinfoList.get(i);
				if(promoterinfoMap!= null){
					String promoterId = promoterinfoMap.get("promoterId");
					String areaId = promoterinfoMap.get("areaId");
					String promoterMobilePhone = promoterinfoMap.get("promoterMobilePhone");
					String promoterType = promoterinfoMap.get("promoterType");
					String key = keyPrefix+areaId+"."+promoterId+"."+promoterMobilePhone+"."+promoterType;
					RedisBaseUtil.del(key);
				}
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deletePromoterInfoAll(){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		for(String key:keys){
			try{
				RedisBaseUtil.del(key);
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
}
