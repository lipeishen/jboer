package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhSysUserRoleInfo;
import com.dcits.djk.manager.single.model.BhSysUserRoleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BhSysUserRoleInfoMapper {
    int countByExample(BhSysUserRoleInfoExample example);

    int deleteByExample(BhSysUserRoleInfoExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(BhSysUserRoleInfo record);

    int insertSelective(BhSysUserRoleInfo record);

    List<BhSysUserRoleInfo> selectByExample(BhSysUserRoleInfoExample example);

    BhSysUserRoleInfo selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") BhSysUserRoleInfo record, @Param("example") BhSysUserRoleInfoExample example);

    int updateByExample(@Param("record") BhSysUserRoleInfo record, @Param("example") BhSysUserRoleInfoExample example);

    int updateByPrimaryKeySelective(BhSysUserRoleInfo record);

    int updateByPrimaryKey(BhSysUserRoleInfo record);
}