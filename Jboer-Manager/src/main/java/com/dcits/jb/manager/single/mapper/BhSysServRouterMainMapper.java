package com.dcits.jb.manager.single.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhSysServRouterMain;
import com.dcits.jb.manager.single.model.BhSysServRouterMainExample;

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