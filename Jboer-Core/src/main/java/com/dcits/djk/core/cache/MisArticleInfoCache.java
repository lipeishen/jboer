package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class MisArticleInfoCache {
	private final static String keyPrefix = "bh.mis.article.main.";
	
	public static Map<String,String> getArticleInfoByArticleId(String articleId){
		String key = keyPrefix+articleId;
		Map<String, String> articleMap = RedisBaseUtil.hgetAll(key);
		return articleMap;
	}
	public static void putArticleInfoByArticleMap(Map<String,String> articleMap){
		String articleId = articleMap.get("article_id");
		String key = keyPrefix+articleId;
		if(articleMap != null){
			RedisBaseUtil.hmset(key,articleMap);  
		}
	}
	public static void putArticleInfoByArticleList(List<Map<String,String>> articleList){
		if(articleList == null||articleList.size() < 1){
			return;
		}
		for(int i = 0;i < articleList.size();i++){
			try {
				Map<String,String> articleMap = articleList.get(i);
				if(articleMap != null){
					String articleId = articleMap.get("article_id");
					String key = keyPrefix+articleId;
					RedisBaseUtil.hmset(key,articleMap);
				}
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
			
		}
	}
	
	public static List<Map<String,String>> getArticleInfoByArticleList(){
		List<Map<String,String>> articleList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		for(String key:keys){
			Map<String,String> articleMap = RedisBaseUtil.hgetAll(key);
			articleList.add(articleMap);
		}
		return articleList;
	}
	
	public static List<Map<String,String>> getArticleInfoByArticleList(List<String> list){
		List<Map<String,String>> articleList = new ArrayList<Map<String,String>>();
		for(String key:list){
			Map<String,String> articleMap = RedisBaseUtil.hgetAll(keyPrefix+key);
			articleList.add(articleMap);
		}
		return articleList;
	}
	
	public static void deleteArticleInfoByArticleId(String articleId){
		String key = keyPrefix+articleId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteArticleInfoByArticleList(List<Map<String,String>> articleList){
		if(articleList == null||articleList.size() < 1){
			return;
		}
		for(int i = 0;i < articleList.size();i++){
			try{
				Map<String,String> articleMap = articleList.get(i);
				String articleId = articleMap.get("article_id");
				String key = keyPrefix+articleId;
				RedisBaseUtil.del(key);
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	public static void deleteArticleInfoAll(){
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
