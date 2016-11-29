package com.dcits.djk.manager.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcits.djk.core.cache.ServMainInfoCache;
import com.dcits.djk.core.cache.ServMainListCache;
import com.dcits.djk.core.cache.ServiceRouterCache;
import com.dcits.djk.core.cache.SysDictCityCache;
import com.dcits.djk.core.cache.SysDictCountryCache;
import com.dcits.djk.core.cache.SysDictProvinceCache;
import com.dcits.djk.manager.service.CacheSystemService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/cacheSystem")
public class CacheSystemController {
	private Logger logger = Logger.getLogger(CacheSystemController.class);
	
	@Resource(name="cacheSystemService")
	private CacheSystemService cacheSystemService;
	
	@RequestMapping("/routerInfo/toRouterList")
	public String toRouterList(HttpServletRequest request,Model model) {
		logger.debug("");
		return "/cacheSystem/routerInfo/routerList";
	}
	
	@RequestMapping("/province/toProvinceList")
	public String toProvinceList(HttpServletRequest request,Model model) {
		return "/cacheSystem/addressInfo/provinceList";
	}
	
	@RequestMapping("/province/getListInProvinceList")
	@ResponseBody
	public String getListInProvinceList(int rows,int page){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String,String>> provinceAllList = SysDictProvinceCache.getDictProvinceByProvinceList();
		List<Map<String,String>> provinceList = new ArrayList<Map<String,String>>();
		if(provinceAllList != null){
			Collections.sort(provinceAllList,new Comparator<Map<String,String>>() {//内部类
	            public int compare(Map<String,String> arg0, Map<String,String> arg1) {
	            	String question0  = arg0.get("province_code");
	            	String question1  = arg1.get("province_code");
	                return question0.compareTo(question1);
	            }
			});
			if(provinceAllList.size() < rows){
				provinceList = provinceAllList;
			}else{
				if(rows * page < provinceAllList.size()){
					for(int i = (page-1)*rows;i < page*rows;i++){
						Map<String,String> provinceMap = provinceAllList.get(i);
						provinceList.add(provinceMap);
					}
				}else{
					if(provinceAllList.size()%rows > 0){
						page = provinceAllList.size()/rows + 1;
					}else{
						page = provinceAllList.size()/rows;
					}
					for(int i = (page-1)*rows;i < provinceAllList.size();i++){
						Map<String,String> provinceMap = provinceAllList.get(i);
						provinceList.add(provinceMap);
					}
				}
			}
			
			returnMap.put("total", provinceAllList.size());
			returnMap.put("rows", provinceList);
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		}
		return null;
	}
	
	
	@RequestMapping("/province/refreshProvinceCache")
	@ResponseBody
	public String refreshProvinceCache(int rows,int page){
		SysDictProvinceCache.deleteDictProvinceAll();
		List<Map<String,String>> pAllList = cacheSystemService.getAllProvince();
		List<Map<String,String>> provinceAllList = new ArrayList<Map<String,String>>();
		for (Map<String, String> map : pAllList) {
			String provinceCode = map.get("province_code");
			StringBuffer bf = new StringBuffer();
			//根据省的id查询城市
			List<Map<String, String>> citys = cacheSystemService.getCitysByProvinceCode(provinceCode);
			for (Map<String, String> map2 : citys) {
				String cityCode = map2.get("city_code");
				bf.append(cityCode+",");
			}
			if(bf.length() > 0){
				map.put("city_codes", bf.substring(0, bf.length() - 1).toString());
			}
			provinceAllList.add(map);
		}
		SysDictProvinceCache.putDictProvinceByProvinceList(provinceAllList);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String,String>> provinceList = new ArrayList<Map<String,String>>();
		if(provinceAllList.size() < rows){
			provinceList = provinceAllList;
		}else{
			if(rows * page < provinceAllList.size()){
				for(int i = (page-1)*rows;i < page*rows;i++){
					Map<String,String> routerMap = provinceAllList.get(i);
					provinceList.add(routerMap);
				}
			}else{
				if(provinceAllList.size()%rows > 0){
					page = provinceAllList.size()/rows + 1;
				}else{
					page = provinceAllList.size()/rows;
				}
				for(int i = (page-1)*rows;i < provinceAllList.size();i++){
					Map<String,String> routerMap = provinceAllList.get(i);
					provinceList.add(routerMap);
				}
			}
		}
		
		returnMap.put("total", provinceAllList.size());
		returnMap.put("rows", provinceList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		return jo.toString();
	}
	
	@RequestMapping("/city/toCityList")
	public String toCityList(HttpServletRequest request,Model model) {
		return "/cacheSystem/addressInfo/cityList";
	}
	
	@RequestMapping("/city/getListInCityList")
	@ResponseBody
	public String getListInCityList(int rows,int page){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String,String>> cityAllList = SysDictCityCache.getDictCityByCityList();
		List<Map<String,String>> cityList = new ArrayList<Map<String,String>>();
		if(cityAllList != null){
			Collections.sort(cityAllList,new Comparator<Map<String,String>>() {//内部类
	            public int compare(Map<String,String> arg0, Map<String,String> arg1) {
	            	String question0  = arg0.get("city_code");
	            	String question1  = arg1.get("city_code");
	                return question0.compareTo(question1);
	            }
			});
			if(cityAllList.size() < rows){
				cityList = cityAllList;
			}else{
				if(rows * page < cityAllList.size()){
					for(int i = (page-1)*rows;i < page*rows;i++){
						Map<String,String> cityMap = cityAllList.get(i);
						cityList.add(cityMap);
					}
				}else{
					if(cityAllList.size()%rows > 0){
						page = cityAllList.size()/rows + 1;
					}else{
						page = cityAllList.size()/rows;
					}
					for(int i = (page-1)*rows;i < cityAllList.size();i++){
						Map<String,String> cityMap = cityAllList.get(i);
						cityList.add(cityMap);
					}
				}
			}
			
			returnMap.put("total", cityAllList.size());
			returnMap.put("rows", cityList);
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		}
		return null;
	}
	
	
	@RequestMapping("/city/refreshCityCache")
	@ResponseBody
	public String refreshCityCache(int rows,int page){
		SysDictCityCache.deleteDictCityAll();
		List<Map<String,String>> cityAllList = cacheSystemService.getAllCityInGroupCountry();
//		List<Map<String,String>> cAllList = cacheSystemService.getAllCity();
//		List<Map<String,String>> cityAllList = new ArrayList<Map<String,String>>();
//		for (Map<String, String> map : cAllList) {
//			String cityCode = map.get("city_code");
//			StringBuffer bf = new StringBuffer();
//			//根据城市id查询县
//			List<Map<String, String>> countrys = cacheSystemService.getCountrysByCityCode(cityCode);
//			for (Map<String, String> map2 : countrys) {
//				String countryCode = map2.get("country_code");
//				bf.append(countryCode+",");
//			}
//			if(bf.length() > 0){
//				map.put("country_codes", bf.substring(0, bf.length() - 1).toString());
//			}
//			cityAllList.add(map);
//		}
		SysDictCityCache.putDictCityByCityList(cityAllList);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String,String>> cityList = new ArrayList<Map<String,String>>();
		if(cityAllList.size() < rows){
			cityList = cityAllList;
		}else{
			if(rows * page < cityAllList.size()){
				for(int i = (page-1)*rows;i < page*rows;i++){
					Map<String,String> cityMap = cityAllList.get(i);
					cityList.add(cityMap);
				}
			}else{
				if(cityAllList.size()%rows > 0){
					page = cityAllList.size()/rows + 1;
				}else{
					page = cityAllList.size()/rows;
				}
				for(int i = (page-1)*rows;i < cityAllList.size();i++){
					Map<String,String> cityMap = cityAllList.get(i);
					cityList.add(cityMap);
				}
			}
		}
		
		returnMap.put("total", cityAllList.size());
		returnMap.put("rows", cityList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		return jo.toString();
	}
	
	
	@RequestMapping("/country/toCountryList")
	public String toCountryList(HttpServletRequest request,Model model) {
		return "/cacheSystem/addressInfo/countryList";
	}
	
	@RequestMapping("/country/getListInCountryList")
	@ResponseBody
	public String getListInCountryList(int rows,int page){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String,String>> countryAllList = SysDictCountryCache.getDictCountryByCountryList();
		List<Map<String,String>> countryList = new ArrayList<Map<String,String>>();
		if(countryAllList != null){
			Collections.sort(countryAllList,new Comparator<Map<String,String>>() {//内部类
	            public int compare(Map<String,String> arg0, Map<String,String> arg1) {
	            	String question0  = arg0.get("country_code");
	            	String question1  = arg1.get("country_code");
	                return question0.compareTo(question1);
	            }
			});
			if(countryAllList.size() < rows){
				countryList = countryAllList;
			}else{
				if(rows * page < countryAllList.size()){
					for(int i = (page-1)*rows;i < page*rows;i++){
						Map<String,String> countryMap = countryAllList.get(i);
						countryList.add(countryMap);
					}
				}else{
					if(countryAllList.size()%rows > 0){
						page = countryAllList.size()/rows + 1;
					}else{
						page = countryAllList.size()/rows;
					}
					for(int i = (page-1)*rows;i < countryAllList.size();i++){
						Map<String,String> countryMap = countryAllList.get(i);
						countryList.add(countryMap);
					}
				}
			}
			
			returnMap.put("total", countryAllList.size());
			returnMap.put("rows", countryList);
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		}
		return null;
	}
	
	
	@RequestMapping("/country/refreshCountryCache")
	@ResponseBody
	public String refreshCountryCache(int rows,int page){
		SysDictCountryCache.deleteDictCountryAll();
		List<Map<String,String>> countryAllList = cacheSystemService.getAllCountry();
		SysDictCountryCache.putDictCountryByCountryList(countryAllList);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String,String>> countryList = new ArrayList<Map<String,String>>();
		if(countryAllList.size() < rows){
			countryList = countryAllList;
		}else{
			if(rows * page < countryAllList.size()){
				for(int i = (page-1)*rows;i < page*rows;i++){
					Map<String,String> countryMap = countryAllList.get(i);
					countryList.add(countryMap);
				}
			}else{
				if(countryAllList.size()%rows > 0){
					page = countryAllList.size()/rows + 1;
				}else{
					page = countryAllList.size()/rows;
				}
				for(int i = (page-1)*rows;i < countryAllList.size();i++){
					Map<String,String> countryMap = countryAllList.get(i);
					countryList.add(countryMap);
				}
			}
		}
		
		returnMap.put("total", countryAllList.size());
		returnMap.put("rows", countryList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		return jo.toString();
	}
	
	@RequestMapping("/routerInfo/getListInRouterList")
	@ResponseBody
	public String getListInRouterList(int rows,int page){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String,String>> routerAllList = ServiceRouterCache.getRouterInfoByRouterList();
		List<Map<String,String>> routerList = new ArrayList<Map<String,String>>();
		if(routerAllList.size() < rows){
			routerList = routerAllList;
		}else{
			if(rows * page < routerAllList.size()){
				for(int i = (page-1)*rows;i < page*rows;i++){
					Map<String,String> routerMap = routerAllList.get(i);
					routerList.add(routerMap);
				}
			}else{
				if(routerAllList.size()%rows > 0){
					page = routerAllList.size()/rows + 1;
				}else{
					page = routerAllList.size()/rows;
				}
				for(int i = (page-1)*rows;i < routerAllList.size();i++){
					Map<String,String> routerMap = routerAllList.get(i);
					routerList.add(routerMap);
				}
			}
		}
		
		returnMap.put("total", routerAllList.size());
		returnMap.put("rows", routerList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		//logger.debug(jo.toString());
		return jo.toString();
	}
	
	@RequestMapping("/routerInfo/toFlustRouterCache")
	@ResponseBody
	public String getListInRouterList(){
		try{
			List<Map<String, String>> routerList = cacheSystemService.getRouterListAllInDb();
			ServiceRouterCache.deleteRouterInfoAll();
			ServiceRouterCache.putRouterInfoByRouterList(routerList);
			
			return "true";
		}catch(Exception e){
			logger.error(e,e);
			return "false";
		}
	}
	
	@RequestMapping("/routerInfo/toDeleteOneRouterCache")
	@ResponseBody
	public String toDeleteOneRouterCache(String serviceName){
		try{
			ServiceRouterCache.deleteRouterInfoByServiceName(serviceName);
			
			return "true";
		}catch(Exception e){
			logger.error(e,e);
			return "false";
		}
	}
	
	@RequestMapping("/servMainInfo/toServMainList")
	public String toServMainList(HttpServletRequest request,Model model) {
		logger.debug("");
		return "/cacheSystem/servMainInfo/servMainList";
	}
	
	@RequestMapping("/servMainInfo/getListInservMainList")
	@ResponseBody
	public String getListInservMainList(int rows,int page){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String,String>> servMainAllList = ServMainInfoCache.getServMainInfoByServMainList();
		List<Map<String,String>> servMainList = new ArrayList<Map<String,String>>();
		if(servMainAllList.size() < rows){
			servMainList = servMainAllList;
		}else{
			if(rows * page < servMainAllList.size()){
				for(int i = (page-1)*rows;i < page*rows;i++){
					Map<String,String> routerMap = servMainAllList.get(i);
					servMainList.add(routerMap);
				}
			}else{
				if(servMainAllList.size()%rows > 0){
					page = servMainAllList.size()/rows + 1;
				}else{
					page = servMainAllList.size()/rows;
				}
				for(int i = (page-1)*rows;i < servMainAllList.size();i++){
					Map<String,String> routerMap = servMainAllList.get(i);
					servMainList.add(routerMap);
				}
			}
		}
		
		returnMap.put("total", servMainAllList.size());
		returnMap.put("rows", servMainList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		//logger.debug(jo.toString());
		return jo.toString();
	}
	
	
	@RequestMapping("/servMainInfo/toDeleteOneServMainCache")
	@ResponseBody
	public String toDeleteOneServMainCache(String serviceId){
		try{
			ServMainInfoCache.deleteServMainInfoByServiceId(serviceId);
			
			return "true";
		}catch(Exception e){
			logger.error(e,e);
			return "false";
		}
	}
	
	@RequestMapping("/servGroup/toServGroupList")
	public String toServGroupList(HttpServletRequest request,Model model) {
		logger.debug("");
		return "/cacheSystem/servMainInfo/servGroupList";
	}
	
	@RequestMapping("/servGroup/getListInservGroupList")
	@ResponseBody
	public String getListInservGroupList(int rows,int page){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String,String>> servGroupAllList = new ArrayList<Map<String,String>>();
		Map<String,String> cacheMap = ServMainListCache.getServMainMapAll(); 
		for(Map.Entry<String, String> entry : cacheMap.entrySet()) {  
			String key = entry.getKey();
			String value = entry.getValue();
			Map<String,String> recordMap = new HashMap<String,String>();
			recordMap.put("groupId", key);
			recordMap.put("serviceIds", value);
			servGroupAllList.add(recordMap);
		}
		List<Map<String,String>> servGroupList = new ArrayList<Map<String,String>>();
		if(servGroupAllList.size() < rows){
			servGroupList = servGroupAllList;
		}else{
			if(rows * page < servGroupAllList.size()){
				for(int i = (page-1)*rows;i < page*rows;i++){
					Map<String,String> routerMap = servGroupAllList.get(i);
					servGroupList.add(routerMap);
				}
			}else{
				if(servGroupAllList.size()%rows > 0){
					page = servGroupAllList.size()/rows + 1;
				}else{
					page = servGroupAllList.size()/rows;
				}
				for(int i = (page-1)*rows;i < servGroupAllList.size();i++){
					Map<String,String> routerMap = servGroupAllList.get(i);
					servGroupList.add(routerMap);
				}
			}
		}
		returnMap.put("total", servGroupAllList.size());
		returnMap.put("rows", servGroupList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		//logger.debug(jo.toString());
		return jo.toString();
	}
	
	
	@RequestMapping("/servGroup/toDeleteOneServGroupCache")
	@ResponseBody
	public String toDeleteOneServGroupCache(String groupId){
		try{
			ServMainListCache.deleteServMainArrayByGroupId(groupId);
			
			return "true";
		}catch(Exception e){
			logger.error(e,e);
			return "false";
		}
	}
}
