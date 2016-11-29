package com.dcits.djk.manager.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.djk.manager.service.NoticeManagerService;
import com.dcits.djk.manager.single.mapper.BhAuthNoticeTemplateMapper;
import com.dcits.djk.manager.single.model.BhAuthNoticeTemplate;
import com.dcits.djk.manager.union.mapper.NoticeServiceMapper;
@Service("noticeService")
public class NoticeManagerServiceImpl implements NoticeManagerService {
	
	private Logger logger = Logger.getLogger(NoticeManagerServiceImpl.class);
	
	@Autowired
	private BhAuthNoticeTemplateMapper bhAuthNoticeTemplateMapper;
	
	@Autowired
	private NoticeServiceMapper noticeServiceMapper;
	
	@Override
	public int getCountNoticeTemplateListByCaseOnPage(String tempContent) {
		if (tempContent != null && !"".equals(tempContent)) {
			tempContent = "%"+tempContent+"%";
		}
		return noticeServiceMapper.getCountNoticeTemplateListByCaseOnPage(tempContent);
	}

	@Override
	public List<BhAuthNoticeTemplate> getNoticeTemplateListByCaseOnPage(String tempContent, int rows, int page) {
		if (tempContent != null && !"".equals(tempContent)) {
			tempContent = "%"+tempContent+"%";
		}
		List<BhAuthNoticeTemplate> list = noticeServiceMapper.getNoticeTemplateListByCaseOnPage(tempContent, rows, page);
		return list;
	}

	@Override
	public BhAuthNoticeTemplate saveNoticeTemplate(BhAuthNoticeTemplate bhAuthNoticeTemplate) {
		bhAuthNoticeTemplateMapper.insert(bhAuthNoticeTemplate);
		return bhAuthNoticeTemplate;
	}

	@Override
	public BhAuthNoticeTemplate editNoticeTemplate(BhAuthNoticeTemplate bhAuthNoticeTemplate) {
		bhAuthNoticeTemplateMapper.updateByPrimaryKeySelective(bhAuthNoticeTemplate);
		return bhAuthNoticeTemplate;
	}

	@Override
	public int delNoticeTemplate(String noticeTempCode) {
		return bhAuthNoticeTemplateMapper.deleteByPrimaryKey(noticeTempCode);
	}

	@Override
	public BhAuthNoticeTemplate getNoticeTemplateById(String noticeTempCode) {
		 return bhAuthNoticeTemplateMapper.selectByPrimaryKey(noticeTempCode);
	}

}
