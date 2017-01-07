package com.dcits.jb.manager.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.jb.manager.service.MonitorService;
import com.dcits.jb.manager.single.mapper.BhMonitorTestTempMapper;
import com.dcits.jb.manager.single.model.BhMonitorTestTemp;
import com.dcits.jb.manager.single.model.BhMonitorTestTempExample;

@Service("monitorService")
public class MonitorServiceImpl implements MonitorService{
	
	@Autowired
	BhMonitorTestTempMapper bhMonitorTestTempMapper;
	
	@Override
	public String getReadInfo(String serviceNodeId) {
		BhMonitorTestTemp bhMonitorTestTemp = bhMonitorTestTempMapper.selectByPrimaryKey(serviceNodeId);
		if(bhMonitorTestTemp != null && bhMonitorTestTemp.getServiceNodeId() != null && !bhMonitorTestTemp.getServiceNodeId().equals("")){
			return "ok";
		}else{
			return "fail";
		}
	}

	@Override
	public String updateWriteInfo(String serviceNodeId) {
		BhMonitorTestTemp bhMonitorTestTemp = new BhMonitorTestTemp();
		bhMonitorTestTemp.setServiceNodeId(serviceNodeId);
		bhMonitorTestTemp.setUpdateTime(new Date());
		bhMonitorTestTempMapper.updateByPrimaryKeySelective(bhMonitorTestTemp);
		return "ok";
	}

	@Override
	public List<BhMonitorTestTemp> getMonitorNodeList() {
		BhMonitorTestTempExample example = new BhMonitorTestTempExample();
		example.setOrderByClause("service_name");
		List<BhMonitorTestTemp> bmttList = bhMonitorTestTempMapper.selectByExample(example);
		return bmttList;
	}

}
