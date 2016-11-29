package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class ExaminationCardInfoCache {
	private final static String keyPrefix = "bh.mis.examination.card.";
	
	public static Map<String,String> getCardInfoByCardCode(String cardCode){
		String key = keyPrefix+cardCode;
		Map<String, String> cardMap =RedisBaseUtil.hgetAll(key);
		return cardMap;
	}
	public static void putCardInfoByCardMap(Map<String,String> cardMap){
		String cardCode = cardMap.get("cardCode");
		String key = keyPrefix+cardCode;
			if(cardMap != null&&key!=null){
				RedisBaseUtil.hmset(key,cardMap);
			}
	}
	public static void putCardInfoByCardList(List<Map<String,String>> cardList){
		if(cardList == null||cardList.size() < 1){
			return;
		}
			for(int i = 0;i < cardList.size();i++){
				try {
					Map<String,String> cardMap = cardList.get(i);
					if(cardMap != null){
						String cardCode = cardMap.get("cardCode");
						String key = keyPrefix+cardCode;
						if (key!=null) {
							RedisBaseUtil.hmset(key,cardMap);
						}
						
					}
				} catch(Exception ex){
					ex.printStackTrace();
					continue;
				}
				
			}
	}
	public static List<Map<String,String>> getCardInfoByCardList(){
		List<Map<String,String>> cardList = new ArrayList<Map<String,String>>();
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
			if (keys!=null) {
				for(String key:keys){
					Map<String,String> cardMap = RedisBaseUtil.hgetAll(key);
					cardList.add(cardMap);
				}
			}
			
		return cardList;
	}
	public static List<Map<String,String>> getCardInfoByCardList(List<String> list){
		List<Map<String,String>> cardList = new ArrayList<Map<String,String>>();
		if (list!=null) {
			for(String key:list){
				Map<String,String> cardMap = RedisBaseUtil.hgetAll(keyPrefix+key);
				cardList.add(cardMap);
			}
		}	
		return cardList;
	}
	public static void deleteCardInfoByCardCode(String cardCode){
		String key = keyPrefix+cardCode;
		RedisBaseUtil.del(key);
	}
	public static void deleteCardInfoByCardList(List<Map<String,String>> cardList){
		if(cardList == null||cardList.size() < 1){
			return;
		}
			for(int i = 0;i < cardList.size();i++){
				Map<String,String> cardMap = cardList.get(i);
				String cardCode = cardMap.get("cardCode");
				String key = keyPrefix+cardCode;
				RedisBaseUtil.del(key);
			}
	}
	public static void deleteCardInfoAll(){
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
			if (keys!=null) {
				for(String key:keys){
					RedisBaseUtil.del(key);
				}
			}
			
	}
}
