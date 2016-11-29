package com.dcits.djk.manager.service;

import java.util.List;
import java.util.Map;

public interface CacheSystemService {
	public List<Map<String,String>> getRouterListAllInDb();
		
	public List<Map<String, String>> getAllProvince();
	
	public List<Map<String, String>> getCitysByProvinceCode(String provinceCode);
	
	public List<Map<String, String>> getCountrysByCityCode(String cityCode);

	public List<Map<String, String>> getAllCity();
	
	public List<Map<String, String>> getAllCountry();
	
	
	public List<Map<String, String>> getAllCityInGroupCountry();
}
