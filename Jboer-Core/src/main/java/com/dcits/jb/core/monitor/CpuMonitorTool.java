package com.dcits.jb.core.monitor;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class CpuMonitorTool {
	
	public static void collectCpuInfo(){
		Sigar sigar = null;
		try {
			sigar = new Sigar();
			CpuPerc[] cpuPercArry = sigar.getCpuPercList();
			double cpuUserTotal = 0;
			for(int i = 0;i < cpuPercArry.length;i++){
				CpuPerc cpuPerc = cpuPercArry[i];
				cpuUserTotal += cpuPerc.getCombined();
			}
			int cpuUserTotalInt = (int)(cpuUserTotal * 100 / cpuPercArry.length);
			MonitorDataContainer.setCpuUtilizationTotal(cpuUserTotalInt);
		} catch (SigarException e) {
			e.printStackTrace();
		}finally{
			try{
				sigar.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void collectCpuDescTotal(){
		Sigar sigar = null;
		try {
			sigar = new Sigar();
			CpuInfo[] cpuInfoArry = sigar.getCpuInfoList();
			StringBuffer strsb = new StringBuffer("CPU数量:");
			strsb.append(""+cpuInfoArry.length+";分别为:");
			
			for(int i = 0;i < cpuInfoArry.length;i++){
				CpuInfo CpuInfo = cpuInfoArry[i];
				if(i != 0){
					strsb.append(",");
				} 
				strsb.append(CpuInfo.getModel());
			}
			MonitorDataContainer.setCpuDesc(strsb.toString());
		} catch (SigarException e) {
			e.printStackTrace();
		}
	}
}
