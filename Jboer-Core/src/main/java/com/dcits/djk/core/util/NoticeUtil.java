package com.dcits.djk.core.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dcits.djk.core.cache.NoticeInfoCache;
import com.dcits.djk.core.cache.NoticeTemplateCache;
import com.dcits.djk.core.error.AuthErrorCodeInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 通知管理接口类
 * 
 * @author licpc
 *
 */
public class NoticeUtil {

	/**
	 * 向缓存中写入通知
	 * 
	 * @param tempCode
	 * @param tempMap
	 * @return
	 */
	public static String insertNoticeInfo(String tempCode, Map<String, String> paramMap) {
		Map<String, String> map = new HashMap<String, String>();
		// 获取当前时间作为通知的写入时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		// 1.根据模板编码获取模板内容
		Map<String, String> templateMap = new HashMap<String, String>();
		templateMap = NoticeTemplateCache.getNoticeTemplateById(tempCode);
		if (templateMap == null || templateMap.size() == 0) {
			map.put("code", "01");
			map.put("msg", "模板不存在，请您先到管理系统上维护模板文件！");
			JSONObject jo = JSONObject.fromObject(map);
			return ResultJsonBean.success(jo.toString());
		}
		String templateContent = templateMap.get("noticeTempContent");
		if (StringUtil.sNull(templateContent) == "") {
			map.put("code", "02");
			map.put("msg", "模板内容为空，请先维护好模板！");
			JSONObject jo = JSONObject.fromObject(map);
			return ResultJsonBean.success(jo.toString());
		}
		// templateContent = "${userName}您于${dataTime}提交了服务购买${status}";

		// 2.循环传入参数，替换模板中的变量
		if (paramMap != null && paramMap.size() > 0) {
			for (String key : paramMap.keySet()) {
				if (templateContent.indexOf(key) > 0) {
					templateContent = templateContent.replace("${" + key + "}", paramMap.get(key));
				}
			}
		}
		// 3.将通知写入缓存
		String result = NoticeUtil.insertNotice(StringUtil.getNullStr(paramMap.get("noticeId")),
				StringUtil.getNullStr(paramMap.get("userId")), StringUtil.getNullStr(paramMap.get("noticeType")),
				StringUtil.getNullStr(paramMap.get("noticeSource")),
				StringUtil.getNullStr(paramMap.get("noticeTarget")), StringUtil.getNullStr(templateContent), "0", time);
		System.out.println(result);
		return result;
	}

	/**
	 * 向缓存中写入通知数据
	 * 
	 * @param noticeId
	 * @param userId
	 * @param noticeType
	 * @param noticeSource
	 * @param noticeTarget
	 * @param noticeContent
	 * @param noticeStatus
	 * @param createTime
	 * @return
	 */
	public static String insertNotice(String noticeId, String userId, String noticeType, String noticeSource,
			String noticeTarget, String noticeContent, String noticeStatus, String createTime) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Map<String, String> notice = new HashMap<String, String>();
			notice.put("notice_id", noticeId);
			notice.put("user_id", userId);
			notice.put("notice_type", noticeType);
			notice.put("notice_source", noticeSource);
			notice.put("notice_target", noticeTarget);
			notice.put("notice_content", noticeContent);
			notice.put("notice_status", noticeStatus);
			notice.put("create_time", createTime);
			NoticeInfoCache.putNoticeInfoByNoticeMap(notice);
			NoticeInfoCache.putNoticeIdInList(userId, noticeId);
			Map<String, String> resultnotice = new HashMap<String, String>();
			resultnotice = NoticeInfoCache.getNoticeInfoByNoticeId(noticeId);
			if (resultnotice != null && resultnotice.size() > 0) {
				map.put("code", "01");
				map.put("msg", "新增通知成功");
			} else {
				map.put("code", "02");
				map.put("msg", "保存通知失败");
			}
			JSONObject jo = JSONObject.fromObject(map);
			return ResultJsonBean.success(jo.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultJsonBean.fail(AuthErrorCodeInfo.NOTICE_INSERTEXCEPTION_CODE,
					AuthErrorCodeInfo.NOTICE_INSERTEXCEPTION_DESC, "");
		}

	}

	/**
	 * 根据条件查询通知数据
	 * 
	 * @param request
	 * @param rows
	 * @param page
	 * @return
	 */

	public static String queryNoticeByUserIdOrStatus(String userId, String noticeType, String status, int fromPage,
			int toPage) {
		try {
			List<String> noticeIdList = NoticeInfoCache.getNotifeIdListByRanIndex(userId, fromPage, toPage);
			List<Map<String, String>> noticelist = new ArrayList<Map<String, String>>();
			if (noticeIdList != null) {
				for (String id : noticeIdList) {
					Map<String, String> noticeMap = NoticeInfoCache.getNoticeInfoByNoticeId(id);
					if (noticeMap != null && noticeMap.size() > 0) {
						noticelist.add(noticeMap);
					}
				}
			}
			JSONArray jo = JSONArray.fromObject(noticelist);
			return ResultJsonBean.success(jo.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultJsonBean.fail(AuthErrorCodeInfo.NOTICE_QUERYEXCEPTION_CODE,
					AuthErrorCodeInfo.NOTICE_QUERYEXCEPTION_DESC, "");
		}

	}

	/**
	 * 根据条件查询通知数据
	 * 
	 * @param request
	 * @param rows
	 * @param page
	 * @return
	 */
	public String queryNoticeByUserIdOrType(String userId, String noticeType, String status, int fromPage, int toPage) {
		try {
			List<String> noticeIdList = NoticeInfoCache.getNotifeIdListByRanIndex(userId, fromPage, toPage);
			List<Map<String, String>> noticelist = new ArrayList<Map<String, String>>();
			if (noticeIdList != null) {
				for (String id : noticeIdList) {
					Map<String, String> noticeMap = NoticeInfoCache.getNoticeInfoByNoticeId(id);
					if (noticeMap != null && noticeMap.size() > 0) {
						String nocicetype = noticeMap.get("notice_type");
						if (nocicetype.equals(noticeType)) {
							noticelist.add(noticeMap);
						}

					}
				}
			}

			JSONArray jo = JSONArray.fromObject(noticelist);
			return ResultJsonBean.success(jo.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultJsonBean.fail(AuthErrorCodeInfo.NOTICE_QUERYEXCEPTION_CODE,
					AuthErrorCodeInfo.NOTICE_QUERYEXCEPTION_DESC, "");
		}

	}

	/**
	 * 点击通知数据时候变更通知状态
	 * 
	 * @param userId
	 * @param noticeId
	 * @return
	 */
	public String updateNoticeStatus(String userId, String noticeId) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Map<String, String> noticeMap = NoticeInfoCache.getNoticeInfoByNoticeId(noticeId);
			if (noticeMap != null && noticeMap.size() > 0) {
				// 1.向数据库中插入一条记录，状态为已读取
				// String noticeType = noticeMap.get("notice_type");
				// String noticeSource = noticeMap.get("notice_source");
				// String noticeTarget = noticeMap.get("notice_target");
				// String noticeContent = noticeMap.get("notice_content");
				// // 2.删除缓存中的信息
				// String reS = this.insertNotice(userId, noticeId, noticeType,
				// noticeSource, noticeTarget, noticeContent,
				// "1");
				// if ("success".equals(reS)) {
				// 数据库插入成功，删除缓存
				NoticeInfoCache.deleteNoticeInfoByNoticeId(noticeId);
				NoticeInfoCache.deleteNoticeIdListByUserId(userId, noticeId);
				returnMap.put("code", "01");
				returnMap.put("msg", "success");
				// } else {
				// returnMap.put("code", "02");
				// returnMap.put("msg", "error");
				// }
			} else {
				returnMap.put("code", "02");
				returnMap.put("msg", "通知不存在！");
			}
			JSONObject jo = JSONObject.fromObject(returnMap);
			return ResultJsonBean.success(jo.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultJsonBean.fail(AuthErrorCodeInfo.NOTICE_QUERYEXCEPTION_CODE,
					AuthErrorCodeInfo.NOTICE_QUERYEXCEPTION_DESC, "");
		}

	}

	/**
	 * 根据类型查询通知数量
	 * 
	 * @param request
	 * @param userId
	 * @param noticeType
	 * @param status
	 * @return
	 */
	public String queryNoticeCountByAllType(String userId) {
		try {
			List<String> noticeIdList = NoticeInfoCache.getNotifeIdListByRanIndex(userId, 0, -1);
			int count = 0;
			if (noticeIdList != null) {
				count = noticeIdList.size();
			}
			return String.valueOf(count);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultJsonBean.fail(AuthErrorCodeInfo.NOTICE_QUERYEXCEPTION_CODE,
					AuthErrorCodeInfo.NOTICE_QUERYEXCEPTION_DESC, "");
		}

	}

	/**
	 * 根据类型查询通知数量
	 * 
	 * @param request
	 * @param userId
	 * @param noticeType
	 * @param status
	 * @return
	 */
	public static String queryNoticeCountByType(String userId, String noticeType) {
		int sum = 0;
		try {
			List<String> noticeIdList = NoticeInfoCache.getNotifeIdListByRanIndex(userId, 0, -1);
			if (noticeIdList != null) {
				for (String id : noticeIdList) {
					Map<String, String> noticeMap = NoticeInfoCache.getNoticeInfoByNoticeId(id);
					if (noticeMap != null && noticeMap.size() > 0) {
						String nocicetype = noticeMap.get("notice_type");
						if (nocicetype.equals(noticeType)) {
							sum++;
						}
					}

				}
			}

			return String.valueOf(sum);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultJsonBean.fail(AuthErrorCodeInfo.NOTICE_QUERYEXCEPTION_CODE,
					AuthErrorCodeInfo.NOTICE_QUERYEXCEPTION_DESC, "");
		}

	}

	public static void main(String[] args) {
		// ${modelName} ${userName}您于${dataTime}提交了服务购买${status}
		String tempCode = "jktj_template_20160702_1";
		Map<String, String> paramMap = new HashMap<String, String>();
		// paramMap.put("userName", "李彩萍");
		// paramMap.put("modelName", "境外就医");
		// paramMap.put("dataTime", "2017-10-10 12:12");
		// paramMap.put("status", "申请");
		paramMap.put("userId", "73d3cc83c379468887cbe35a1cbc68db");// 必传
		paramMap.put("noticeId", "038517eeecd84787b5cafa506504bda0");// 必传
		paramMap.put("noticeType", "2");// 必传
		paramMap.put("noticeSource", "境外就医");// 必传
		paramMap.put("noticeTarget", "73d3cc83c379468887cbe35a1cbc68db");// 必传
		// paramMap.put("noticeStatus", "1");
		// paramMap.put("createTime", "2016-04-04 13:43:51");
		NoticeUtil.insertNoticeInfo(tempCode, paramMap);
	}

}
