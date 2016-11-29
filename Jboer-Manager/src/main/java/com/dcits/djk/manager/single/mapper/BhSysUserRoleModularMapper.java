package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhSysUserRoleModular;
import com.dcits.djk.manager.single.model.BhSysUserRoleModularExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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