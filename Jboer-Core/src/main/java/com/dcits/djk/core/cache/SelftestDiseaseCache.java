package com.dcits.djk.core.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.djk.core.util.RedisBaseUtil;


/**
 * 疾病库缓存类
 * @author Yanhao
 *
 */
public class SelftestDiseaseCache {
	private final static String keyPrefix="bh.selftest.disease.main.";
	/**
	 * 根据suffix获取取Disease;
	 * @param diseaseId
	 * @return
	 */
	public static List<Map<String,String>> getDiseaseBySuffix(String suffix){
		String key=keyPrefix+suffix;
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		try {
			Set<String> keys=RedisBaseUtil.getKeys(key);
			if(keys!=null){
				for(String k:keys){
					Map<String,String> diseaseMap=RedisBaseUtil.hgetAll(k);
					list.add(diseaseMap);
				}
			}
			//模块排序
			Collections.sort(list,new Comparator<Map<String,String>>() {//内部类
	            public int compare(Map<String,String> arg0, Map<String,String> arg1) {
	            	String diseaseSpellcls0  = arg0.get("spellcls");
	            	String diseaseSpellcls1  = arg1.get("spellcls");
	                return diseaseSpellcls0.compareTo(diseaseSpellcls1);
	            }
			});
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	/**
	 * 分页查询
	 * @param suffix
	 * @param from
	 * @param to
	 * @return
	 */
//	public static List<Map<String,String>> getDiseaseByIndex(String suffix,long from,long to){
//		String key=keyPrefix+suffix;
//		List<Map<String,String>> list=getDiseaseBySuffix(key);
//		//模块排序
//		Collections.sort(list,new Comparator<Map<String,String>>() {//内部类
//            public int compare(Map<String,String> arg0, Map<String,String> arg1) {
//            	String diseaseSpellcls0  = arg0.get("spellcls");
//            	String diseaseSpellcls1  = arg1.get("spellcls");
//                return diseaseSpellcls0.compareTo(diseaseSpellcls1);
//            }
//		});
//		return list;
//	}
	
	/**
	 * 存放diseaseMap到缓存
	 * @param suffix
	 * @param diseaseMap
	 */
	public static void putDiseaseByMap(String suffix,Map<String,String> diseaseMap){
		String key=keyPrefix+suffix;		
			if(diseaseMap!=null){
				RedisBaseUtil.hmset(key,diseaseMap);
			}
	}
	
	/**
	 * 从缓存读取disease列表；
	 * @return diseaseList;
	 */
	public static List<Map<String,String>> getDiseaseList(){
		List<Map<String,String>> diseaseList=new ArrayList<Map<String,String>>();
		try {
			Set<String> keys=RedisBaseUtil.getKeys(keyPrefix+"*.*.*.*.*");
			if(keys!=null){
				for(String key:keys){
					Map<String,String> diseaseMap=RedisBaseUtil.hgetAll(key);
					diseaseList.add(diseaseMap);
				}
			}
			//模块排序
			Collections.sort(diseaseList,new Comparator<Map<String,String>>() {//内部类
	            public int compare(Map<String,String> arg0, Map<String,String> arg1) {
	            	String diseaseSpellcls0  = arg0.get("spellcls");
	            	String diseaseSpellcls1  = arg1.get("spellcls");
	                return diseaseSpellcls0.compareTo(diseaseSpellcls1);
	            }
			});
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return diseaseList;
	}
	
	/**
	 * 根据suffix从缓存中删除一条disease，
	 * suffix 每一个参数都不能为空，即不能有"*";
	 * @param suffix
	 */
	public static void deleteDiseaseBySuffix(String suffix){
		String key=keyPrefix+suffix;
		RedisBaseUtil.del(key);
	}
	/**
	 * 根据suffix删除与key匹配的疾病列表；
	 * @param suffix
	 */
	public static void deleteDiseaseListBySuffix(String suffix){
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix +suffix);
			if(keys!=null){
				for (String key : keys) {
					RedisBaseUtil.del(key);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	/**
	 * 清空缓存；
	 */
	public static void deleteAllDisease(){
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix +"*.*.*.*.*");
			if(keys!=null){
				for (String key : keys) {
					RedisBaseUtil.del(key);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
