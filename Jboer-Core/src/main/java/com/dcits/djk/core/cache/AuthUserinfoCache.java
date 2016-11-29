package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class AuthUserinfoCache {
	private final static String keyPrefix = "bh.auth.user.main.";
	private final static int times = 60*60*24*2;
	public static Map<String,String> getUserInfoByUserId(String userId){
		String key = keyPrefix+userId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putUserInfoByUserMap(Map<String,String> useinfoMap){
		String userId = useinfoMap.get("userId");
		String key = keyPrefix+userId;
		RedisBaseUtil.hmset(key,useinfoMap,times);
	}
	
	public static void putUserInfoByUserList(List<Map<String,String>> useinfoList){
		if(useinfoList == null||useinfoList.size() < 1){
			return;
		}
		for(int i = 0;i < useinfoList.size();i++){
			try{
				Map<String,String> useinfoMap = useinfoList.get(i);
				if(useinfoMap != null){
					String userId = useinfoMap.get("userId");
					String key = keyPrefix+userId;
					RedisBaseUtil.hmset(key,useinfoMap,times);
				}
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static List<Map<String,String>> getUserInfoByUserList(){
		List<Map<String,String>> userList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if(keys != null){
			for(String key:keys){
				Map<String,String> userMap = RedisBaseUtil.hgetAll(key);
				userList.add(userMap);
			}
		}
		return userList;
	}
	
	public static void deleteUserInfoByUserId(String userId){
		String key = keyPrefix+userId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteUserInfoByUserList(List<Map<String,String>> userinfoList){
		if(userinfoList == null||userinfoList.size() < 1){
			return;
		}
		for(int i = 0;i < userinfoList.size();i++){
			try{
				Map<String,String> userinfoMap = userinfoList.get(i);
				String userId = userinfoMap.get("userId");
				String key = keyPrefix+userId;
				RedisBaseUtil.del(key);
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deleteUserInfoAll(){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if(keys != null){
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
}
