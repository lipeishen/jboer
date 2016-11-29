package com.dcits.djk.core.cache;

import com.dcits.djk.core.util.RedisBaseUtil;


public class AuthTokenCache {
	private final static String keyPrefix = "bh.auth.token.";
	private final static int times = 60*60*24*2;
	
	public static String getTokenInfoById(String token){
		String key = keyPrefix+token;
		String userId = RedisBaseUtil.get(key);
		return userId;
	}
	
	public static void setTokenInfoById(String token,String userId){
		if(token == null || token.equals("")){
			return;
		}
		if(userId == null || userId.equals("")){
			return;
		}
		String key = keyPrefix+token;
		RedisBaseUtil.set(key,userId,times);
	}	
}
