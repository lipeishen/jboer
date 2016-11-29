package com.dcits.djk.manager.init;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

import com.dcits.djk.core.thread.MonitorThreadPool;
import com.dcits.djk.core.thread.RedisThreadPool;

public class ThreadPoolInitListener implements InitializingBean {
	private Logger logger = Logger.getLogger(ThreadPoolInitListener.class);
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("开始初始化缓存集群信息");
		RedisThreadPool.getInstance();
		logger.debug("结束初始化缓存集群信息");
		
		logger.debug("开始初始化监控代理");
		MonitorThreadPool.getInstance();
		logger.debug("开始初始化监控代理");
	}

}
