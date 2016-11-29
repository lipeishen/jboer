package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class EhrUserCache {
	private  static String  keyPrefix = "bh.auth.EhrUser.main.";
	public static Map<String,String> getEhrUserInfoByUserId(String userId){
		String key = keyPrefix+userId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putEhrUserInfoByUserMap(String userId,Map<String,String> useinfoMap){
		String key = keyPrefix+userId;
			if(useinfoMap != null){
				RedisBaseUtil.hmset(key,useinfoMap);
			}
	}
	
	public static void putEhrUserInfoByUserList(List<Map<String,String>> useinfoList){
		if(useinfoList == null||useinfoList.size() < 1){
			return;
		}
		for(int i = 0;i < useinfoList.size();i++){
				try {
					Map<String,String> useinfoMap = useinfoList.get(i);
					if(useinfoMap != null){
						String userId = useinfoMap.get("userId");
						String key =keyPrefix+userId;
						RedisBaseUtil.hmset(key,useinfoMap);
					}
				} catch(Exception ex){
					ex.printStackTrace();
					continue;
				}
				
			}
	}
	
	public static List<Map<String,String>> getEhrUserInfoByUserList(){
		List<Map<String,String>> userList = new ArrayList<Map<String,String>>();
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
			if (keys!=null) {
				for(String key:keys){
					Map<String,String> userMap = RedisBaseUtil.hgetAll(key);
					userList.add(userMap);
				}
			}
			
		return userList;
	}
	
	public static void deleteEhrUserInfoByUserId(String userId){
		String key = keyPrefix+userId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteEhrUserInfoByUserList(List<Map<String,String>> userinfoList){
		if(userinfoList == null||userinfoList.size() < 1){
			return;
		}
		for(int i = 0;i < userinfoList.size();i++){
				Map<String,String> userinfoMap = userinfoList.get(i);
				String userId = userinfoMap.get("userId");
				String key = keyPrefix+userId;
				RedisBaseUtil.del(key);
			}
	}
	
	public static void deleteEhrUserInfoAll(){
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix);
			if (keys!=null) {
				for(String key:keys){
					RedisBaseUtil.del(key);
				}
			}
		
	}
}
