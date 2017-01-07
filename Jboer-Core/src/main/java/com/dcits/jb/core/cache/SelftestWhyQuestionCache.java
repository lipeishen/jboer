package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class SelftestWhyQuestionCache {
	private static final String keyPrefix = "bh.selftest.why.question.";

	/**
	 * 根据suffix获取匹配的问题列表
	 * 
	 * @param suffix:标准科室id.+医院id.+分科id.+医生id.+疾病id+问题id
	 * @return
	 */
	public static List<Map<String, String>> getQuestionBySuffix(String suffix) {
		String key = keyPrefix + suffix;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(key);
			if (keys != null) {
				for (String k : keys) {
					Map<String, String> map = RedisBaseUtil.hgetAll(k);
					list.add(map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获取所有问题
	 * 
	 * @return questionList
	 */
	public static List<Map<String, String>> getAllQuestions() {
		List<Map<String, String>> questionList = new ArrayList<Map<String, String>>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*.*.*.*.*.*");
			if (keys != null) {
				for (String key : keys) {
					Map<String, String> diseaseMap = RedisBaseUtil.hgetAll(key);
					questionList.add(diseaseMap);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return questionList;
	}

	/**
	 * 把一条数据加入缓存
	 * 
	 * @param suffix
	 * @param questionMap
	 */
	public static void putQuestionByMap(String suffix, Map<String, String> questionMap) {
		String key = keyPrefix + suffix;
		if (questionMap != null) {
			RedisBaseUtil.hmset(key, questionMap);
		}
	}

	/**
	 * 从缓存清除与suffix匹配的问题
	 * 
	 * @param suffix
	 */
	public static void deleteQuestionBySuffix(String suffix) {
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + suffix);
			if (keys != null) {
				for (String key : keys) {
					RedisBaseUtil.del(key);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 清空缓存
	 */
	public static void deleteAllQuestions() {
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*.*.*.*.*.*");
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
