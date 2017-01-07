package com.dcits.jb.manager.single.mapper;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhSysUserPostInfo;
import com.dcits.jb.manager.single.model.BhSysUserPostInfoExample;

public interface BhSysUserPostInfoMapper {
    int countByExample(BhSysUserPostInfoExample example);

    int deleteByExample(BhSysUserPostInfoExample example);

    int deleteByPrimaryKey(String postId);

    int insert(BhSysUserPostInfo record);

    int insertSelective(BhSysUserPostInfo record);

    List<BhSysUserPostInfo> selectByExample(BhSysUserPostInfoExample example);

    BhSysUserPostInfo selectByPrimaryKey(String postId);

    int updateByExampleSelective(@Param("record") BhSysUserPostInfo record, @Param("example") BhSysUserPostInfoExample example);

    int updateByExample(@Param("record") BhSysUserPostInfo record, @Param("example") BhSysUserPostInfoExample example);

    int updateByPrimaryKeySelective(BhSysUserPostInfo record);

    int updateByPrimaryKey(BhSysUserPostInfo record);
}