package com.dcits.jb.manager.single.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhAuthUserMain;
import com.dcits.jb.manager.single.model.BhAuthUserMainExample;

public interface BhAuthUserMainMapper {
    int countByExample(BhAuthUserMainExample example);

    int deleteByExample(BhAuthUserMainExample example);

    int deleteByPrimaryKey(String userId);

    int insert(BhAuthUserMain record);

    int insertSelective(BhAuthUserMain record);

    List<BhAuthUserMain> selectByExample(BhAuthUserMainExample example);

    BhAuthUserMain selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") BhAuthUserMain record, @Param("example") BhAuthUserMainExample example);

    int updateByExample(@Param("record") BhAuthUserMain record, @Param("example") BhAuthUserMainExample example);

    int updateByPrimaryKeySelective(BhAuthUserMain record);

    int updateByPrimaryKey(BhAuthUserMain record);
}