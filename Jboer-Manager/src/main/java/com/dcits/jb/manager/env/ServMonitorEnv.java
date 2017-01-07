package com.dcits.jb.manager.env;

import com.dcits.jb.core.util.PropertyUtil;

/**
 * 获取监控服务的路径
 * @author lips
 *
 */
public class ServMonitorEnv {
	
	private static String RemoteServPath; //获取服务状态的远程路径
	
	static{
		if (RemoteServPath==null||"".equals(RemoteServPath)) {
			ServMonitorEnv.RemoteServPath=PropertyUtil.getPropertyManager("ServMonitorUrl").getProperty("url");
		}
	}
	/**
	 * 获取监控服务路径url
	 * @author lips
	 * @return
	 */
	public static String getRemoteServPath() {
		return ServMonitorEnv.RemoteServPath;
	}
	

}
