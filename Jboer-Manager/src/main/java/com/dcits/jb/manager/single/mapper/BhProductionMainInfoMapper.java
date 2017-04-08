package com.dcits.jb.manager.single.mapper;

import com.dcits.jb.manager.single.model.BhProductionMainInfo;
import com.dcits.jb.manager.single.model.BhProductionMainInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BhProductionMainInfoMapper {
    int countByExample(BhProductionMainInfoExample example);

    int deleteByExample(BhProductionMainInfoExample example);

    int deleteByPrimaryKey(String productionId);

    int insert(BhProductionMainInfo record);

    int insertSelective(BhProductionMainInfo record);

    List<BhProductionMainInfo> selectByExample(BhProductionMainInfoExample example);

    BhProductionMainInfo selectByPrimaryKey(String productionId);

    int updateByExampleSelective(@Param("record") BhProductionMainInfo record, @Param("example") BhProductionMainInfoExample example);

    int updateByExample(@Param("record") BhProductionMainInfo record, @Param("example") BhProductionMainInfoExample example);

    int updateByPrimaryKeySelective(BhProductionMainInfo record);

    int updateByPrimaryKey(BhProductionMainInfo record);
}