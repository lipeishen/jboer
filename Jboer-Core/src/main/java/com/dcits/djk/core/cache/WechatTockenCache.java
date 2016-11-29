package com.dcits.djk.core.cache;

import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

/** 
 * 微信jssdk初始化时的tocken及相关信息的缓存类
  * @author  xingyxa 
  * @date 创建时间：2016年8月22日 下午3:42:16 
  * @version 1.0 
  * @since  1.8 
*/
public class WechatTockenCache {
	private final static String keyPrefix = "bh.Wechat.Tocken.info.";
	
	public static Map<String,String> getTockenInfoByOpenid(String openid){
		String key = keyPrefix+openid;
		Map<String, String> tockenInfoMap = RedisBaseUtil.hgetAll(key);
		return tockenInfoMap;
	}
	public static void putTockenInfoByOpenid(Map<String,String> tockenInfoMap){
		String openid = tockenInfoMap.get("openid");
		String key = keyPrefix+openid;
		if(tockenInfoMap != null){
			RedisBaseUtil.hmset(key,tockenInfoMap);  
		}
	}
	public static void deleteTockenInfoByOpenid(String openid) {
		String key = keyPrefix + openid;
		RedisBaseUtil.del(key);
	}
	public static void deleteTockenInfoAll() {
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					RedisBaseUtil.del(key);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
