package com.dcits.jb.core.monitor;

import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;

public class OsMonitorTool {
	
	public static void collectHostName(){
		Sigar sigar = null;
		String hostName = "";
		try {
			sigar = new Sigar();
			hostName = sigar.getNetInfo().getHostName();
		} catch (Exception e) {
			e.printStackTrace();
			hostName = "localhost.unknown";
		}finally{
			try{
				sigar.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		MonitorDataContainer.setHostName(hostName);
	}
	
	public static void collectOsDesc(){
		String osDesc = "";
		try {
			OperatingSystem os = OperatingSystem.getInstance();
			StringBuffer sb = new StringBuffer("");
			sb.append("Arch:"+os.getArch()+",");
			sb.append("CpuEndian:"+os.getCpuEndian()+",");
			sb.append("DataModel:"+os.getDataModel()+",");
			sb.append("Description:"+os.getDescription()+",");
			sb.append("Machine:"+os.getMachine()+",");
			sb.append("Name:"+os.getName()+",");
			sb.append("PatchLevel:"+os.getPatchLevel()+",");
			sb.append("Vendor:"+os.getVendor()+",");
			sb.append("VendorCodeName:"+os.getVendorCodeName()+",");
			sb.append("VendorName:"+os.getVendorName()+",");
			sb.append("VendorVersion:"+os.getVendorVersion()+",");
			sb.append("Version:"+os.getVersion());
			osDesc = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			osDesc = "无操作系统信息";
		}
		MonitorDataContainer.setOsDesc(osDesc);
	}
	
	
}
