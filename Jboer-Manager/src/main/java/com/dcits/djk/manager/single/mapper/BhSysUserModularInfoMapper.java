package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhSysUserModularInfo;
import com.dcits.djk.manager.single.model.BhSysUserModularInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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