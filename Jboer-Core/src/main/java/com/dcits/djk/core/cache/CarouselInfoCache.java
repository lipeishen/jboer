package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class CarouselInfoCache {
	private final static String keyPrefix = "bh.sys.carousel.info.";
	public static Map<String,String> getCarouselInfoByCarouselId(String carouselId){
		String key = keyPrefix+carouselId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putCarouselInfoByCarouselMap(Map<String,String> carouselMap){
		String carouselId = carouselMap.get("carouselId");
		String key = keyPrefix+carouselId;
		if(carouselMap != null){
			RedisBaseUtil.hmset(key,carouselMap);
		}
	}
	
	public static void putCarouselInfoByCarouselList(List<Map<String,String>> carouselList){
		if(carouselList == null||carouselList.size() < 1){
			return;
		}
		for(int i = 0;i < carouselList.size();i++){
			try{
				Map<String,String> carouselMap = carouselList.get(i);
				if(carouselMap != null){
					String carouselId = carouselMap.get("carouselId");
					String key = keyPrefix+carouselId;
					RedisBaseUtil.hmset(key,carouselMap);
				}
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static List<Map<String,String>> getCarouselInfoByCarouselList(){
		List<Map<String,String>> carouselList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if(keys != null){
			for(String key:keys){
				Map<String,String> carouselMap = RedisBaseUtil.hgetAll(key);
				carouselList.add(carouselMap);
			}
		}
		return carouselList;
	}
	
	public static void deleteCarouselInfoByCarouselId(String carouselId){
		String key = keyPrefix+carouselId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteCarouselInfoByCarouselList(List<Map<String,String>> carouselList){
		if(carouselList == null||carouselList.size() < 1){
			return;
		}
		for(int i = 0;i < carouselList.size();i++){
			try{
				Map<String,String> carouselMap = carouselList.get(i);
				String carouselId = carouselMap.get("carouselId");
				String key = keyPrefix+carouselId;
				RedisBaseUtil.del(key);
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deleteCarouselInfoAll(){
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
