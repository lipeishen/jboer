package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;
/**
 * 时间段缓存
 * @author caoxiaoa
 *
 */
public class ExaminationDurationInfoCache {
	/**
	 * key:keyPrefix+centerId+durationId
	 */
	private final static String keyPrefix = "bh.examination.duration.info.";
	
	public static Map<String,String> getDurationByDurationId(String durationId){
		Map<String,String> durationMap = null;
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+durationId);
		if (keys!=null) {
			for(String key:keys){
				durationMap = RedisBaseUtil.hgetAll(key);
			}	
		}
		return durationMap;
	}
	
	
	public static List<Map<String, String>> getExaminationDurationListByCenterId(String centerId){
		Map<String,String> durationMap = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + centerId + ".*");
		if (keys!=null) {
			for(String key:keys){
				durationMap = RedisBaseUtil.hgetAll(key);
				list.add(durationMap);
			}
		}
		return list;
	}


	public static List<Map<String, String>> getExaminationDurationAllList() {
		Map<String,String> durationMap = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
			if (keys!=null) {
				for(String key:keys){
					durationMap = RedisBaseUtil.hgetAll(key);
					list.add(durationMap);
			}	
		}
		return list;
	}

	public static void putExaminationDurationByExaminationDuration(Map<String, String> durationMap) {
		String centerId = durationMap.get("centerId");
		String durationId = durationMap.get("durationId");
		if(durationMap != null){
			String key = keyPrefix + centerId + "." + durationId;
			RedisBaseUtil.hmset(key,durationMap);
		}
	}
	
	public static void putExaminationDurationByExaminationDurationList(List<Map<String, String>> allDurationList) {
		if(allDurationList == null||allDurationList.size() < 1){
			return;
		}
		for(int i = 0;i < allDurationList.size();i++){
			try {
				Map<String,String> examinationItemMap = allDurationList.get(i);
				if(examinationItemMap != null){
					String centerId = examinationItemMap.get("centerId");
					String durationId = examinationItemMap.get("durationId");
					String key = keyPrefix + centerId + "." + durationId;
					RedisBaseUtil.hmset(key,examinationItemMap);
				}
			} catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	
	public static void deleteExaminationDurationAll() {
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if (keys!=null) {
			for(String key:keys){
				RedisBaseUtil.del(key);
			}
		}
	}

	public static void deleteExaminationDurationByDurationId(String durationId) {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*."+durationId);
			if (keys!=null) {
			for(String key:keys){
				RedisBaseUtil.del(key);
			}
			}
	}

	
	public static void deleteExaminationDurationByCenterId(String centerId) {
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + centerId + ".*");
		if (keys!=null) {
			for(String key:keys){
				RedisBaseUtil.del(key);
			}
		}
	}
}
