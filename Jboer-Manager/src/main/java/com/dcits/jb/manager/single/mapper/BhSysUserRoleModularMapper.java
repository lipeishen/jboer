package com.dcits.jb.manager.single.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhSysUserRoleModular;
import com.dcits.jb.manager.single.model.BhSysUserRoleModularExample;

public interface BhSysUserRoleModularMapper {
    int countByExample(BhSysUserRoleModularExample example);

    int deleteByExample(BhSysUserRoleModularExample example);

    int deleteByPrimaryKey(String roleModularId);

    int insert(BhSysUserRoleModular record);

    int insertSelective(BhSysUserRoleModular record);

    List<BhSysUserRoleModular> selectByExample(BhSysUserRoleModularExample example);

    BhSysUserRoleModular selectByPrimaryKey(String roleModularId);

    int updateByExampleSelective(@Param("record") BhSysUserRoleModular record, @Param("example") BhSysUserRoleModularExample example);

    int updateByExample(@Param("record") BhSysUserRoleModular record, @Param("example") BhSysUserRoleModularExample example);

    int updateByPrimaryKeySelective(BhSysUserRoleModular record);

    int updateByPrimaryKey(BhSysUserRoleModular record);

}