package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhSysUserLoginInfo;
import com.dcits.djk.manager.single.model.BhSysUserLoginInfoExample;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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