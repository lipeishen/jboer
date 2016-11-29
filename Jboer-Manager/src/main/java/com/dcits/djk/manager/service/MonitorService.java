package com.dcits.djk.manager.service;

import java.util.List;

import com.dcits.djk.manager.single.model.BhMonitorTestTemp;

public interface MonitorService {
	
	public String getReadInfo(String serviceNodeId);
	
	public String updateWriteInfo(String serviceNodeId);
	
	public List<BhMonitorTestTemp> getMonitorNodeList();
}
