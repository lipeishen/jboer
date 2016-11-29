package com.dcits.djk.manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcits.djk.core.util.StringUtil;
import com.dcits.djk.core.util.UuidUtil;
import com.dcits.djk.core.util.WebConnectionUtil;
import com.dcits.djk.manager.env.ServMonitorEnv;
import com.dcits.djk.manager.service.MonitorManagerService;
import com.dcits.djk.manager.single.model.BhMonitorTestTemp;
import com.dcits.djk.manager.single.model.BhMonitorTestTempExample;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 服务监控
 * @author lips
 *
 */
@Controller
@RequestMapping("/monitor")
public class MonitorManagerController {
	private Logger logger = Logger.getLogger(MonitorManagerController.class);
	@Resource(name="monitorManagerService")
	private MonitorManagerService monitorManagerService;
	
	
	/**
	 * 跳转服务查询界面
	 * @author lips
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/serviceMonitor/toServiceMonitorList")
	public String ServiceMonitorList(HttpServletRequest request, Model model){
		String modularId = request.getParameter("modularId");
		model.addAttribute("modularId", modularId);
		return "monitor/ServiceMonitorList";

	}
	/**
	 * 跳转服务监控页面
	 * @author lips
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/serviceMonitorDetail/getServiceDetail")
	public String getServiceMonitorDetail(HttpServletRequest request, Model model){
		String modularId = request.getParameter("modularId");
		String urls = ServMonitorEnv.getRemoteServPath();
		String[] staticurlArr = urls.split(",");
		List<Map> monitorList = this.getMonitorList(staticurlArr);
		if(monitorList==null){
			monitorList = new ArrayList<Map>();
		}
		model.addAttribute("monitorList",monitorList);
		model.addAttribute("modularId", StringUtil.getNullStr(modularId));
		return "monitor/ServiceMonitorDetail";

	}
	/**
	 * 查询监控服务列表
	 * @author lips
	 * @param request
	 * @param serviceName
	 * @param rows
	 * @param page
	 * @return
	 */
	@RequestMapping(value ="/serviceMonitor/getserviceMonitorList",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getserviceMonitorList(HttpServletRequest request,String serviceName,int rows,int page){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		int allRows = monitorManagerService.getCountMonitorListByCaseOnPage(serviceName);
		List<BhMonitorTestTemp> monitorList = monitorManagerService.getMonitorListByCaseOnPage(serviceName, rows, page);
		if(monitorList == null ){
			monitorList = new ArrayList<BhMonitorTestTemp>();
		}
		returnMap.put("total", allRows);
		returnMap.put("rows", monitorList);
		JSONObject jo = JSONObject.fromObject(returnMap);
		return jo.toString();
	}
	/**
	 * 查询是否有重复的监控服务
	 * @author lips
	 * @param request
	 * @return
	 */
	@RequestMapping("/serviceMonitor/searchRepeatService")
	@ResponseBody
	public String searchRepeatService(HttpServletRequest request) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String serviceName = request.getParameter("serviceName");
		String serviceId = request.getParameter("serviceNodeId");
		BhMonitorTestTempExample example =new BhMonitorTestTempExample();
			example.createCriteria().andServiceNameEqualTo(serviceName).andServiceNodeIdNotEqualTo(serviceId);	
		int total = monitorManagerService.searchRepeatService(example);
		returnMap.put("total", total);
		JSONObject jo = JSONObject.fromObject(returnMap);
		return jo.toString();

	}
	/**
	 * 保存监控服务
	 * @author lips
	 * @param bhMonitorTestTemp
	 * @return
	 */
	@RequestMapping(value = "/serviceMonitor/saveService", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String saveMonitorService(String serviceNodeId,String serviceName,String serviceUrl){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		BhMonitorTestTemp bhMonitorTestTemp = new BhMonitorTestTemp();
		bhMonitorTestTemp.setServiceUrl(serviceUrl);
		bhMonitorTestTemp.setServiceName(serviceName);
		if (serviceNodeId==null || "".equals(serviceNodeId)) {//新增服务
			serviceNodeId=UuidUtil.get32Uuid();
			bhMonitorTestTemp.setServiceNodeId(serviceNodeId);
			try{
				String reString=monitorManagerService.saveService(bhMonitorTestTemp);
			   if ("success".equals(reString)) {
				   returnMap.put("msg", "true");
				// 增加服务缓存
				   
			   }else{
				   returnMap.put("msg", "false");
			   }	
				JSONObject jo = JSONObject.fromObject(returnMap);
				return jo.toString();
			}catch(Exception e){
				returnMap.put("errorMsg", "保存失败！");
				JSONObject jo = JSONObject.fromObject(returnMap);
				return jo.toString();
			}
			
		}else{//更新服务
			try {
				bhMonitorTestTemp.setServiceNodeId(serviceNodeId);
				String res=monitorManagerService.updateService(bhMonitorTestTemp);
				 if ("success".equals(res)) {
					   returnMap.put("msg", "true");
					// 修改服务缓存
					   
				   }else{
					   returnMap.put("msg", "false");
				   }	
				
				JSONObject jo = JSONObject.fromObject(returnMap);
				return jo.toString();
			} catch (Exception e) {
				logger.error(e,e);
				returnMap.put("errorMsg", "更新失败！");
				JSONObject jo = JSONObject.fromObject(returnMap);
				return jo.toString();
			}
		
			
			
		}
		
		
	}
	/**
	 * 编辑服务
	 * @author lips
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/serviceMonitor/editServiceMonitor", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String editService(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String serviceid = request.getParameter("serviceId");
		try {
			BhMonitorTestTemp bhMonitorTestTemp = monitorManagerService.getServiceById(serviceid);
			returnMap.put("success", "true");
			returnMap.put("data", bhMonitorTestTemp);
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		} catch (Exception e) {
			returnMap.put("errorMsg", "查询失败");
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		}

	}
	/**
	 * 删除监控服务
	 * @author lips
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/serviceMonitor/deleteServiceMonitor", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String deleteServiceMonitor(HttpServletRequest request) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String serviceId = request.getParameter("serviceId");
		try {
			 int code=  monitorManagerService.deleteServiceById(serviceId);
			
			 if (code>0) {
				 returnMap.put("code", "01");
				 returnMap.put("msg", "删除成功");
				//从缓存中删除
			}else{
				returnMap.put("code", "02");
				returnMap.put("msg", "删除失败");
			}
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		} catch (Exception e) {
			returnMap.put("errorMsg", "操作失败！");
			JSONObject jo = JSONObject.fromObject(returnMap);
			return jo.toString();
		}
	}
	
	public List<Map> getMonitorList(String[] staticurlArr){
		List<Map> monitorResultList = new ArrayList<Map>();
		for(int i = 0;i < staticurlArr.length;i++){
			Map authServiceMap = new HashMap();
			String staticurl = staticurlArr[i];
			authServiceMap.put("authServiceUrl",staticurl);
			String url = staticurl + "auth/getMonitorInfo.do";
			List<Map<String,String>> serviceMonitorList = new ArrayList<Map<String,String>>();
			String authResutStr = WebConnectionUtil.sendGetRequest(url);
			try{
				
				if(authResutStr.length() > 5){
					authServiceMap.put("authServiceStatus","1");
					JSONObject jo = JSONObject.fromObject(authResutStr);
					JSONArray ja = (JSONArray)jo.get("returnJson");
					
					for(int j = 0;j < ja.size();j++){
						JSONObject serviceMonitorJo = ja.getJSONObject(j);
						Map<String,String> serviceMonitorMap = new HashMap<String,String>();
						serviceMonitorMap.put("serviceReadDb",StringUtil.getNullObjToStr(serviceMonitorJo.get("serviceReadDb")));
						serviceMonitorMap.put("serviceWriteDb",StringUtil.getNullObjToStr(serviceMonitorJo.get("serviceWriteDb")));
						serviceMonitorMap.put("serviceNodeId",StringUtil.getNullObjToStr(serviceMonitorJo.get("serviceNodeId")));
						serviceMonitorMap.put("serviceOnOff",StringUtil.getNullObjToStr(serviceMonitorJo.get("serviceOnOff")));
						serviceMonitorMap.put("serviceCpuAvg",StringUtil.getNullObjToStr(serviceMonitorJo.get("serviceCpuAvg")));
						serviceMonitorMap.put("servioceMemAvg",StringUtil.getNullObjToStr(serviceMonitorJo.get("servioceMemAvg")));
						serviceMonitorMap.put("serviceName",StringUtil.getNullObjToStr(serviceMonitorJo.get("serviceName")));
						
						serviceMonitorList.add(serviceMonitorMap);
					}
				}else{
					authServiceMap.put("authServiceStatus","0");
				}
			}catch(Exception e){
				logger.error(e,e);
				authServiceMap.put("authServiceStatus","0");
			}
			authServiceMap.put("serviceMonitorList",serviceMonitorList);
			monitorResultList.add(authServiceMap);
		}
		return monitorResultList;
	}

}
