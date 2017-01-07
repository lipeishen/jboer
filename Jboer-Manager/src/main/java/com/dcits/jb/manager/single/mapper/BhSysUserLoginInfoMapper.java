package com.dcits.jb.manager.single.mapper;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhSysUserLoginInfo;
import com.dcits.jb.manager.single.model.BhSysUserLoginInfoExample;

public interface BhSysUserLoginInfoMapper {
    int countByExample(BhSysUserLoginInfoExample example);

    int deleteByExample(BhSysUserLoginInfoExample example);

    int deleteByPrimaryKey(String userId);

    int insert(BhSysUserLoginInfo record);

    int insertSelective(BhSysUserLoginInfo record);

    List<BhSysUserLoginInfo> selectByExample(BhSysUserLoginInfoExample example);

    BhSysUserLoginInfo selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") BhSysUserLoginInfo record, @Param("example") BhSysUserLoginInfoExample example);

    int updateByExample(@Param("record") BhSysUserLoginInfo record, @Param("example") BhSysUserLoginInfoExample example);

    int updateByPrimaryKeySelective(BhSysUserLoginInfo record);

    int updateByPrimaryKey(BhSysUserLoginInfo record);
}