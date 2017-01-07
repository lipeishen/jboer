package com.dcits.jb.manager.single.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhSysFeedbackInfo;
import com.dcits.jb.manager.single.model.BhSysFeedbackInfoExample;

public interface BhSysFeedbackInfoMapper {
    int countByExample(BhSysFeedbackInfoExample example);

    int deleteByExample(BhSysFeedbackInfoExample example);

    int deleteByPrimaryKey(String feedbackId);

    int insert(BhSysFeedbackInfo record);

    int insertSelective(BhSysFeedbackInfo record);

    List<BhSysFeedbackInfo> selectByExample(BhSysFeedbackInfoExample example);

    BhSysFeedbackInfo selectByPrimaryKey(String feedbackId);

    int updateByExampleSelective(@Param("record") BhSysFeedbackInfo record, @Param("example") BhSysFeedbackInfoExample example);

    int updateByExample(@Param("record") BhSysFeedbackInfo record, @Param("example") BhSysFeedbackInfoExample example);

    int updateByPrimaryKeySelective(BhSysFeedbackInfo record);

    int updateByPrimaryKey(BhSysFeedbackInfo record);
}