package com.dcits.jb.manager.single.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhSysUserOrgInfo;
import com.dcits.jb.manager.single.model.BhSysUserOrgInfoExample;

public interface BhSysUserOrgInfoMapper {
    int countByExample(BhSysUserOrgInfoExample example);

    int deleteByExample(BhSysUserOrgInfoExample example);

    int deleteByPrimaryKey(String orgId);

    int insert(BhSysUserOrgInfo record);

    int insertSelective(BhSysUserOrgInfo record);

    List<BhSysUserOrgInfo> selectByExample(BhSysUserOrgInfoExample example);

    BhSysUserOrgInfo selectByPrimaryKey(String orgId);

    int updateByExampleSelective(@Param("record") BhSysUserOrgInfo record, @Param("example") BhSysUserOrgInfoExample example);

    int updateByExample(@Param("record") BhSysUserOrgInfo record, @Param("example") BhSysUserOrgInfoExample example);

    int updateByPrimaryKeySelective(BhSysUserOrgInfo record);

    int updateByPrimaryKey(BhSysUserOrgInfo record);
  
}