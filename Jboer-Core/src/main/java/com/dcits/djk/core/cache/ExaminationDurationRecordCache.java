package com.dcits.djk.core.cache;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class ExaminationDurationRecordCache {
	private final static String keyPrefix = "bh.examination.duration.record";
	//keyPrefix+durationId+examinationDate+durationRecordId
	public static Map<String,String> getExaminationDurationRecordByDurationRecordId(String durationRecordId){
		Map<String,String> durationRecordMap = null;
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+".*."+durationRecordId);
			if (keys!=null) {
				for(String key:keys){
					durationRecordMap = RedisBaseUtil.hgetAll(key);
			 }	
			}
			
		return durationRecordMap;
	}
	
	public static List<Map<String,String>> getExaminationDurationRecordListByDurationIdAndDate(String durationId,String examinationDate){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> durationRecordMap = null;
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"."+durationId+"."+examinationDate+".*");
			if (keys!=null) {
			for(String key:keys){
					durationRecordMap = RedisBaseUtil.hgetAll(key);
					list.add(durationRecordMap);
				}
			}
		return list;
	}
	
	
	public static List<Map<String,String>> getExaminationDurationRecordListByDurationId(String durationId){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> durationRecordMap = null;
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"."+durationId+".*");
			if (keys!=null) {
				for(String key:keys){
					durationRecordMap = RedisBaseUtil.hgetAll(key);
					list.add(durationRecordMap);
			}	
			}
		
		return list;
	}
	
	public static void putExaminationDurationRecordByExaminationDurationRecordMap(Map<String,String> durationRecordMap){
		String durationRecordId = durationRecordMap.get("durationRecordId");
		String examinationDate = durationRecordMap.get("examinationDate");
		String durationId = durationRecordMap.get("durationId");
		String key = keyPrefix+"."+durationId+"."+examinationDate+"."+durationRecordId;
			if(durationRecordMap != null){
				String dt = durationRecordMap.get("examinationDate");
				String nowDt = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				if(dt.compareTo(nowDt) >= 0){
					RedisBaseUtil.hmset(key,durationRecordMap);
				}
			}
	}
	
	public static void putExaminationDurationRecordByExaminationDurationRecordList(List<Map<String,String>> durationRecordList){
		if(durationRecordList == null||durationRecordList.size() < 1){
			return;
		}
			for(int i = 0;i < durationRecordList.size();i++){
				try {
					Map<String,String> durationRecordMap = durationRecordList.get(i);
					if(durationRecordMap != null){
						String dt = durationRecordMap.get("examinationDate");
						String nowDt = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
						if(dt.compareTo(nowDt) >= 0){
							String durationRecordId = durationRecordMap.get("durationRecordId");
							String examinationDate = durationRecordMap.get("examinationDate");
							String durationId = durationRecordMap.get("durationId");
							String key = keyPrefix+"."+durationId+"."+examinationDate+"."+durationRecordId;
							RedisBaseUtil.hmset(key,durationRecordMap);
						}
					}
				} catch(Exception ex){
					ex.printStackTrace();
					continue;
				}
				
			}
	}
	
	public static List<Map<String,String>> getExaminationDurationRecordByExaminationDurationRecordList(){
		List<Map<String,String>> durationRecordList = new ArrayList<Map<String,String>>();
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+".*");
			if (keys!=null) {
				for(String key:keys){
					Map<String,String> durationRecordMap = RedisBaseUtil.hgetAll(key);
					durationRecordList.add(durationRecordMap);
				}	
			}
			
		return durationRecordList;
	}
	
	public static void deleteExaminationDurationRecordByExaminationDurationRecordId(String durationRecordId){
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+".*."+durationRecordId);
			if (keys!=null) {
				for (String key : keys) {
					RedisBaseUtil.del(key);
				}	
			}
			
	}
	
	public static void deleteExaminationDurationRecordByExaminationDurationRecordList(List<Map<String,String>> durationRecordList){
		if(durationRecordList == null || durationRecordList.size() < 1){
			return;
		}
			for(int i = 0;i < durationRecordList.size();i++){
				Map<String,String> durationRecordMap = durationRecordList.get(i);
				String durationRecordId = durationRecordMap.get("durationRecordId");
				String examinationDate = durationRecordMap.get("examinationDate");
				String durationId = durationRecordMap.get("durationId");
				String key = keyPrefix+"."+durationId+"."+examinationDate+"."+durationRecordId;
				RedisBaseUtil.del(key);
			}
	}
	
	public static void deleteExaminationDurationRecordAll(){
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+".*");
			if (keys!=null) {
				for(String key:keys){
					RedisBaseUtil.del(key);
				}
			}
			
	}
}
