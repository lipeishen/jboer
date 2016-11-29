package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class ExaminationCenterInfoCache {
	/**
	 * key:
	 */
	private final static String keyPrefix = "bh.examination.center.info.";
	
	public static Map<String,String> getExaminationCenterByExaminationCenterId(String examinationCenterId){
		Map<String,String> centerMap = null;
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+examinationCenterId);
			if (keys!=null) {
				for(String key : keys){
				  centerMap = RedisBaseUtil.hgetAll(key);
				}
			}
		return centerMap;
	}
	
	public static List<Map<String,String>> getExaminationCenterListByCenterIds(List<String> list){
		List<Map<String,String>> examinationCenterList = new ArrayList<Map<String,String>>();
		if (list!=null) {
			for (String centerId : list) {
				Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+centerId);
				if (keys!=null) {
					for(String key:keys){
						Map<String,String> examinationCenterMap = RedisBaseUtil.hgetAll(key);
						examinationCenterList.add(examinationCenterMap);
					}
				}
				
			}
		}	
		
		return examinationCenterList;
	}
	
	public static List<Map<String,String>> getExaminationCenterListByAreaId(String areaId){
		List<Map<String,String>> examinationCenterList = new ArrayList<Map<String,String>>();
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+areaId+".*");
			if (keys!=null) {
				for(String key:keys){
					Map<String,String> examinationCenterMap = RedisBaseUtil.hgetAll(key);
					examinationCenterList.add(examinationCenterMap);
				}
			}
			
		return examinationCenterList;
	}
	
	public static void putExaminationCenterByExaminationCenterMap(Map<String,String> examinationCenterMap){
		String examinationCenterId = examinationCenterMap.get("centerId");
		String areaId = examinationCenterMap.get("areaId");
		String key = keyPrefix+areaId+"."+examinationCenterId;
			if(examinationCenterMap != null){
				RedisBaseUtil.hmset(key,examinationCenterMap);
			}
		
	}
	
	public static void putExaminationCenterByExaminationCenterList(List<Map<String,String>> examinationCenterList){
		if(examinationCenterList == null||examinationCenterList.size() < 1){
			return;
		}
			for(int i = 0;i < examinationCenterList.size();i++){
				Map<String,String> examinationCenterMap = examinationCenterList.get(i);
				if(examinationCenterMap != null){
					String examinationCenterId = examinationCenterMap.get("centerId");
					String areaId = examinationCenterMap.get("areaId");
					String key = keyPrefix+areaId+"."+examinationCenterId;
					RedisBaseUtil.hmset(key,examinationCenterMap);
				}
			}
	}
	
	public static List<Map<String,String>> getExaminationCenterByExaminationCenterList(){
		List<Map<String,String>> examinationCenterList = new ArrayList<Map<String,String>>();
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
			if (keys!=null) {
				for(String key:keys){
					Map<String,String> examinationCenterMap = RedisBaseUtil.hgetAll(key);
					examinationCenterList.add(examinationCenterMap);
				}	
			}
		
		return examinationCenterList;
	}
	
	public static void deleteExaminationCenterByExaminationCenterId(String examinationCenterId){
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+examinationCenterId);
			if (keys!=null) {
				for (String key : keys) {
					RedisBaseUtil.del(key);
				}
			}
			
	}
	
	public static void deleteExaminationCenterByExaminationCenterList(List<Map<String,String>> examinationCenterList){
		if(examinationCenterList == null || examinationCenterList.size() < 1){
			return;
		}
			for(int i = 0;i < examinationCenterList.size();i++){
				try {
					Map<String,String> examinationCenterMap = examinationCenterList.get(i);
					String examinationCenterId = examinationCenterMap.get("centerId");
					String areaId = examinationCenterMap.get("areaId");
					String key = keyPrefix+areaId+"."+examinationCenterId;
					RedisBaseUtil.del(key);
				} catch(Exception ex){
					ex.printStackTrace();
					continue;
				}
			}
	}
	
	public static void deleteExaminationCenterAll(){
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
			if (keys!=null) {
			   for(String key:keys){
					RedisBaseUtil.del(key);
				}
			}
			
	}
}
