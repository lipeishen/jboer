package com.dcits.djk.manager.single.mapper;

import com.dcits.djk.manager.single.model.BhSysBaseDictionary;
import com.dcits.djk.manager.single.model.BhSysBaseDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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