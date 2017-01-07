package com.dcits.jb.core.cache;

import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

/** 
 * 云助理的tocken及相关信息的缓存类
  * @author  xingyxa 
  * @date 创建时间：2016年8月23日 下午5:06:16 
  * @version 1.0 
  * @since  1.8 
*/
public class YzlTockenCache {
	private final static String keyPrefix = "bh.Yzl.Tocken.info.";
	/**
	 * 通过aId获取TockenInfo信息
	 * @author  xingyxa 
	 * @param aId
	 * @return TockenInfo信息
	 */
	public static Map<String,String> getTockenInfoByAId(String aId){
		String key = keyPrefix+aId;
		Map<String, String> tockenInfoMap = RedisBaseUtil.hgetAll(key);
		return tockenInfoMap;
	}
	/**
	 * 将TockenInfo信息放入缓存
	 * @author  xingyxa 
	 * @param tockenInfoMap
	 */
	public static void putTockenInfoByAId(Map<String,String> tockenInfoMap){
		String aId = tockenInfoMap.get("aId");
		String key = keyPrefix+aId;
		if(tockenInfoMap != null){
			RedisBaseUtil.hmset(key,tockenInfoMap);  
		}
	}
	public static void deleteTockenInfoByAId(String aId) {
		String key = keyPrefix + aId;
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
