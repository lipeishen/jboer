package com.dcits.djk.core.monitor;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

public class MemMonitorTool {
	
	public static void collectMemInfo(){
		Sigar sigar = null;
		try{
			sigar = new Sigar();
			Mem mem = sigar.getMem();
			
			long totalMem = mem.getTotal();
			long UseMem = mem.getUsed();
			
			double memUtilizationD = UseMem * 100 / totalMem;
			MonitorDataContainer.setMemUtilizationTotal((int)memUtilizationD);
			long freeMem = mem.getFree();
			int freeMemInt = (int)(freeMem /1024L /1024);
			MonitorDataContainer.setMemFreeTotal(freeMemInt);
			
			Swap swap = sigar.getSwap();
			long totalSwap = swap.getTotal();
			long UseSwap = swap.getUsed();
			
			double swapUtilizationD = UseSwap * 100 / totalSwap;
			MonitorDataContainer.setSwapUtilizationTotal((int)swapUtilizationD);
			long freeSwap = swap.getFree();
			int freeSwapInt = (int)(freeSwap/1024L /1024);
			MonitorDataContainer.setSwapFreeTotal(freeSwapInt);
		}catch (SigarException e) {
			e.printStackTrace();
		}finally{
			try{
				sigar.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void collectMemDescTotal(){
		Sigar sigar = null;
		try {
			sigar = new Sigar();
			Mem mem = sigar.getMem();
			long totalMem = mem.getTotal();
			totalMem = totalMem /1024L /1024;
			String memDesc =  "内存总量为:" + totalMem + "MB";
			MonitorDataContainer.setCpuDesc(memDesc);
		} catch (SigarException e) {
			e.printStackTrace();
		}
	}
	
}
