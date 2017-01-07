package com.dcits.jb.manager.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.jb.manager.service.MonitorManagerService;
import com.dcits.jb.manager.single.mapper.BhMonitorTestTempMapper;
import com.dcits.jb.manager.single.model.BhMonitorTestTemp;
import com.dcits.jb.manager.single.model.BhMonitorTestTempExample;
import com.dcits.jb.manager.union.mapper.MonitorServiceMapper;
@Service("monitorManagerService")
public class MonitorManagerServiceImpl implements MonitorManagerService {

	private Logger logger = Logger.getLogger(MonitorManagerServiceImpl.class);
	@Autowired
	private BhMonitorTestTempMapper bhMonitorTestTempMapper;
	@Autowired
	private MonitorServiceMapper monitorServiceMapper;
	@Override
	public int getCountMonitorListByCaseOnPage(String  serviceName){
		if(serviceName != null && !serviceName.equals("")){
			serviceName = "%"+serviceName+"%";
		}
		
		logger.debug("==============================================service countsql start");
		int allrows = monitorServiceMapper.getCountMonitorListByCaseOnPage(serviceName);
		logger.debug("==============================================service countsql end");
		
		return allrows;
	}
	
	public List<BhMonitorTestTemp> getMonitorListByCaseOnPage(String serviceName, int rows, int page){
		if(serviceName != null && !serviceName.equals("")){
			serviceName = "%"+serviceName+"%";
		}
		
		//rows 每页显示的记录数， page 当前页数 
				//1 0 (1-1)*rows
		page = (page-1)*rows;
		logger.debug("==============================================service sql start");
		List<BhMonitorTestTemp> monitorList=monitorServiceMapper.getMonitorListByCaseOnPage(serviceName,rows,page);
		logger.debug("==============================================service sql end");
		return monitorList;
	}
	
	@Override
	 public int searchRepeatService(BhMonitorTestTempExample example){
		   return bhMonitorTestTempMapper.countByExample(example);
	   }
	@Override
	public String  saveService(BhMonitorTestTemp bhMonitorTestTemp){
		int code =bhMonitorTestTempMapper.insertSelective(bhMonitorTestTemp);
		if (code>0) {
			return "success";
		}else{
			return "error";
		}
		
	}
	@Override
	public String updateService(BhMonitorTestTemp bhMonitorTestTemp){
		int code=bhMonitorTestTempMapper.updateByPrimaryKeySelective(bhMonitorTestTemp);
		if (code>0) {
			return "success";
		}else{
			return "error";
		}
		
		}
	@Override
	 public BhMonitorTestTemp getServiceById(String serviceid){
		 return bhMonitorTestTempMapper.selectByPrimaryKey(serviceid);
		 
	 }
	
	@Override
	 public int  deleteServiceById(String serviceId){
		return bhMonitorTestTempMapper.deleteByPrimaryKey(serviceId);
	}


}
