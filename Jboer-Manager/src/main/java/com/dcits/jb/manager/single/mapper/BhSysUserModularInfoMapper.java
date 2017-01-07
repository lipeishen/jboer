package com.dcits.jb.manager.single.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhSysUserModularInfo;
import com.dcits.jb.manager.single.model.BhSysUserModularInfoExample;

public interface BhSysUserModularInfoMapper {
    int countByExample(BhSysUserModularInfoExample example);

    int deleteByExample(BhSysUserModularInfoExample example);

    int deleteByPrimaryKey(String modularId);

    int insert(BhSysUserModularInfo record);

    int insertSelective(BhSysUserModularInfo record);

    List<BhSysUserModularInfo> selectByExample(BhSysUserModularInfoExample example);

    BhSysUserModularInfo selectByPrimaryKey(String modularId);

    int updateByExampleSelective(@Param("record") BhSysUserModularInfo record, @Param("example") BhSysUserModularInfoExample example);

    int updateByExample(@Param("record") BhSysUserModularInfo record, @Param("example") BhSysUserModularInfoExample example);

    int updateByPrimaryKeySelective(BhSysUserModularInfo record);

    int updateByPrimaryKey(BhSysUserModularInfo record);
}