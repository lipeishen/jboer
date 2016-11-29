package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhMonitorTestTemp;
import com.dcits.djk.manager.single.model.BhMonitorTestTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BhMonitorTestTempMapper {
    int countByExample(BhMonitorTestTempExample example);

    int deleteByExample(BhMonitorTestTempExample example);

    int deleteByPrimaryKey(String serviceNodeId);

    int insert(BhMonitorTestTemp record);

    int insertSelective(BhMonitorTestTemp record);

    List<BhMonitorTestTemp> selectByExample(BhMonitorTestTempExample example);

    BhMonitorTestTemp selectByPrimaryKey(String serviceNodeId);

    int updateByExampleSelective(@Param("record") BhMonitorTestTemp record, @Param("example") BhMonitorTestTempExample example);

    int updateByExample(@Param("record") BhMonitorTestTemp record, @Param("example") BhMonitorTestTempExample example);

    int updateByPrimaryKeySelective(BhMonitorTestTemp record);

    int updateByPrimaryKey(BhMonitorTestTemp record);
}