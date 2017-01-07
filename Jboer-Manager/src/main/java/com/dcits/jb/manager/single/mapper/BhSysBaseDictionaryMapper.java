package com.dcits.jb.manager.single.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.dcits.jb.manager.single.model.BhSysBaseDictionary;
import com.dcits.jb.manager.single.model.BhSysBaseDictionaryExample;

public interface BhSysBaseDictionaryMapper {
    int countByExample(BhSysBaseDictionaryExample example);

    int deleteByExample(BhSysBaseDictionaryExample example);

    int deleteByPrimaryKey(String dictId);

    int insert(BhSysBaseDictionary record);

    int insertSelective(BhSysBaseDictionary record);

    List<BhSysBaseDictionary> selectByExample(BhSysBaseDictionaryExample example);

    BhSysBaseDictionary selectByPrimaryKey(String dictId);

    int updateByExampleSelective(@Param("record") BhSysBaseDictionary record, @Param("example") BhSysBaseDictionaryExample example);

    int updateByExample(@Param("record") BhSysBaseDictionary record, @Param("example") BhSysBaseDictionaryExample example);

    int updateByPrimaryKeySelective(BhSysBaseDictionary record);

    int updateByPrimaryKey(BhSysBaseDictionary record);
}