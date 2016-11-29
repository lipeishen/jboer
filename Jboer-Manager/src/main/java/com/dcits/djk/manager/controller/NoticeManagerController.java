package com.dcits.djk.manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcits.djk.core.cache.NoticeTemplateCache;
import com.dcits.djk.core.util.BeanUtil;
import com.dcits.djk.manager.service.NoticeManagerService;
import com.dcits.djk.manager.single.model.BhAuthNoticeTemplate;

import net.sf.json.JSONObject;

/**
 * 通知管理
 * @author licpc
 *
 */
@Controller
@RequestMapping("/notice")
public class NoticeManagerController {
	
	private Logger logger = Logger.getLogger(NoticeManagerController.class);
	
	@Resource(name = "noticeService")
	private NoticeManagerService noticeService;
	
	/**
	 * 进入通知页面
	 * @param request
	 * @param modularId
	 * @return
	 */
	@RequestMapping("/noticeInfo/toNoticeInfoList")
	public String toNoticeInfoList(HttpServletRequest request, String modularId){
		request.setAttribute("modularId", modularId);
		return "notice/noticeInfo/noticeInfoList";

	}
	
	/**
	 * 进入通知模板页面
	 * @param request
	 * @param modularId
	 * @return
	 */
	@RequestMapping("/noticeTemplate/toNoticeTemplateList")
	public String toNoticeTemplateList(HttpServletRequest request, String modularId){
		request.setAttribute("modularId", modularId);
		return "notice/noticeTemplate/noticeTemplateList";
	}
	
	/**
	 * 查询模板列表
	 * @param request
	 * @param content
	 * @param rows
	 * @param page
	 * @return
	 */
	@RequestMapping(value ="/noticeTemplate/getNoticeTemplateList",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getNoticeTemplateList(HttpServletRequest request,String tempContent,int rows,int page){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		int allRows = noticeService.getCountNoticeTemplateListByCaseOnPage(tempContent);
		List<BhAuthNoticeTemplate> noticeTemplateList = noticeService.getNoticeTemplateListByCaseOnPage(tempContent, rows, (page - 1) * rows);
		if(noticeTemplateList == null ){
			noticeTemplateList = new ArrayList<BhAuthNoticeTemplate>();
		}
		returnMap.put("total", allRows);
		returnMap.put("rows", noticeTemplateList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		return jo.toString();
	}
	
	/**
	 * 保存模板
	 * @param request
	 * @return
	 */
	@RequestMapping("/noticeTemplate/saveNoticeTemplate")
	@ResponseBody
	public String saveNoticeTemplate(HttpServletRequest request) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			String noticeTempCode = request.getParameter("noticeTempCode");
			String noticeTempContent = request.getParameter("noticeTempContent");
			BhAuthNoticeTemplate noticeTemplate = new BhAuthNoticeTemplate();
			noticeTemplate.setNoticeTempCode(noticeTempCode);
			noticeTemplate.setNoticeTempContent(noticeTempContent);
			BhAuthNoticeTemplate bhAuthNoticeTemplate = new BhAuthNoticeTemplate();
			//判断模板是否存在，存在则修改模板，否则新增模板
			BhAuthNoticeTemplate template = noticeService.getNoticeTemplateById(noticeTempCode);
			if(template != null){
				bhAuthNoticeTemplate = noticeService.editNoticeTemplate(noticeTemplate);
			}else{
				bhAuthNoticeTemplate = noticeService.saveNoticeTemplate(noticeTemplate);
			}
			//将模板放入缓存
			Map<String,String> templateMap  = new HashMap<String,String>();
			templateMap = BeanUtil.transBean2Map(noticeTemplate);
			NoticeTemplateCache.putNoticeTemplateByTemplateMap(templateMap);
			if (bhAuthNoticeTemplate != null) {
				returnMap.put("success", "true");
			} else {
				returnMap.put("errorMsg", "新增失败！");
			}
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		} catch (Exception e) {
			logger.error(e,e);
			returnMap.put("errorMsg", "操作失败，请刷新后重试！");
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		}
	}
	
	/**
	 * 删除模板
	 * @param request
	 * @return
	 */
	@RequestMapping("/noticeTemplate/delNoticeTemplate")
	@ResponseBody
	public String delNoticeTemplate(HttpServletRequest request) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			String noticeTempCode = request.getParameter("noticeTempCode");
			int delResult = noticeService.delNoticeTemplate(noticeTempCode);
			if (delResult > 0) {
				returnMap.put("success", "true");
			} else {
				returnMap.put("errorMsg", "删除失败！");
			}
			//将模从缓存中删除
			NoticeTemplateCache.deleteNoticeTemplateByTemplateId(noticeTempCode);
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		} catch (Exception e) {
			returnMap.put("errorMsg", "操作失败，请刷新后重试！");
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		}
	}
	
	@RequestMapping(value = "/noticeTemplate/editNoticeTemplate", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String editNoticeTemplate(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String noticeTempCode = request.getParameter("noticeTempCode");
		try {
			BhAuthNoticeTemplate bhAuthNoticeTemplate = noticeService.getNoticeTemplateById(noticeTempCode);
			returnMap.put("success", "true");
			returnMap.put("data", bhAuthNoticeTemplate);
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		} catch (Exception e) {
			returnMap.put("errorMsg", "查询失败");
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		}

	}
}
