package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

/**
 * 医生缓存类
 * 
 * @author Yan Jinghao
 *
 */
public class SelftestDoctorCache {
	private static String keyPrefix = "bh.selftest.doctor.main.";

	/**
	 * 根据医生id读取缓存
	 * 
	 * @param id
	 * @return doctorMap
	 */
	public static Map<String, String> getDoctorById(String id) {

		String key = keyPrefix + id;
		Map<String, String> doctorMap = null;
		doctorMap = RedisBaseUtil.hgetAll(key);
		return doctorMap;
	}

	/**
	 * 获取所有医生列表
	 * 
	 * @return doctorList
	 */
	public static List<Map<String, String>> getDoctorList() {

		List<Map<String, String>> doctorList = new ArrayList<Map<String, String>>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					Map<String, String> map = RedisBaseUtil.hgetAll(key);
					doctorList.add(map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorList;
	}

	/**
	 * 根据医生id列表查询缓存
	 * 
	 * @param ids
	 * @return doctorList
	 */
	public static List<Map<String, String>> getDoctorListByIds(List<String> ids) {
		List<Map<String, String>> doctorList = new ArrayList<Map<String, String>>();
		try {
			for (String key : ids) {
				Map<String, String> map = RedisBaseUtil.hgetAll(keyPrefix + key);
				doctorList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorList;
	}

	/**
	 * 添加一个doctorMap到缓存
	 * 
	 * @param doctorMap
	 */
	public static void putDoctorMap(Map<String, String> doctorMap) {

		String id = doctorMap.get("doctor_id");
		String key = keyPrefix + id;
		if (doctorMap != null) {
			RedisBaseUtil.hmset(key, doctorMap);
		}

	}

	/**
	 * 添加医生列表到缓存
	 * 
	 * @param doctorList
	 */
	public static void putDoctorList(List<Map<String, String>> doctorList) {
		if (doctorList == null || doctorList.size() < 1) {
			return;
		}
		for (int i = 0; i < doctorList.size(); i++) {
			try {
				Map<String, String> map = doctorList.get(i);
				if (map != null) {
					String id = map.get("doctor_id");
					String key = keyPrefix + id;
					RedisBaseUtil.hmset(key, map);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				continue;
			}
		}
	}

	/**
	 * 根据id清除缓存
	 * 
	 * @param id
	 */
	public static void deleteDoctorById(String id) {
		String key = keyPrefix + id;
		RedisBaseUtil.del(key);
	}

	/**
	 * 从缓存清空指定的医生列表
	 * 
	 * @param list
	 */
	public static void deleteDoctorsByList(List<Map<String, String>> list) {
		if (list == null || list.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < list.size(); i++) {
				Map<String, String> map = list.get(i);
				String id = map.get("doctor_id");
				String key = keyPrefix + id;
				RedisBaseUtil.del(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 清空所有缓存
	 */
	public static void deleteAllDoctors() {
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
