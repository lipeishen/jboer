package com.dcits.djk.manager.service;

import java.util.List;

import com.dcits.djk.manager.single.model.BhMonitorTestTemp;
import com.dcits.djk.manager.single.model.BhMonitorTestTempExample;

public interface MonitorManagerService {
	/**
	 * 查询监控服务的数量
	 * @author lips
	 * @param serviceName
	 * @return
	 */
	public int getCountMonitorListByCaseOnPage(String  serviceName);
	
	/**
	 * 查询监控的服务列表
	 * @author lips
	 * @param serviceName
	 * @param rows
	 * @param page
	 * @return
	 */
	public List<BhMonitorTestTemp> getMonitorListByCaseOnPage(String serviceName, int rows, int page);
	/**
	 * 查询监控服务是否重复
	 * @author lips
	 * @param example
	 * @return
	 */
	 public int searchRepeatService(BhMonitorTestTempExample example);
	 /**
	  * 保存监控服务
	  * @author lips
	  * @param bhMonitorTestTemp
	  * @return
	  */
	 public String  saveService(BhMonitorTestTemp bhMonitorTestTemp);
	 /**
	  * 修改监控服务
	  * @author lips
	  * @param bhMonitorTestTemp
	  * @return
	  */
	 public String updateService(BhMonitorTestTemp bhMonitorTestTemp);
	 /**
	  * 根据id查询监控服务
	  * @author lips
	  * @param serviceid
	  * @return
	  */
	 public BhMonitorTestTemp getServiceById(String serviceid);
	 /**
	  * 根据id删除监控服务
	  * @author lips
	  * @param serviceId
	  * @return
	  */
	 public int  deleteServiceById(String serviceId);

}
