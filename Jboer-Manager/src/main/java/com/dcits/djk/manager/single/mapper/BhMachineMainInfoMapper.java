package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhMachineMainInfo;
import com.dcits.djk.manager.single.model.BhMachineMainInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BhMachineMainInfoMapper {
    int countByExample(BhMachineMainInfoExample example);

    int deleteByExample(BhMachineMainInfoExample example);

    int deleteByPrimaryKey(String machineId);

    int insert(BhMachineMainInfo record);

    int insertSelective(BhMachineMainInfo record);

    List<BhMachineMainInfo> selectByExample(BhMachineMainInfoExample example);

    BhMachineMainInfo selectByPrimaryKey(String machineId);

    int updateByExampleSelective(@Param("record") BhMachineMainInfo record, @Param("example") BhMachineMainInfoExample example);

    int updateByExample(@Param("record") BhMachineMainInfo record, @Param("example") BhMachineMainInfoExample example);

    int updateByPrimaryKeySelective(BhMachineMainInfo record);

    int updateByPrimaryKey(BhMachineMainInfo record);
}