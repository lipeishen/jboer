package com.dcits.jb.core.monitor;

import java.util.HashMap;
import java.util.Map;

import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;

public class NetMonitorTool {
	
	public static void collectNetInfo(){
		Sigar sigar = null;
		Map<String,Long> rxPacketsMap = new HashMap<String,Long>();
		Map<String,Long> txPacketsMap = new HashMap<String,Long>();
		Map<String,Long> rxKBytesMap = new HashMap<String,Long>();
		Map<String,Long> txKBytesMap = new HashMap<String,Long>();
		Map<String,Long> rxErrorPacketsMap = new HashMap<String,Long>();
		Map<String,Long> txErrorPacketsMap = new HashMap<String,Long>();
		Map<String,Long> rxDroppedPacketsMap = new HashMap<String,Long>();
		Map<String,Long> txDroppedPacketsMap = new HashMap<String,Long>();
		try {
			sigar = new Sigar();
			String ifNames[] = sigar.getNetInterfaceList();
			if(ifNames != null && ifNames.length > 0){
				for (int i = 0; i < ifNames.length; i++) {
					String name = ifNames[i];
					try{
						NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
						Long rxPackets = ifstat.getRxPackets();
						//System.out.println(rxPackets);
						Long txPackets = ifstat.getTxPackets();
						//System.out.println(txPackets);
						Long rxKBytes = ifstat.getRxBytes() / 1024L;
						//System.out.println(rxKBytes);
						Long txKBytes = ifstat.getTxBytes() / 1024L;
						//System.out.println(txKBytes);
						Long rxErrorPackets = ifstat.getRxErrors();
						//System.out.println(rxErrorPackets);
						Long txErrorPackets = ifstat.getTxErrors();
						//System.out.println(txErrorPackets);
						Long rxDroppedPackets = ifstat.getRxDropped();
						//System.out.println(rxDroppedPackets);
						Long txDroppedPackets = ifstat.getTxDropped();
						//System.out.println(txDroppedPackets);
						rxPacketsMap.put(name,rxPackets);
						txPacketsMap.put(name,txPackets);
						rxKBytesMap.put(name,rxKBytes);
						txKBytesMap.put(name,txKBytes);
						rxErrorPacketsMap.put(name,rxErrorPackets);
						txErrorPacketsMap.put(name,txErrorPackets);
						rxDroppedPacketsMap.put(name,rxDroppedPackets);
						txDroppedPacketsMap.put(name,txDroppedPackets);
					}catch(Exception ex){
						
					}
				}
				MonitorDataContainer.setRxPackets(rxPacketsMap);
				MonitorDataContainer.setTxPackets(txPacketsMap);
				MonitorDataContainer.setRxKBytes(rxKBytesMap);
				MonitorDataContainer.setTxKBytes(txKBytesMap);
				MonitorDataContainer.setRxErrorPackets(rxErrorPacketsMap);
				MonitorDataContainer.setTxErrorPackets(txErrorPacketsMap);
				MonitorDataContainer.setRxDroppedPackets(rxDroppedPacketsMap);
				MonitorDataContainer.setTxDroppedPackets(txDroppedPacketsMap);
			}
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
	
	public static void collectNetDesc(){
		Sigar sigar = null;
		Map<String,String> netDescMap = new HashMap<String,String>();
		try{
			sigar = new Sigar();
			String ifNames[] = sigar.getNetInterfaceList();
			if(ifNames != null && ifNames.length > 0){
				for (int i = 0; i < ifNames.length; i++) {
					String name = ifNames[i];
					NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(name);
					StringBuffer sb = new StringBuffer();
					sb.append("name:"+cfg.getName()+",");
					sb.append("IP:"+cfg.getAddress()+",");
					sb.append("Broadcast:"+cfg.getBroadcast()+",");
					sb.append("MAC:"+cfg.getHwaddr()+",");
					sb.append("Netmask:"+cfg.getNetmask()+",");
					sb.append("Desc:"+cfg.getDescription()+".");
					//System.out.println(sb.toString());
					netDescMap.put(name, sb.toString());
				}
			}
			MonitorDataContainer.setNetDesc(netDescMap);
		}catch(Exception e){
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
