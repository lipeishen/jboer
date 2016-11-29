package com.dcits.djk.manager.union.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dcits.djk.manager.single.model.BhMonitorTestTemp;

public interface MonitorServiceMapper {
	
	int getCountMonitorListByCaseOnPage(@Param("serviceName")String serviceName);
	List<BhMonitorTestTemp> getMonitorListByCaseOnPage(@Param("serviceName")String serviceName, @Param("rows")int rows, @Param("page")int page);

}
