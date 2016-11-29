package com.dcits.djk.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.djk.core.util.StringUtil;
import com.dcits.djk.manager.service.CacheSystemService;
import com.dcits.djk.manager.single.mapper.BhSysServRouterMainMapper;
import com.dcits.djk.manager.single.model.BhSysServRouterMain;
import com.dcits.djk.manager.single.model.BhSysServRouterMainExample;
import com.dcits.djk.manager.union.mapper.CacheSystemMapper;

@Service("cacheSystemService")
public class CacheSystemServiceImpl implements CacheSystemService{
	@Autowired
	private BhSysServRouterMainMapper bhSysServRouterMainMapper;
	@Autowired
	private CacheSystemMapper cacheSystemMapper;
	
	@Override
	public List<Map<String, String>> getRouterListAllInDb() {
		List<Map<String, String>> routerList = new ArrayList<Map<String, String>>();
		BhSysServRouterMainExample bhSysServRouterMainExample = new BhSysServRouterMainExample();
		List<BhSysServRouterMain> recordList = bhSysServRouterMainMapper.selectByExample(bhSysServRouterMainExample);
		if(recordList != null && recordList.size() > 0){
			for(int i = 0;i < recordList.size();i++){
				BhSysServRouterMain bhSysServRouterMain = recordList.get(i);
				String routerId = StringUtil.getNullStr(bhSysServRouterMain.getRouterId());
				String serviceName = StringUtil.getNullStr(bhSysServRouterMain.getServiceName());
				String serviceIp = StringUtil.getNullStr(bhSysServRouterMain.getServiceIp());
				String servicePort = StringUtil.getNullStr(bhSysServRouterMain.getServicePort());
				String serviceContext = StringUtil.getNullStr(bhSysServRouterMain.getServiceContext());
				Map<String,String> routerMap = new HashMap<String,String>();
				routerMap.put("routerId",routerId);
				routerMap.put("serviceName",serviceName);
				routerMap.put("serviceIp",serviceIp);
				routerMap.put("servicePort",servicePort);
				routerMap.put("serviceContext",serviceContext);
				routerList.add(routerMap);
			}
		}
		return routerList;
	}
	


	@Override
	public List<Map<String, String>> getAllProvince() {
		return cacheSystemMapper.getAllProvice();
	}
	
	@Override
	public List<Map<String, String>> getCitysByProvinceCode(String provinceCode) {
		return cacheSystemMapper.getCitysByProvinceCode(provinceCode);
	}
	
	@Override
	public List<Map<String, String>> getCountrysByCityCode(String cityCode) {
		return cacheSystemMapper.getCountrysByCityCode(cityCode);
	}

	@Override
	public List<Map<String, String>> getAllCity() {
		return cacheSystemMapper.getAllCity();
	}
	
	@Override
	public List<Map<String, String>> getAllCountry() {
		return cacheSystemMapper.getAllCountry();
	}

		
//		for(int i = 0;i < recordList.size();i++){
//			Map<String, String> valueMap = recordList.get(i);
//			String groupId = valueMap.get("groupid");
//			String serviceIds = valueMap.get("serviceids");
//			map.put(groupId, serviceIds);
//		}
//		return map;
//	}

	@Override
	public List<Map<String, String>> getAllCityInGroupCountry() {
		return cacheSystemMapper.getAllCityInGroupCountry();
	}
}
