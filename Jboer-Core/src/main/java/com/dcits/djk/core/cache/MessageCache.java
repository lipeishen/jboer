package com.dcits.djk.core.cache;

import java.util.Map;

import com.dcits.djk.core.util.RedisBaseUtil;


public class MessageCache {
	private final static String keyPrefix = "bh.auth.phone.message.";
	public static Map<String,String> getMessageByPhoneAndType(String phone,String type){
		String key = keyPrefix + type + "." + phone;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putMessage(Map<String,String> messageMap){
		String phone = messageMap.get("phone");
		String type = messageMap.get("type");
		String key = keyPrefix + type + "." + phone;
		RedisBaseUtil.hmset(key, messageMap);
	}
	
	public static void deleteMessageByPhoneAndType(String phone,String type){
		String key = keyPrefix + type + "." + phone;
		RedisBaseUtil.del(key);
	}
}
