package com.dcits.jb.core.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dcits.jb.core.util.RedisBaseUtil;

public class SelftestQuestionCache {
	private final static String keyPrefix = "bh.selftest.questionItem.";

	public static Map<String, String> getQuestionInfoById(String question_id) {
		String key = keyPrefix + question_id;
		Map<String, String> QuestionMap = null;
		QuestionMap = RedisBaseUtil.hgetAll(key);
		return QuestionMap;
	}

	public static void putQuestionInfoByQuestionMap(Map<String, String> QuestionMap) {
		String questionId = QuestionMap.get("questionId");
		String key = keyPrefix + questionId;
		if (QuestionMap != null) {
			RedisBaseUtil.hmset(key, QuestionMap);
		}
	}

	public static void putQuestionInfoByQuestionList(List<Map<String, String>> questionList) {
		if (questionList == null || questionList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < questionList.size(); i++) {
				Map<String, String> QuestionMap = questionList.get(i);
				if (QuestionMap != null) {
					String question_id = QuestionMap.get("questionId");
					String key = keyPrefix + question_id;
					RedisBaseUtil.hmset(key, QuestionMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Map<String, String>> getQuestionInfoByQuestionList() {
		List<Map<String, String>> questionList = new ArrayList<Map<String, String>>();
		try {
			Set<String> keys = RedisBaseUtil.getKeys(keyPrefix + "*");
			if (keys != null) {
				for (String key : keys) {
					Map<String, String> QuestionMap = RedisBaseUtil.hgetAll(key);
					questionList.add(QuestionMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questionList;
	}

	public static List<Map<String, String>> getQuestionInfoByQuestionList(List<String> list) {
		List<Map<String, String>> questionList = new ArrayList<Map<String, String>>();
		try {
			if (list != null) {
				for (String key : list) {
					Map<String, String> cardMap = RedisBaseUtil.hgetAll(keyPrefix + key);
					questionList.add(cardMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questionList;
	}

	public static void deleteQuestionInfoById(String question_id) {
		String key = keyPrefix + question_id;
		RedisBaseUtil.del(key);

	}

	public static void deleteQuestionInfoByQuestionList(List<Map<String, String>> questionList) {
		if (questionList == null || questionList.size() < 1) {
			return;
		}
		try {
			for (int i = 0; i < questionList.size(); i++) {
				Map<String, String> cardMap = questionList.get(i);
				String question_id = cardMap.get("questionId");
				String key = keyPrefix + question_id;
				RedisBaseUtil.del(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteQuestionInfoAll() {
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
