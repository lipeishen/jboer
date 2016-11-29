package com.dcits.djk.manager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dcits.djk.core.monitor.MonitorDataContainer;
import com.dcits.djk.manager.service.MonitorService;

@Controller
@RequestMapping("/monitor")
public class MonitorController {
	
	@Resource(name = "monitorService")
	private MonitorService monitorService;
	
	@RequestMapping(value = "/getServiceStatus", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getServiceOnOffStatus(){
		
		return "{\"resultCode\":\"ok\"}";
	}
	
	@RequestMapping(value = "/getServiceDbReadStatus", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getServiceDbConnectStatus(String serviceNodeId){
		StringBuffer sb = new StringBuffer("{\"resultCode\":\"ok\"");
		String readDb = "fail";
		try{
			readDb = monitorService.getReadInfo(serviceNodeId);
		}catch(Exception e){
			e.printStackTrace();
		}
		sb.append(",\"read\":\""+readDb+"\"");
		String writeDb = "fail";
		try{
			writeDb = monitorService.updateWriteInfo(serviceNodeId);
		}catch(Exception e){
			e.printStackTrace();
		}
		sb.append(",\"write\":\""+writeDb+"\"");
		
		sb.append("}");
		return sb.toString();
	}
	
	@RequestMapping(value = "/getServiceSystemStatus", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getServiceSystemStatus(){
		int cpuAvg = MonitorDataContainer.getCpuUtilizationTotalAvg();
		int memAvg = MonitorDataContainer.getMemUtilizationTotalAvg();
		StringBuffer sb = new StringBuffer("{\"resultCode\":\"ok\"");
		sb.append(",\"cpuAvg\":\""+cpuAvg+"\"");
		sb.append(",\"memAvg\":\""+memAvg+"\"");
		sb.append("}");
		return sb.toString();
	}
}
