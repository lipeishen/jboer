package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhProductionOrderInfo;
import com.dcits.djk.manager.single.model.BhProductionOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BhProductionOrderInfoMapper {
    int countByExample(BhProductionOrderInfoExample example);

    int deleteByExample(BhProductionOrderInfoExample example);

    int deleteByPrimaryKey(String proOrderId);

    int insert(BhProductionOrderInfo record);

    int insertSelective(BhProductionOrderInfo record);

    List<BhProductionOrderInfo> selectByExample(BhProductionOrderInfoExample example);

    BhProductionOrderInfo selectByPrimaryKey(String proOrderId);

    int updateByExampleSelective(@Param("record") BhProductionOrderInfo record, @Param("example") BhProductionOrderInfoExample example);

    int updateByExample(@Param("record") BhProductionOrderInfo record, @Param("example") BhProductionOrderInfoExample example);

    int updateByPrimaryKeySelective(BhProductionOrderInfo record);

    int updateByPrimaryKey(BhProductionOrderInfo record);
}