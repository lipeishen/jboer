package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;

public class FamilyDoctorCache {
	private final static String keyPrefix = "bh.familydoctor.station.main.";
	//private final static int times = 60*60*24*2;
	public static Map<String,String> getStationInfoBystationId(String stationId){
		String key = keyPrefix+stationId;
		Map<String,String> routerMap = RedisBaseUtil.hgetAll(key);
		return routerMap;
	}
	
	public static void putStationInfoByStationMap(Map<String,String> stationMap){
		String stationId = stationMap.get("stationId");
		String key = keyPrefix+stationId;
		if(stationMap != null){
			RedisBaseUtil.hmset(key,stationMap);
			//jedis.expire(key, times);
		}
	}
	
	public static void putStationInfoByStationList(List<Map<String,String>> stationList){
		if(stationList == null||stationList.size() < 1){
			return;
		}
		for(int i = 0;i < stationList.size();i++){
			try {
				Map<String,String> stationMap = stationList.get(i);
				if(stationMap != null){
					String stationId = stationMap.get("stationId");
					String key = keyPrefix+stationId;
					
					RedisBaseUtil.hmset(key,stationMap);
					//transaction.expire(key, times);
				}
			} catch(Exception ex){
				ex.printStackTrace();
				continue;
			}
			
		}
	}
	
	public static List<Map<String,String>> getStationInfoByStationList(){
		List<Map<String,String>> StationList = new ArrayList<Map<String,String>>();
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if(keys != null){
			for(String key:keys){
				Map<String,String> StationMap = RedisBaseUtil.hgetAll(key);
				StationList.add(StationMap);
			}
		}
		return StationList;
	}
	
	public static void deleteStationInfoBystationId(String stationId){
		String key = keyPrefix+stationId;
		RedisBaseUtil.del(key);
	}
	
	public static void deleteStationInfoByStationList(List<Map<String,String>> stationinfoList){
		if(stationinfoList == null||stationinfoList.size() < 1){
			return;
		}
		for(int i = 0;i < stationinfoList.size();i++){
			try{
				Map<String,String> StationinfoMap = stationinfoList.get(i);
				String stationId = StationinfoMap.get("stationId");
				String key = keyPrefix+stationId;
				RedisBaseUtil.del(key);
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
	}
	
	public static void deleteStationInfoAll(){
		Set<String> keys = RedisBaseUtil.getKeys(keyPrefix+"*");
		if(keys != null){
			for(String key:keys){
				try{
					RedisBaseUtil.del(key);
				}catch(Exception e){
					e.printStackTrace();
					continue;
				}
			}
		}
	}
}
