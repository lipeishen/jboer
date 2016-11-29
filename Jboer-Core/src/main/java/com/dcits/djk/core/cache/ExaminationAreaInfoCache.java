package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class ExaminationAreaInfoCache {
	private final static String keyPrefix = "bh.examination.area.info.";
	public static Map<String,String> getExaminationAreaByExaminationAreaId(String examinationAreaId){
		String key = keyPrefix+examinationAreaId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putExaminationAreaByExaminationAreaMap(Map<String,String> examinationAreaMap){
		String examinationAreaId = examinationAreaMap.get("areaId");
		String key = keyPrefix+examinationAreaId;
			if(examinationAreaMap != null){
				RedisBaseUtil.hmset(key,examinationAreaMap);
			}
	}
	
	public static void putExaminationAreaByExaminationAreaList(List<Map<String,String>> examinationAreaList){
		if(examinationAreaList == null||examinationAreaList.size() < 1){
			return;
		}
			for(int i = 0;i < examinationAreaList.size();i++){
				try {
					Map<String,String> examinationAreaMap = examinationAreaList.get(i);
					if(examinationAreaMap != null){
						String examinationAreaId = examinationAreaMap.get("areaId");
						String key = keyPrefix+examinationAreaId;
						RedisBaseUtil.hmset(key,examinationAreaMap);
					}
				} catch(Exception ex){
					ex.printStackTrace();
					continue;
				}
			}
	}
	
	public static List<Map<String,String>> getExaminationAreaByExaminationAreaList(){
		List<Map<String,String>> examinationAreaList = new ArrayList<Map<String,String>>();
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
			if (keys!=null) {
				for(String key:keys){
					Map<String,String> examinationAreaMap = RedisBaseUtil.hgetAll(key);
					examinationAreaList.add(examinationAreaMap);
				}
			}
			
		return examinationAreaList;
	}
	
	public static void deleteExaminationAreaByExaminationAreaId(String examinationAreaId){
		String key = keyPrefix+examinationAreaId;
		RedisBaseUtil.del(key);
			
	}
	
	public static void deleteExaminationAreaByExaminationAreaList(List<Map<String,String>> examinationAreaList){
		if(examinationAreaList == null || examinationAreaList.size() < 1){
			return;
		}
			for(int i = 0;i < examinationAreaList.size();i++){
				Map<String,String> examinationAreaMap = examinationAreaList.get(i);
				String examinationAreaId = examinationAreaMap.get("areaId");
				String key = keyPrefix+examinationAreaId;
				RedisBaseUtil.del(key);
			}
	}
	
	public static void deleteExaminationAreaAll(){
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
			if (keys!=null) {
				for(String key:keys){
					RedisBaseUtil.del(key);
				}
			}
			
	}
}
