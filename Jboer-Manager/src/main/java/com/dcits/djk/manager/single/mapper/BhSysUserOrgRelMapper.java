package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhSysUserOrgRel;
import com.dcits.djk.manager.single.model.BhSysUserOrgRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BhSysUserOrgRelMapper {
    int countByExample(BhSysUserOrgRelExample example);

    int deleteByExample(BhSysUserOrgRelExample example);

    int deleteByPrimaryKey(String userOrgId);

    int insert(BhSysUserOrgRel record);

    int insertSelective(BhSysUserOrgRel record);

    List<BhSysUserOrgRel> selectByExample(BhSysUserOrgRelExample example);

    BhSysUserOrgRel selectByPrimaryKey(String userOrgId);

    int updateByExampleSelective(@Param("record") BhSysUserOrgRel record, @Param("example") BhSysUserOrgRelExample example);

    int updateByExample(@Param("record") BhSysUserOrgRel record, @Param("example") BhSysUserOrgRelExample example);

    int updateByPrimaryKeySelective(BhSysUserOrgRel record);

    int updateByPrimaryKey(BhSysUserOrgRel record);
}