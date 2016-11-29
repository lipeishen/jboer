package com.dcits.djk.core.env;

import com.dcits.djk.core.util.PropertyUtil;

public class SftpConfigEnv {
	private static String sftpIp;
	private static Integer sftpPort;
	private static String sftpUserName;
	private static String sftpHideval;
	
	static{
		if(sftpIp == null || sftpIp.equals("")){
			sftpIp = "127.0.0.1";
			try{
				SftpConfigEnv.sftpIp = PropertyUtil.getPropertyManager("sftpConfig").getProperty("sftpIp");
			}catch(Exception e){
			}
		}
		if(sftpPort == null || sftpPort.equals("")){
			sftpPort = 22;
			String sftpConfigStr = PropertyUtil.getPropertyManager("sftpConfig").getProperty("sftpPort");
			try{
				if(sftpConfigStr != null && !sftpConfigStr.equals("")){
					SftpConfigEnv.sftpPort = Integer.parseInt(sftpConfigStr);
				}
			}catch(Exception e){
			}
		}
		if(sftpUserName == null || sftpUserName.equals("")){
			sftpUserName = "root";
			try{
				SftpConfigEnv.sftpUserName = PropertyUtil.getPropertyManager("sftpConfig").getProperty("sftpUserName");
			}catch(Exception e){
			}
		}
		if(sftpHideval == null || sftpHideval.equals("")){
			sftpHideval = "123456";
			try{
				SftpConfigEnv.sftpHideval = PropertyUtil.getPropertyManager("sftpConfig").getProperty("sftpHideval");
			}catch(Exception e){
			}
		}
	}
	
	public static String getSftpIp(){
		return SftpConfigEnv.sftpIp;
	}
	public static Integer getSftpPort(){
		return SftpConfigEnv.sftpPort;
	}
	public static String getSftpUserName(){
		return SftpConfigEnv.sftpUserName;
	}
	public static String getSftpHideval(){
		return SftpConfigEnv.sftpHideval;
	}
	
}
