package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class ExaminationItemTypeCache {
	
	/**
	 * key:keyPrefix+areaId+itemTypeId
	 */
	private final static String keyPrefix = "bh.examination.item.type.";
	
	public static Map<String,String> getItemTypeByItemId(String itemTypeId){
		Map<String,String> itemTypeMap = null;
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*." + itemTypeId);
		if (keys != null) {
			for(String key : keys){
				itemTypeMap = RedisBaseUtil.hgetAll(key);
			}
		}
		return itemTypeMap;
	}
	
	public static List<Map<String,String>> getItemTypeListByAreaId(String areaId){
		List<Map<String, String>> itemTypeMapList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+areaId+".*");
		if (keys != null) {
			for(String key : keys){
				Map<String,String> itemTypeMap = RedisBaseUtil.hgetAll(key);
				itemTypeMapList.add(itemTypeMap);
			}
		}
		return itemTypeMapList;
	}
	
	
	public static void putItemTypeByItemTypeMap(Map<String,String> itemTypeMap){
		String itemTypeId = itemTypeMap.get("itemTypeId");
		String areaId = itemTypeMap.get("areaId");
		String key = keyPrefix + areaId + "." + itemTypeId;
		if(itemTypeMap != null){
			RedisBaseUtil.hmset(key,itemTypeMap);
		}
	}
	
	public static void putItemTypeByItemTypeList(List<Map<String,String>> itemTypeList){
		if(itemTypeList == null||itemTypeList.size() < 1){
			return;
		}
		for(int i = 0;i < itemTypeList.size();i++){
			try {
				Map<String,String> itemTypeMap = itemTypeList.get(i);
				if(itemTypeMap != null){
					String itemTypeId = itemTypeMap.get("itemTypeId");
					String areaId = itemTypeMap.get("areaId");
					String key = keyPrefix + areaId + "." + itemTypeId;
					RedisBaseUtil.hmset(key,itemTypeMap);
				}
			} catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static List<Map<String,String>> getItemTypeAllList(){
		List<Map<String,String>> itemTypeList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if (keys!=null) {
			for(String key:keys){
				Map<String,String> itemTypeMap = RedisBaseUtil.hgetAll(key);
				itemTypeList.add(itemTypeMap);
			}
		}
		return itemTypeList;
	}
	
	public static void deleteItemTypeByItemTypeId(String itemTypeId){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+itemTypeId);
		if (keys!=null) {
			for (String key : keys) {
				RedisBaseUtil.del(key);
			}
		}
	}
	
	public static void deleteItemTypeByItemTypeList(List<Map<String,String>> itemTypeList){
		if(itemTypeList == null || itemTypeList.size() < 1){
			return;
		}
		for(int i = 0;i < itemTypeList.size();i++){
			Map<String,String> itemTypeMap = itemTypeList.get(i);
			String itemTypeId = itemTypeMap.get("itemTypeId");
			String areaId = itemTypeMap.get("areaId");
			String key = keyPrefix + areaId + "." + itemTypeId;
			RedisBaseUtil.del(key);
		}
	}
	
	public static void deleteItemTypeAll(){
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
			if (keys!=null) {
				for(String key:keys){
					RedisBaseUtil.del(key);
				}	
			}
			
	}
}
