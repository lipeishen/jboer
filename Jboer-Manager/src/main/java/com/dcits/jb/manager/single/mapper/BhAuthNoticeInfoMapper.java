package com.dcits.jb.manager.single.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhAuthNoticeInfo;
import com.dcits.jb.manager.single.model.BhAuthNoticeInfoExample;

public interface BhAuthNoticeInfoMapper {
    int countByExample(BhAuthNoticeInfoExample example);

    int deleteByExample(BhAuthNoticeInfoExample example);

    int deleteByPrimaryKey(String noticeId);

    int insert(BhAuthNoticeInfo record);

    int insertSelective(BhAuthNoticeInfo record);

    List<BhAuthNoticeInfo> selectByExample(BhAuthNoticeInfoExample example);

    BhAuthNoticeInfo selectByPrimaryKey(String noticeId);

    int updateByExampleSelective(@Param("record") BhAuthNoticeInfo record, @Param("example") BhAuthNoticeInfoExample example);

    int updateByExample(@Param("record") BhAuthNoticeInfo record, @Param("example") BhAuthNoticeInfoExample example);

    int updateByPrimaryKeySelective(BhAuthNoticeInfo record);

    int updateByPrimaryKey(BhAuthNoticeInfo record);
}