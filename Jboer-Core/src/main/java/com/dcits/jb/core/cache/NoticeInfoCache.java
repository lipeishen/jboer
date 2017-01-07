package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class NoticeInfoCache {
	private final static String keyPrefix = "bh.auth.notice.";
	private final static String ListPrefix = "bh.auth.noticelist.";
	//private final static int times = 60*60*24*2;
	public static Map<String,String> getNoticeInfoByNoticeId(String noticeId){
		String key = keyPrefix+noticeId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putNoticeInfoByNoticeMap(Map<String,String> noticeMap){
		String noticeId = noticeMap.get("notice_id");
		String key = keyPrefix+noticeId;
		if(noticeMap != null){
			RedisBaseUtil.hmset(key,noticeMap);
		}
	}
	
	public static void putNoticeInfoByNoticeList(List<Map<String,String>> NoticeList){
		if(NoticeList == null||NoticeList.size() < 1){
			return;
		}
		for(int i = 0;i < NoticeList.size();i++){
			try{
				Map<String,String> NoticeMap = NoticeList.get(i);
				if(NoticeMap != null){
					String noticeId = NoticeMap.get("notice_id");
					String key = keyPrefix+noticeId;
					RedisBaseUtil.hmset(key,NoticeMap);
				}
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static List<Map<String,String>> getNoticeInfoListByNoticeId(){
		List<Map<String,String>> NoticeList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if(keys != null){
			for(String key:keys){
				Map<String,String> NoticeMap = RedisBaseUtil.hgetAll(key);
				NoticeList.add(NoticeMap);
			}
		}
		return NoticeList;
	}
	
	public static void deleteNoticeInfoByNoticeId(String noticeId){
		String key = keyPrefix+noticeId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteNoticeInfoByNoticeList(List<Map<String,String>> NoticeList){
		if(NoticeList == null||NoticeList.size() < 1){
			return;
		}
		for(int i = 0;i < NoticeList.size();i++){
			try {
				Map<String,String> NoticeMap = NoticeList.get(i);
				String noticeId = NoticeMap.get("notice_id");
				String key = keyPrefix+noticeId;
				RedisBaseUtil.del(key);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deleteNoticeInfoAll(){
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
	
	
	//以下操作数对redis的list列表进行操作
	//根据用户id和通知id 缓存到List中
	public static void putNoticeIdInList(String userId,String noticeId){
		String key = ListPrefix+userId;
		if(userId != null && !"".equals(userId)&&noticeId != null && !"".equals(noticeId)){
			RedisBaseUtil.lpush(key, noticeId);
		}
	}
	//根据用户id和通知idList 缓存到List中
	public static void putNoticeIdListInList(String userId, List<String> noticeId){
		String key = ListPrefix+userId;
		if(userId != null && !"".equals(userId)&&noticeId != null && noticeId.size()>0){
			for(String item:noticeId){
				try {
					RedisBaseUtil.lpush(key, item);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	//根据用户id和通知索引 获取List中的通知id
	public static String getNoticeIdByUserId(String userId,long index){
		String key = ListPrefix+userId;
		String noticeId = RedisBaseUtil.lindex(key, index);
		return noticeId;
		
	}
	//根据用户id和通知索引范围内 获取List中的通知id
	public static List<String> getNotifeIdListByRanIndex(String userId,long from,long to){
		String key = ListPrefix+userId;
		List<String > list = RedisBaseUtil.lrange(key, from, to);
		return list;
	}
	//根据用户id和通知索引 删除List中的通知id
	public static void deleteNoticeIdListByUserId(String userId,String noticeId){
		String key = ListPrefix+userId;
		RedisBaseUtil.lrem(key, 0, noticeId);
	}
	//根据用户id和通知索引范围内 删除List中的通知id
	public static void deleteNoticeIdListByUserId(String userId,List<String> noticeIdList){
		String key = ListPrefix+userId;
		for (String id : noticeIdList) {
			try {
				RedisBaseUtil.lrem(key, 0, id);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
			
		}
	}
}
