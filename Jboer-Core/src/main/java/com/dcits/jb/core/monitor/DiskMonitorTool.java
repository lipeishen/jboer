package com.dcits.jb.core.monitor;

import java.util.HashMap;
import java.util.Map;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;

public class DiskMonitorTool {
	
	public static void collectDiskData(){
		Sigar sigar = null;
		Map<String,Integer> DiskUtilizationMap = new HashMap<String,Integer>();
		Map<String,Double> DiskAvilMap = new HashMap<String,Double>();
		try {
			sigar = new Sigar();
			FileSystem fslist[] = sigar.getFileSystemList();  
			if(fslist != null && fslist.length > 0){
				for (int i = 0; i < fslist.length; i++){  
					FileSystem fs = fslist[i];
					if(fs.getType() == 2){
						FileSystemUsage usage = sigar.getFileSystemUsage(fs.getDirName());
						Integer usePercent = (int)(usage.getUsePercent() * 100D);
						Double diskAvail = usage.getAvail() / 1024D /1024D;
						DiskUtilizationMap.put(fs.getDirName(), usePercent);
						DiskAvilMap.put(fs.getDirName(),diskAvail);
					}
				}
			}
			MonitorDataContainer.setDiskUtilization(DiskUtilizationMap);
			MonitorDataContainer.setDiskAvail(DiskAvilMap);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				sigar.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	public static void collectDiskDesc(){
		Sigar sigar = null;
		Map<String,String> DiskDescMap = new HashMap<String,String>();
		try {
			sigar = new Sigar();
			FileSystem fslist[] = sigar.getFileSystemList();  
			if(fslist != null && fslist.length > 0){
				for (int i = 0; i < fslist.length; i++){  
					FileSystem fs = fslist[i];
					StringBuffer sb = new StringBuffer();
					sb.append("分区名称:"+fs.getDevName() +",");
					sb.append("分区路径:"+fs.getDirName() +",");
					sb.append("文件系统类型:"+fs.getSysTypeName() +",");
					sb.append("文件系统分类:"+fs.getTypeName() +",");
					if(fs.getType() == 2){
						FileSystemUsage usage = sigar.getFileSystemUsage(fs.getDirName());
						Double diskTotal = usage.getTotal() / 1024D /1024D;
						sb.append("总大小:"+diskTotal+"GB");
					}
					DiskDescMap.put(fs.getDirName(),sb.toString());
				}
			}
			MonitorDataContainer.setDiskDesc(DiskDescMap);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				sigar.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
