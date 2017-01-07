package com.dcits.jb.manager.service;

import java.util.List;

import com.dcits.jb.manager.single.model.BhAuthNoticeTemplate;

public interface NoticeManagerService {
	
	/** 模板管理 */
	public int getCountNoticeTemplateListByCaseOnPage(String  tempContent);
	
	public List<BhAuthNoticeTemplate> getNoticeTemplateListByCaseOnPage(String tempContent, int rows, int page);
	
	public BhAuthNoticeTemplate saveNoticeTemplate(BhAuthNoticeTemplate bhAuthNoticeTemplate);
	
	public BhAuthNoticeTemplate editNoticeTemplate(BhAuthNoticeTemplate bhAuthNoticeTemplate);
	
	public int delNoticeTemplate(String noticeTempCode);
	
	public BhAuthNoticeTemplate getNoticeTemplateById(String noticeTempCode);
}
