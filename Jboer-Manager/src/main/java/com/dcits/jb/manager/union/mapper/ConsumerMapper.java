package com.dcits.jb.manager.union.mapper;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.annotations.Param;

public interface ConsumerMapper {
	
 int getCountConsumerListByCaseOnPage(@Param("surname")String surname,@Param("name")String name,@Param("mobphone")String mobphone);

 List<ConcurrentHashMap<String, String>> getConsumerListByCaseOnPage(@Param("surname")String surname,@Param("name")String name,@Param("mobphone")String mobphone,@Param("rows")int rows, @Param("page")int page);
 
}
