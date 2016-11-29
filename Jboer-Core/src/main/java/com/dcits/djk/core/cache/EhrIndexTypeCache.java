package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class EhrIndexTypeCache {
	private final static String keyPrefix = "bh.auth.ehrindextype.main.";
	public static Map<String,String> getIndexTypeById(String indexTypeId){
		String key = keyPrefix+indexTypeId;
		Map<String,String> routerMap =  RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putIndexTypeByMap(String indexType,Map<String,String> indexTypeMap){
		String key = keyPrefix+indexType;
			if(indexTypeMap != null){
				RedisBaseUtil.hmset(key,indexTypeMap);
			}
	}
	
	public static void putIndexTypeByUserList(List<Map<String,String>> indexTypeList){
		if(indexTypeList == null||indexTypeList.size() < 1){
			return;
		}
			for(int i = 0;i < indexTypeList.size();i++){
				try {
					Map<String,String> useinfoMap = indexTypeList.get(i);
					if(useinfoMap != null){
						String indexTypeId = useinfoMap.get("indexTypeId");
						String key = keyPrefix+indexTypeId;
						RedisBaseUtil.hmset(key,useinfoMap);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	public static List<Map<String,String>> getIndexTypeByList(){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
			if(keys!=null){
				for(String key:keys){
					Map<String,String> map = RedisBaseUtil.hgetAll(key);
					list.add(map);
				}
			}
			
		return list;
	}
	
	public static void deleteIndexTypeByUserId(String indexTypeId){
		String key = keyPrefix+indexTypeId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteIndexTypeByList(List<Map<String,String>> IndexTypeList){
		if(IndexTypeList == null||IndexTypeList.size() < 1){
			return;
		}
			for(int i = 0;i < IndexTypeList.size();i++){
				try {
					Map<String,String> IndexTypeMap = IndexTypeList.get(i);
					String userId = IndexTypeMap.get("userId");
					String key = keyPrefix+userId;
					RedisBaseUtil.del(key);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	public static void deleteIndexTypeAll(){
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
			if (keys!=null) {
				for(String key:keys){
					RedisBaseUtil.del(key);
				}
			}
			
	}
}
