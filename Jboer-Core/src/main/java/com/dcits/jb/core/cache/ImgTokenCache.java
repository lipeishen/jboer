package com.dcits.jb.core.cache;

import com.dcits.jb.core.util.RedisBaseUtil;

/** 
  * @author  xingyxa 
  * @date 创建时间：2016年8月24日 下午4:19:43 
  * @version 1.0 
  * @since  1.8 
*/
public class ImgTokenCache {
	private final static String keyPrefix = "bh.auth.imgToken.";
	private final static int times = 60;
	
	public static String getTokenInfoById(String token){
		String key = keyPrefix+token;
		String imgToken = RedisBaseUtil.get(key);
		return imgToken;
	}
	
	public static void setTokenInfoById(String imgToken){
		if(imgToken == null || imgToken.equals("")){
			return;
		}
		String key = keyPrefix+imgToken;
		RedisBaseUtil.set(key,imgToken,times);
	}
	public static void deleteTokenInfoById(String imgToken){
		String key = keyPrefix+imgToken;
		RedisBaseUtil.del(key);
	}
}
