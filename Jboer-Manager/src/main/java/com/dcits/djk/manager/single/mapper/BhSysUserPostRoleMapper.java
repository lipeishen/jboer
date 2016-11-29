package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhSysUserPostRole;
import com.dcits.djk.manager.single.model.BhSysUserPostRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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