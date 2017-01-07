package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.dcits.jb.core.util.RedisBaseUtil;
import com.dcits.jb.core.util.StringUtil;


public class MisArticleInfoListCache {
	private final static String keyPrefix = "bh.mis.articlelist.";
	private final static String ListPrefix = "bh.mis.list.";
	//通过栏目id获取咨询id数组
	public static String[] getMisArticleArrayByMisId(String misId){
		String key = keyPrefix+misId;
		String[] articleIdArray = null;
		String ids = RedisBaseUtil.get(key);
		if(ids != null && !ids.equals("")){
			articleIdArray = ids.split(",");
		}
		return articleIdArray;
	}
	
	//通过栏目id获取咨询id字符串
	public static String getMisArticleIdsByMisId(String misId){
		String key = keyPrefix+misId;
		String articleIds = RedisBaseUtil.get(key);
		return articleIds;
	}
	
	//通过栏目id获取咨询idList
	public static List<String> getMisArticleIdListByMisId(String misId){
		String key = keyPrefix+misId;
		String articleIds[] = null;
		List<String> list=new ArrayList<String>();
		String ids=RedisBaseUtil.get(key);
		if (ids!=null&&!"".equals(ids)) {
			articleIds =ids.split(",");
		}
		list = Arrays.asList(articleIds);
		return list;
	}
		
	
    //把文章id拼为字符串存起来
	public static void putMisArticleIdByArticleId(String misId,String articeId){
		String key = keyPrefix+misId;
		if(misId != null && !"".equals(misId)&&articeId != null && !"".equals(articeId)){
			RedisBaseUtil.set(key, articeId);
		
		}
	}
	
	//通过栏目id和资讯id数组存储
	public static void putMisArticleIdArrayByMisId(String misId,String[] articeIdArray){
		String key = keyPrefix+misId;
		if(articeIdArray != null && articeIdArray.length > 0){
			String articleIds = StringUtil.strarrayToStr(articeIdArray);
			RedisBaseUtil.set(key,articleIds);
		}
	}
	
	//通过栏目id和资讯id  List存储
	public static void putMisArticleIdArrayByMisIdList(String misId,List<String> articleId){
		String key = keyPrefix+misId;
		StringBuffer articleIdArray=new StringBuffer();
		if(articleId != null && !articleId.equals("")){
			for (String id : articleId) {
				articleIdArray.append(id+",");
			}
			String articleIds=articleIdArray.substring(0, articleIdArray.length()-1);
			RedisBaseUtil .set(key,articleIds);
		}
	}
	
	//********************************以上的方法主要操作栏目Id以下方法主要操作文章List《Id》*********
		 
	//根据栏目id和文章id 缓存到List中
	public static void putMisArticleIdInList(String misId,String articeId){
		String key = ListPrefix+misId;
		if(misId != null && !"".equals(misId)&&articeId != null && !"".equals(articeId)){
			RedisBaseUtil.rpush(key, articeId);
		}
	}
	//根据栏目id和文章id数组 缓存到List中
	public static void putMisArticleIdArrayInList(String misId,String[] articeId){
		String key = ListPrefix+misId;
		if(misId != null && !"".equals(misId)&&articeId != null && articeId.length>0){
			for(int i=0;i<articeId.length;i++){
				try {
					RedisBaseUtil.rpush(key, articeId[i]);
				} catch (Exception ex) {
					ex.printStackTrace();
					continue;
				}
				
			}
			
		}
	}
	//根据栏目id和文章id数组 缓存到List中
	public static void putMisArticleIdListInList(String misId,List<String> articeId){
		String key = ListPrefix+misId;
		if(misId != null && !"".equals(misId)&&articeId != null && articeId.size()>0){
			for(String item:articeId){
				RedisBaseUtil.rpush(key, item);
			}
		}
	}
	//通过栏目id和资讯索引值获取咨询id
	public static String getMisArticleIdByMisId(String misId,long index){
		String key = ListPrefix+misId;
		String articleId = RedisBaseUtil.lindex(key, index);
		return articleId;
			
	}
	
	//通过栏目id和资讯索引值获取咨询id
	public static List<String> getMisArticleIdByRanIndex(String misId,long from,long to){
		String key = ListPrefix+misId;
		List<String > list = RedisBaseUtil.lrange(key, from, to);
		return list;
	}
	
	
	//通过栏目id和资讯id  Map存储
	public static void putMisArticleArrayByIdMap(Map<String,List<String>> articleListMap){
		if(articleListMap == null){
			return;
		}
		StringBuffer articleIdArray=new StringBuffer();
		Set<Entry<String,List<String>>> keyvalueset= articleListMap.entrySet();
		for(Entry<String,List<String>> entry:keyvalueset){
			String key = keyPrefix+entry.getKey();
			List<String> value = entry.getValue();
			if(value != null && !value.equals("")){
				try {
					for (String id : value) {
						articleIdArray.append(id+",");
					}
					String articleId=articleIdArray.substring(0, articleIdArray.length()-1);
					RedisBaseUtil.set(key,articleId);
				} catch (Exception ex) {
					ex.printStackTrace();
					continue;
				}
				
			}
		}
	}
	//根据栏目id删除对应栏目资讯List
	public static void deleteMisArticleArrayByMisId(String misId){
		String key = keyPrefix+misId;
		RedisBaseUtil.del(key);
	}
	//根据栏目id删除资讯idList
	public static void deleteMisArticleidListByMisId(String misId){
		String key = ListPrefix+misId;
		RedisBaseUtil.del(key);
	}
	
	//根据栏目id和传入的资讯idList删除对应的资讯id
	public static void deleteArticleidListByArticleidList(String misId,List<String> artList){
		String key = ListPrefix+misId;
		for (String id : artList) {
			RedisBaseUtil.lrem(key, 0, id);
		}
	}
	//删除所有
	public static void deleteMisArticleListAll(){
		Set<String> keys = RedisBaseUtil.getKeys(ListPrefix+"*");
		if(keys != null){
			for(String key:keys){
				try {
					RedisBaseUtil.del(key);
				} catch (Exception ex) {
					ex.printStackTrace();
					continue;
				}
				
			}
		}
	}
	//根据栏目id字符串 删除
	public static void deleteMisArticleArrayByArticleMap(String misIds){
		if(misIds == null || "".equals(misIds)){
			return;
		}
		String[] misIdArray = StringUtil.strToStrarray(misIds);
		for(int i = 0;i < misIdArray.length;i++){
			try {
				String misId = misIdArray[i];
				String key = keyPrefix+misId;
				RedisBaseUtil.del(key);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
			
		}
	}
	//根据栏目id数组 删除
	public static void deleteMisArticleArrayByMisMap(String[] misIdArray){
		if(misIdArray == null || misIdArray.length < 1){
			return;
		}
		for(int i = 0;i < misIdArray.length;i++){
			try {
				String misId = misIdArray[i];
				String key = keyPrefix+misId;
				RedisBaseUtil.del(key);
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
			
		}
	}
	//删除所有
	public static void deleteMisArticleArrayAll(){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if(keys != null){
			for(String key:keys){
				try {
					RedisBaseUtil.del(key);
				} catch (Exception ex) {
					ex.printStackTrace();
					continue;
				}
				
			}
		}
	}

}
