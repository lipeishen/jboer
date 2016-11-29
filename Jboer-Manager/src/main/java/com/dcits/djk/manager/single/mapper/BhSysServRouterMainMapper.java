package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhSysServRouterMain;
import com.dcits.djk.manager.single.model.BhSysServRouterMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BhSysServRouterMainMapper {
    int countByExample(BhSysServRouterMainExample example);

    int deleteByExample(BhSysServRouterMainExample example);

    int deleteByPrimaryKey(String routerId);

    int insert(BhSysServRouterMain record);

    int insertSelective(BhSysServRouterMain record);

    List<BhSysServRouterMain> selectByExample(BhSysServRouterMainExample example);

    BhSysServRouterMain selectByPrimaryKey(String routerId);

    int updateByExampleSelective(@Param("record") BhSysServRouterMain record, @Param("example") BhSysServRouterMainExample example);

    int updateByExample(@Param("record") BhSysServRouterMain record, @Param("example") BhSysServRouterMainExample example);

    int updateByPrimaryKeySelective(BhSysServRouterMain record);

    int updateByPrimaryKey(BhSysServRouterMain record);
}