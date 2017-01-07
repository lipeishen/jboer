package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class NoticeTemplateCache {
	private final static String keyPrefix = "bh.auth.noticetemplate.";
	
	public static Map<String,String> getNoticeTemplateById(String templateId){
		String key = keyPrefix+templateId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putNoticeTemplateByTemplateMap(Map<String,String> templateMap){
		String templateId = templateMap.get("noticeTempCode");
		String key = keyPrefix+templateId;
		if(templateMap != null){
			RedisBaseUtil.hmset(key,templateMap);
		}
	}
	
	public static void putNoticeTemplateByTemplateList(List<Map<String,String>> TemplateList){
		if(TemplateList == null||TemplateList.size() < 1){
			return;
		}
		for(int i = 0;i < TemplateList.size();i++){
			try{
				Map<String,String> NoticeTempalteMap = TemplateList.get(i);
				if(NoticeTempalteMap != null){
					String templateId = NoticeTempalteMap.get("noticeTempCode");
					String key = keyPrefix+templateId;
					RedisBaseUtil.hmset(key,NoticeTempalteMap);
				}
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static List<Map<String,String>> getNoticeTemplateListByTempalteId(){
		List<Map<String,String>> TemplateList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if(keys != null){
			for(String key:keys){
				Map<String,String> TemplateMap = RedisBaseUtil.hgetAll(key);
				TemplateList.add(TemplateMap);
			}
		}
		return TemplateList;
	}
	
	public static void deleteNoticeTemplateByTemplateId(String tempalteId){
		String key = keyPrefix+tempalteId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteNoticeTempalteByTempalteList(List<Map<String,String>> TempalteList){
		if(TempalteList == null||TempalteList.size() < 1){
			return;
		}
		for(int i = 0;i < TempalteList.size();i++){
			try {
				Map<String,String> TemplateMap = TempalteList.get(i);
				String tempalteId = TemplateMap.get("noticeTempCode");
				String key = keyPrefix+tempalteId;
				RedisBaseUtil.del(key);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deleteNoticeTempalteAll(){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		for(String key:keys){
			try {
				RedisBaseUtil.del(key);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}

}
