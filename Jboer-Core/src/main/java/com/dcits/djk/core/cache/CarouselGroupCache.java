package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class CarouselGroupCache {
	private final static String keyPrefix = "bh.sys.carousel.group.";
	public static Map<String,String> getCarouselGroupByCarouselGroupId(String carouselGroupId){
		String key = keyPrefix+carouselGroupId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putCarouselGroupByCarouselMap(Map<String,String> carouselMap){
		String carouselGroupId = carouselMap.get("carouselGroupId");
		String key = keyPrefix+carouselGroupId;
		if(carouselMap != null){
			RedisBaseUtil.hmset(key,carouselMap);
		}
	}
	
	public static void putCarouselGroupByCarouselList(List<Map<String,String>> carouselList){
		if(carouselList == null||carouselList.size() < 1){
			return;
		}
		for(int i = 0;i < carouselList.size();i++){
			try{
				Map<String,String> carouselMap = carouselList.get(i);
				if(carouselMap != null){
					String carouselGroupId = carouselMap.get("carouselGroupId");
					String key = keyPrefix+carouselGroupId;
					RedisBaseUtil.hmset(key,carouselMap);
				}
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static List<Map<String,String>> getCarouselGroupByCarouselList(){
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
	
	public static void deleteCarouselGroupByCarouselGroupId(String carouselGroupId){
		String key = keyPrefix+carouselGroupId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteCarouselGroupByCarouselList(List<Map<String,String>> carouselList){
		if(carouselList == null||carouselList.size() < 1){
			return;
		}
		for(int i = 0;i < carouselList.size();i++){
			try{
				Map<String,String> carouselMap = carouselList.get(i);
				String carouselGroupId = carouselMap.get("carouselGroupId");
				String key = keyPrefix+carouselGroupId;
				RedisBaseUtil.del(key);
			}catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deleteCarouselGroupAll(){
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
