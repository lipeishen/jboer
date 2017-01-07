package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class ExaminationItemInfoCache {
	/**
	 * key:keyPrefix + centerId + itemTypeId + itemId
	 */
	private final static String keyPrefix = "bh.examination.item.info.";
	
	/**
	 * 根据体检项id查询体检项
	 * @param examinationItemId：体检项id
	 * @return
	 */
	public static Map<String,String> getExaminationItemByExaminationItemId(String examinationItemId){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+examinationItemId);
		Map<String, String> itemMap = new HashMap<String, String>();
		if(keys != null){
			for (String key : keys) {
				 itemMap = RedisBaseUtil.hgetAll(key);
			}
		}
		return itemMap;
	}
	
	
	public static List<Map<String, String>> getItemListByCenterId(String centerId){
		List<Map<String, String>> itemList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + centerId + ".*");
		if(keys != null){
			for (String key : keys) {
				Map<String, String> itemMap = RedisBaseUtil.hgetAll(key);
				itemList.add(itemMap);
			}
		}
		return itemList;
	}
	
	public static List<Map<String, String>> getItemListByCenterIdAndItemTypeId(String centerId,String itemTypeId){
		List<Map<String, String>> itemList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + centerId +"."+ itemTypeId + ".*");
		if(keys != null){
			for (String key : keys) {
				Map<String, String> itemMap = RedisBaseUtil.hgetAll(key);
				itemList.add(itemMap);
			}
		}
		return itemList;
	}
	public static List<Map<String, String>> getItemListByItemTypeId(String itemTyopeId){
		List<Map<String, String>> itemList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*." + itemTyopeId + ".*");
		if(keys != null){
			for (String key : keys) {
				Map<String, String> itemMap = RedisBaseUtil.hgetAll(key);
				itemList.add(itemMap);
			}
		}
		return itemList;
	}
	
	
	/**
	 * 查询所有的体检项
	 * @return
	 */
	public static List<Map<String,String>> getExaminationItemAllList(){
		List<Map<String,String>> examinationItemList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if (keys!=null) {
			for(String key:keys){
				Map<String,String> examinationItemMap = RedisBaseUtil.hgetAll(key);
				examinationItemList.add(examinationItemMap);
			}
		}
		return examinationItemList;
	}
	
	
	public static void putExaminationItemByExaminationItemMap(Map<String,String> examinationItemMap){
		String itemId = examinationItemMap.get("itemId");
		String itemTypeId =  examinationItemMap.get("itemTypeId");
		String centerId = examinationItemMap.get("centerId");
		String key = keyPrefix + centerId + "." + itemTypeId + "." + itemId;
		if(examinationItemMap != null){
			RedisBaseUtil.hmset(key,examinationItemMap);
		}
	}
	
	public static void putExaminationItemByExaminationItemList(List<Map<String,String>> examinationItemList){
		if(examinationItemList == null||examinationItemList.size() < 1){
			return;
		}
		for(int i = 0;i < examinationItemList.size();i++){
			try {
				Map<String,String> examinationItemMap = examinationItemList.get(i);
				if(examinationItemMap != null){
					String itemId = examinationItemMap.get("itemId");
					String itemTypeId =  examinationItemMap.get("itemTypeId");
					String centerId = examinationItemMap.get("centerId");
					String key = keyPrefix + centerId + "." + itemTypeId + "." + itemId;
					RedisBaseUtil.hmset(key,examinationItemMap);
				}
			} catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deleteExaminationItemByExaminationItemId(String examinationItemId){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*." + examinationItemId);
		if (keys!=null) {
			for (String key : keys) {
				RedisBaseUtil.del(key);
			}	
		}
	}
	
	public static void deleteExaminationItemByExaminationItemList(List<Map<String,String>> examinationItemList){
		if(examinationItemList == null || examinationItemList.size() < 1){
			return;
		}
		for(int i = 0;i < examinationItemList.size();i++){
			Map<String,String> examinationItemMap = examinationItemList.get(i);
			String examinationItemId = examinationItemMap.get("itemId");
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*." + examinationItemId);
			if (keys!=null) {
				for (String key : keys) {
					RedisBaseUtil.del(key);
				}	
			}
		}
	}
	
	public static void deleteExaminationItemAll(){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if (keys!=null) {
			for(String key:keys){
				RedisBaseUtil.del(key);
			}	
		}
	}
}
