package com.dcits.jb.manager.single.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhSysUserPostRole;
import com.dcits.jb.manager.single.model.BhSysUserPostRoleExample;

public interface BhSysUserPostRoleMapper {
    int countByExample(BhSysUserPostRoleExample example);

    int deleteByExample(BhSysUserPostRoleExample example);

    int deleteByPrimaryKey(String postRoleId);

    int insert(BhSysUserPostRole record);

    int insertSelective(BhSysUserPostRole record);

    List<BhSysUserPostRole> selectByExample(BhSysUserPostRoleExample example);

    BhSysUserPostRole selectByPrimaryKey(String postRoleId);

    int updateByExampleSelective(@Param("record") BhSysUserPostRole record, @Param("example") BhSysUserPostRoleExample example);

    int updateByExample(@Param("record") BhSysUserPostRole record, @Param("example") BhSysUserPostRoleExample example);

    int updateByPrimaryKeySelective(BhSysUserPostRole record);

    int updateByPrimaryKey(BhSysUserPostRole record);
}