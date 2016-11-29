package com.dcits.djk.manager.union.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dcits.djk.manager.single.model.BhAuthNoticeTemplate;

public interface NoticeServiceMapper {
	
	int getCountNoticeTemplateListByCaseOnPage(@Param("tempContent")String tempContent);
	
	List<BhAuthNoticeTemplate> getNoticeTemplateListByCaseOnPage(@Param("tempContent")String tempContent, @Param("rows")int rows, @Param("page")int page);

}
