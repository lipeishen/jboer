package com.dcits.djk.manager.union.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CacheSystemMapper {

	List<Map<String, String>> getAllProvice();
	
	List<Map<String, String>> getCitysByProvinceCode(@Param("provinceCode") String provinceCode);
	
	List<Map<String, String>> getCountrysByCityCode(@Param("cityCode")String cityCode);

	List<Map<String, String>> getAllCity();
	
	List<Map<String, String>> getAllCityInGroupCountry();
	
	List<Map<String, String>> getAllCountry();
	
	List<Map<String, String>> getAllServGroup();
}
