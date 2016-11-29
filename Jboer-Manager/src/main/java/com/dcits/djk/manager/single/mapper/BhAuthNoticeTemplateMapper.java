package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhAuthNoticeTemplate;
import com.dcits.djk.manager.single.model.BhAuthNoticeTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BhAuthNoticeTemplateMapper {
    int countByExample(BhAuthNoticeTemplateExample example);

    int deleteByExample(BhAuthNoticeTemplateExample example);

    int deleteByPrimaryKey(String noticeTempCode);

    int insert(BhAuthNoticeTemplate record);

    int insertSelective(BhAuthNoticeTemplate record);

    List<BhAuthNoticeTemplate> selectByExample(BhAuthNoticeTemplateExample example);

    BhAuthNoticeTemplate selectByPrimaryKey(String noticeTempCode);

    int updateByExampleSelective(@Param("record") BhAuthNoticeTemplate record, @Param("example") BhAuthNoticeTemplateExample example);

    int updateByExample(@Param("record") BhAuthNoticeTemplate record, @Param("example") BhAuthNoticeTemplateExample example);

    int updateByPrimaryKeySelective(BhAuthNoticeTemplate record);

    int updateByPrimaryKey(BhAuthNoticeTemplate record);
}