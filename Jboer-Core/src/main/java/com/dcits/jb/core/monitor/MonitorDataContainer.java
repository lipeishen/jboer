package com.dcits.jb.core.monitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MonitorDataContainer {
	/**
	 * cpu利用率
	 */
	private static List<Integer> cpuUtilizationTotal = new Vector<Integer>();
	
	public static void setCpuUtilizationTotal(Integer currentValue){
		int dy = cpuUtilizationTotal.size() - 19;
		if(dy > 0){
			for(int i = 0;i < dy;i++){
				cpuUtilizationTotal.remove(0);
			}
		}
		cpuUtilizationTotal.add(currentValue);
	}
	
	public static int getCpuUtilizationTotalAvg(){
		int avgValue = 0;
		int count = 0;
		for(int i = 0;i < cpuUtilizationTotal.size();i++){
			Integer value = cpuUtilizationTotal.get(i);
			if(value != null && value > 0){
				avgValue += value;
				count++;
			}
		}
		if(count != 0){
			return (avgValue/count);
		}else{
			return 0;
		}
		
	}
	
	public static int getCpuUtilizationTotalNew(){
		return cpuUtilizationTotal.get(cpuUtilizationTotal.size()-1);
	}
	/**
	 * cpu描述信息
	 */
	private static String cpuDesc = "";

	public static String getCpuDesc() {
		return cpuDesc;
	}

	public static void setCpuDesc(String cpuDesc) {
		MonitorDataContainer.cpuDesc = cpuDesc;
	}
	
	/**
	 * 内存利用率
	 */
	private static List<Integer> memUtilizationTotal = new Vector<Integer>();
	
	public static void setMemUtilizationTotal(Integer currentValue){
		int dy = memUtilizationTotal.size() - 19;
		if(dy > 0){
			for(int i = 0;i < dy;i++){
				memUtilizationTotal.remove(0);
			}
		}
		memUtilizationTotal.add(currentValue);
	}
	
	public static int getMemUtilizationTotalAvg(){
		int avgValue = 0;
		int count = 0;
		for(int i = 0;i < memUtilizationTotal.size();i++){
			Integer value = memUtilizationTotal.get(i);
			if(value != null && value > 0){
				avgValue += value;
				count++;
			}
		}
		if(count != 0){
			return (avgValue/count);
		}else{
			return 0;
		}
	}
	
	public static int getMemUtilizationTotalNew(){
		return memUtilizationTotal.get(memUtilizationTotal.size()-1);
	}
	
	/**
	 * 交换区利用率
	 */
	private static List<Integer> swapUtilizationTotal = new Vector<Integer>();
	
	public static void setSwapUtilizationTotal(Integer currentValue){
		int dy = swapUtilizationTotal.size() - 19;
		if(dy > 0){
			for(int i = 0;i < dy;i++){
				swapUtilizationTotal.remove(0);
			}
		}
		swapUtilizationTotal.add(currentValue);
	}
	
	public static int getSwapUtilizationTotalAvg(){
		int avgValue = 0;
		int count = 0;
		for(int i = 0;i < swapUtilizationTotal.size();i++){
			Integer value = swapUtilizationTotal.get(i);
			if(value != null && value > 0){
				avgValue += value;
				count++;
			}
		}
		if(count != 0){
			return (avgValue/count);
		}else{
			return 0;
		}
	}
	
	public static int getSwapUtilizationTotalNew(){
		return swapUtilizationTotal.get(swapUtilizationTotal.size()-1);
	}
	
	/**
	 * 内存剩余量MB
	 */
	private static List<Integer> memFreeTotal = new Vector<Integer>();
	
	public static void setMemFreeTotal(Integer currentValue){
		int dy = memFreeTotal.size() - 19;
		if(dy > 0){
			for(int i = 0;i < dy;i++){
				memFreeTotal.remove(0);
			}
		}
		memFreeTotal.add(currentValue);
	}
	
	public static int getMemFreeTotalAvg(){
		int avgValue = 0;
		int count = 0;
		for(int i = 0;i < memFreeTotal.size();i++){
			Integer value = memFreeTotal.get(i);
			if(value != null && value > 0){
				avgValue += value;
				count++;
			}
		}
		if(count != 0){
			return (avgValue/count);
		}else{
			return 0;
		}
	}
	
	public static int getMemFreeTotalNew(){
		return memFreeTotal.get(memFreeTotal.size()-1);
	}
	
	/**
	 * 交换区剩余空间MB
	 */
	private static List<Integer> swapFreeTotal = new Vector<Integer>();
	
	public static void setSwapFreeTotal(Integer currentValue){
		int dy = swapFreeTotal.size() - 19;
		if(dy > 0){
			for(int i = 0;i < dy;i++){
				swapFreeTotal.remove(0);
			}
		}
		swapFreeTotal.add(currentValue);
	}
	
	public static int getSwapFreeTotalAvg(){
		int avgValue = 0;
		int count = 0;
		for(int i = 0;i < swapFreeTotal.size();i++){
			Integer value = swapFreeTotal.get(i);
			if(value != null && value > 0){
				avgValue += value;
				count++;
			}
		}
		if(count != 0){
			return (avgValue/count);
		}else{
			return 0;
		}
	}
	
	public static int getSwapFreeTotalNew(){
		return swapFreeTotal.get(swapFreeTotal.size()-1);
	}
	
	/**
	 * 内存描述信息
	 */
	private static String memDesc = "";

	public static String getMemDesc() {
		return memDesc;
	}

	public static void setMemDesc(String memDesc) {
		MonitorDataContainer.memDesc = memDesc;
	}
	
	/**
	 * 主机名
	 */
	private static String hostName = "";

	public static String getHostName() {
		return hostName;
	}

	public static void setHostName(String hostName) {
		MonitorDataContainer.hostName = hostName;
	}
	
	/**
	 * 操作系统信息
	 */
	private static String osDesc = "";

	public static String getOsDesc() {
		return osDesc;
	}

	public static void setOsDesc(String osDesc) {
		MonitorDataContainer.osDesc = osDesc;
	}
	
	/**
	 * 磁盘利用率
	 */
	private static Map<String,List<Integer>> diskUtilization = new HashMap<String,List<Integer>>();
	
	public static void setDiskUtilization(Map<String,Integer> currentValue){
		if(currentValue != null){
			for (Map.Entry<String,Integer> entry:currentValue.entrySet()){
				String key = entry.getKey();
				Integer value = entry.getValue();
				List<Integer> valueList = diskUtilization.get(key);
				if(valueList == null){
					valueList = new Vector<Integer>();
				}
				int dy = valueList.size() - 19;
				if(dy > 0){
					for(int i = 0;i < dy;i++){
						valueList.remove(0);
					}
				}
				valueList.add(value);
				diskUtilization.put(key, valueList);
			}
		}
	}
	
	public static Map<String,Integer> getDiskUtilizationAvg(){
		Map<String,Integer> valueMap = new HashMap<String,Integer>();
		for(Map.Entry<String,List<Integer>> entry:diskUtilization.entrySet()){
			String key = entry.getKey();
			List<Integer> valueList = entry.getValue();
			int avgValue = 0;
			int count = 0;
			for(int i = 0;i < valueList.size();i++){
				Integer value = valueList.get(i);
				if(value != null && value > 0){
					avgValue += value;
					count++;
				}
			}
			if(count != 0){
				valueMap.put(key,(avgValue/count));
			}else{
				valueMap.put(key,0);
			}
		}
		return valueMap;
	}
	
	public static Map<String,Integer> getDiskUtilizationNew(){
		Map<String,Integer> valueMap = new HashMap<String,Integer>();
		for(Map.Entry<String,List<Integer>> entry:diskUtilization.entrySet()){
			String key = entry.getKey();
			List<Integer> valueList = entry.getValue();
			if(valueList!= null && valueList.size() >0){
				Integer value = valueList.get(valueList.size()-1);
				valueMap.put(key, value);
			}
		}
		return valueMap;
	}
	
	/**
	 * 磁盘可用空间
	 */
	private static Map<String,List<Double>> diskAvail = new HashMap<String,List<Double>>();
	
	public static void setDiskAvail(Map<String,Double> currentValue){
		if(currentValue != null){
			for (Map.Entry<String,Double> entry:currentValue.entrySet()){
				String key = entry.getKey();
				Double value = entry.getValue();
				List<Double> valueList = diskAvail.get(key);
				if(valueList == null){
					valueList = new Vector<Double>();
				}
				int dy = valueList.size() - 19;
				if(dy > 0){
					for(int i = 0;i < dy;i++){
						valueList.remove(0);
					}
				}
				valueList.add(value);
				diskAvail.put(key,valueList);
			}
		}
	}
	
	public static Map<String,Double> getDiskAvailAvg(){
		Map<String,Double> valueMap = new HashMap<String,Double>();
		for(Map.Entry<String,List<Double>> entry:diskAvail.entrySet()){
			String key = entry.getKey();
			List<Double> valueList = entry.getValue();
			double avgValue = 0;
			double count = 0;
			for(int i = 0;i < valueList.size();i++){
				Double value = valueList.get(i);
				if(value != null && value > 0){
					avgValue += value;
					count++;
				}
			}
			if(count != 0){
				valueMap.put(key,(avgValue/count));
			}else{
				valueMap.put(key,0.0);
			}
		}
		return valueMap;
	}
	
	public static Map<String,Double> getDiskAvailNew(){
		Map<String,Double> valueMap = new HashMap<String,Double>();
		for(Map.Entry<String,List<Double>> entry:diskAvail.entrySet()){
			String key = entry.getKey();
			List<Double> valueList = entry.getValue();
			if(valueList!= null && valueList.size() >0){
				Double value = valueList.get(valueList.size()-1);
				valueMap.put(key,value);
			}
		}
		return valueMap;
	}
	
	/**
	 * 磁盘描述
	 */
	private static Map<String,String> diskDesc = new HashMap<String,String>();
	
	public static void setDiskDesc(Map<String,String> diskDesc){
		if(diskDesc != null){
			MonitorDataContainer.diskDesc = diskDesc;
		}
	}
	
	public static Map<String,String> getDiskDesc(){
		return MonitorDataContainer.diskDesc;
	}
	
	/**
	 * 接收总包裹数
	 */
	private static Map<String,List<Long>> rxPackets = new HashMap<String,List<Long>>();
	
	public static void setRxPackets(Map<String,Long> currentValue){
		if(currentValue != null){
			for (Map.Entry<String,Long> entry:currentValue.entrySet()){
				String key = entry.getKey();
				Long value = entry.getValue();
				List<Long> valueList = rxPackets.get(key);
				if(valueList == null){
					valueList = new Vector<Long>();
				}
				int dy = valueList.size() - 19;
				if(dy > 0){
					for(int i = 0;i < dy;i++){
						valueList.remove(0);
					}
				}
				valueList.add(value);
				rxPackets.put(key,valueList);
			}
		}
	}
	
	public static Map<String,Long> getRxPacketsAvg(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:rxPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			long avgValue = 0;
			long lastValue = 0;
			int count = 0;
			for(int i = 0;i < valueList.size();i++){
				long value = valueList.get(i);
				if(i == 0){
					lastValue = value;
				}else{
					avgValue += value - lastValue;
					lastValue = value;
					count++;
				}
			}
			if(count != 0){
				valueMap.put(key,(avgValue/count));
			}else{
				valueMap.put(key,0L);
			}
		}
		return valueMap;
	}
	
	public static Map<String,Long> getRxPacketsNew(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:rxPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			if(valueList!= null && valueList.size() >1){
				long newValue = valueList.get(valueList.size()-1);
				long lastValue = valueList.get(valueList.size()-2);
				Long value = newValue - lastValue;
				valueMap.put(key,value);
			}
		}
		return valueMap;
	}
	
	/**   
	 * 发送总包裹数
	 */
	private static Map<String,List<Long>> txPackets = new HashMap<String,List<Long>>();
	
	public static void setTxPackets(Map<String,Long> currentValue){
		if(currentValue != null){
			for (Map.Entry<String,Long> entry:currentValue.entrySet()){
				String key = entry.getKey();
				Long value = entry.getValue();
				List<Long> valueList = txPackets.get(key);
				if(valueList == null){
					valueList = new Vector<Long>();
				}
				int dy = valueList.size() - 19;
				if(dy > 0){
					for(int i = 0;i < dy;i++){
						valueList.remove(0);
					}
				}
				valueList.add(value);
				txPackets.put(key,valueList);
			}
		}
	}
	
	public static Map<String,Long> getTxPacketsAvg(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:txPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			long avgValue = 0;
			long lastValue = 0;
			int count = 0;
			for(int i = 0;i < valueList.size();i++){
				long value = valueList.get(i);
				if(i == 0){
					lastValue = value;
				}else{
					avgValue += value - lastValue;
					lastValue = value;
					count++;
				}
			}
			if(count != 0){
				valueMap.put(key,(avgValue/count));
			}else{
				valueMap.put(key,0L);
			}
		}
		return valueMap;
	}
	
	public static Map<String,Long> getTxPacketsNew(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:txPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			if(valueList!= null && valueList.size() >1){
				long newValue = valueList.get(valueList.size()-1);
				long lastValue = valueList.get(valueList.size()-2);
				Long value = newValue - lastValue;
				valueMap.put(key,value);
			}
		}
		return valueMap;
	}
	
	/**
	 * 接收总千字节数
	 */
	private static Map<String,List<Long>> rxKBytes = new HashMap<String,List<Long>>();
	
	public static void setRxKBytes(Map<String,Long> currentValue){
		if(currentValue != null){
			for (Map.Entry<String,Long> entry:currentValue.entrySet()){
				String key = entry.getKey();
				Long value = entry.getValue();
				List<Long> valueList = rxKBytes.get(key);
				if(valueList == null){
					valueList = new Vector<Long>();
				}
				int dy = valueList.size() - 19;
				if(dy > 0){
					for(int i = 0;i < dy;i++){
						valueList.remove(0);
					}
				}
				valueList.add(value);
				rxKBytes.put(key,valueList);
			}
		}
	}
	
	public static Map<String,Long> getRxKBytesAvg(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:rxKBytes.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			long avgValue = 0;
			long lastValue = 0;
			int count = 0;
			for(int i = 0;i < valueList.size();i++){
				long value = valueList.get(i);
				if(i == 0){
					lastValue = value;
				}else{
					avgValue += value - lastValue;
					lastValue = value;
					count++;
				}
			}
			if(count != 0){
				valueMap.put(key,(avgValue/count));
			}else{
				valueMap.put(key,0L);
			}
		}
		return valueMap;
	}
	
	public static Map<String,Long> getRxKBytesNew(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:rxKBytes.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			if(valueList!= null && valueList.size() >1){
				long newValue = valueList.get(valueList.size()-1);
				long lastValue = valueList.get(valueList.size()-2);
				Long value = newValue - lastValue;
				valueMap.put(key,value);
			}
		}
		return valueMap;
	}
	
	/**   
	 * 发送总千字节数
	 */
	private static Map<String,List<Long>> txKBytes = new HashMap<String,List<Long>>();
	
	public static void setTxKBytes(Map<String,Long> currentValue){
		if(currentValue != null){
			for (Map.Entry<String,Long> entry:currentValue.entrySet()){
				String key = entry.getKey();
				Long value = entry.getValue();
				List<Long> valueList = txKBytes.get(key);
				if(valueList == null){
					valueList = new Vector<Long>();
				}
				int dy = valueList.size() - 19;
				if(dy > 0){
					for(int i = 0;i < dy;i++){
						valueList.remove(0);
					}
				}
				valueList.add(value);
				txKBytes.put(key,valueList);
			}
		}
	}
	
	public static Map<String,Long> getTxKBytesAvg(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:txKBytes.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			long avgValue = 0;
			long lastValue = 0;
			int count = 0;
			for(int i = 0;i < valueList.size();i++){
				long value = valueList.get(i);
				if(i == 0){
					lastValue = value;
				}else{
					avgValue += value - lastValue;
					lastValue = value;
					count++;
				}
			}
			if(count != 0){
				valueMap.put(key,(avgValue/count));
			}else{
				valueMap.put(key,0L);
			}
		}
		return valueMap;
	}
	
	public static Map<String,Long> getTxKBytesNew(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:txKBytes.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			if(valueList!= null && valueList.size() >1){
				long newValue = valueList.get(valueList.size()-1);
				long lastValue = valueList.get(valueList.size()-2);
				Long value = newValue - lastValue;
				valueMap.put(key,value);
			}
		}
		return valueMap;
	}
	
	/**
	 * 接收错误包裹数
	 */
	private static Map<String,List<Long>> rxErrorPackets = new HashMap<String,List<Long>>();
	
	public static void setRxErrorPackets(Map<String,Long> currentValue){
		if(currentValue != null){
			for (Map.Entry<String,Long> entry:currentValue.entrySet()){
				String key = entry.getKey();
				Long value = entry.getValue();
				List<Long> valueList = rxErrorPackets.get(key);
				if(valueList == null){
					valueList = new Vector<Long>();
				}
				int dy = valueList.size() - 19;
				if(dy > 0){
					for(int i = 0;i < dy;i++){
						valueList.remove(0);
					}
				}
				valueList.add(value);
				rxErrorPackets.put(key,valueList);
			}
		}
	}
	
	public static Map<String,Long> getRxErrorPacketsAvg(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:rxErrorPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			long avgValue = 0;
			long lastValue = 0;
			int count = 0;
			for(int i = 0;i < valueList.size();i++){
				long value = valueList.get(i);
				if(i == 0){
					lastValue = value;
				}else{
					avgValue += value - lastValue;
					lastValue = value;
					count++;
				}
			}
			if(count != 0){
				valueMap.put(key,(avgValue/count));
			}else{
				valueMap.put(key,0L);
			}
		}
		return valueMap;
	}
	
	public static Map<String,Long> getRxErrorPacketsNew(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:rxErrorPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			if(valueList!= null && valueList.size() >1){
				long newValue = valueList.get(valueList.size()-1);
				long lastValue = valueList.get(valueList.size()-2);
				Long value = newValue - lastValue;
				valueMap.put(key,value);
			}
		}
		return valueMap;
	}
	
	/**   
	 * 发送错误包裹数
	 */
	private static Map<String,List<Long>> txErrorPackets = new HashMap<String,List<Long>>();
	
	public static void setTxErrorPackets(Map<String,Long> currentValue){
		if(currentValue != null){
			for (Map.Entry<String,Long> entry:currentValue.entrySet()){
				String key = entry.getKey();
				Long value = entry.getValue();
				List<Long> valueList = txErrorPackets.get(key);
				if(valueList == null){
					valueList = new Vector<Long>();
				}
				int dy = valueList.size() - 19;
				if(dy > 0){
					for(int i = 0;i < dy;i++){
						valueList.remove(0);
					}
				}
				valueList.add(value);
				txErrorPackets.put(key,valueList);
			}
		}
	}
	
	public static Map<String,Long> getTxErrorPacketsAvg(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:txErrorPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			long avgValue = 0;
			long lastValue = 0;
			int count = 0;
			for(int i = 0;i < valueList.size();i++){
				long value = valueList.get(i);
				if(i == 0){
					lastValue = value;
				}else{
					avgValue += value - lastValue;
					lastValue = value;
					count++;
				}
			}
			if(count != 0){
				valueMap.put(key,(avgValue/count));
			}else{
				valueMap.put(key,0L);
			}
		}
		return valueMap;
	}
	
	public static Map<String,Long> getTxErrorPacketsNew(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:txErrorPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			if(valueList!= null && valueList.size() >1){
				long newValue = valueList.get(valueList.size()-1);
				long lastValue = valueList.get(valueList.size()-2);
				Long value = newValue - lastValue;
				valueMap.put(key,value);
			}
		}
		return valueMap;
	}
	
	/**
	 * 接收丢弃包裹数
	 */
	private static Map<String,List<Long>> rxDroppedPackets = new HashMap<String,List<Long>>();
	
	public static void setRxDroppedPackets(Map<String,Long> currentValue){
		if(currentValue != null){
			for (Map.Entry<String,Long> entry:currentValue.entrySet()){
				String key = entry.getKey();
				Long value = entry.getValue();
				List<Long> valueList = rxDroppedPackets.get(key);
				if(valueList == null){
					valueList = new Vector<Long>();
				}
				int dy = valueList.size() - 19;
				if(dy > 0){
					for(int i = 0;i < dy;i++){
						valueList.remove(0);
					}
				}
				valueList.add(value);
				rxDroppedPackets.put(key,valueList);
			}
		}
	}
	
	public static Map<String,Long> getRxDroppedPacketsAvg(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:rxDroppedPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			long avgValue = 0;
			long lastValue = 0;
			int count = 0;
			for(int i = 0;i < valueList.size();i++){
				long value = valueList.get(i);
				if(i == 0){
					lastValue = value;
				}else{
					avgValue += value - lastValue;
					lastValue = value;
					count++;
				}
			}
			if(count != 0){
				valueMap.put(key,(avgValue/count));
			}else{
				valueMap.put(key,0L);
			}
		}
		return valueMap;
	}
	
	public static Map<String,Long> getRxDroppedPacketsNew(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:rxDroppedPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			if(valueList!= null && valueList.size() >1){
				long newValue = valueList.get(valueList.size()-1);
				long lastValue = valueList.get(valueList.size()-2);
				Long value = newValue - lastValue;
				valueMap.put(key,value);
			}
		}
		return valueMap;
	}
	
	/**   
	 * 发送丢弃包裹数
	 */
	private static Map<String,List<Long>> txDroppedPackets = new HashMap<String,List<Long>>();
	
	public static void setTxDroppedPackets(Map<String,Long> currentValue){
		if(currentValue != null){
			for (Map.Entry<String,Long> entry:currentValue.entrySet()){
				String key = entry.getKey();
				Long value = entry.getValue();
				List<Long> valueList = txDroppedPackets.get(key);
				if(valueList == null){
					valueList = new Vector<Long>();
				}
				int dy = valueList.size() - 19;
				if(dy > 0){
					for(int i = 0;i < dy;i++){
						valueList.remove(0);
					}
				}
				valueList.add(value);
				txDroppedPackets.put(key,valueList);
			}
		}
	}
	
	public static Map<String,Long> getTxDroppedPacketsAvg(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:txDroppedPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			long avgValue = 0;
			long lastValue = 0;
			int count = 0;
			for(int i = 0;i < valueList.size();i++){
				long value = valueList.get(i);
				if(i == 0){
					lastValue = value;
				}else{
					avgValue += value - lastValue;
					lastValue = value;
					count++;
				}
			}
			if(count != 0){
				valueMap.put(key,(avgValue/count));
			}else{
				valueMap.put(key,0L);
			}
		}
		return valueMap;
	}
	
	public static Map<String,Long> getTxDroppedPacketsNew(){
		Map<String,Long> valueMap = new HashMap<String,Long>();
		for(Map.Entry<String,List<Long>> entry:txDroppedPackets.entrySet()){
			String key = entry.getKey();
			List<Long> valueList = entry.getValue();
			if(valueList!= null && valueList.size() >1){
				long newValue = valueList.get(valueList.size()-1);
				long lastValue = valueList.get(valueList.size()-2);
				Long value = newValue - lastValue;
				valueMap.put(key,value);
			}
		}
		return valueMap;
	}
	
	/**
	 * 网卡描述
	 */
	private static Map<String,String> netDesc = new HashMap<String,String>();
	
	public static void setNetDesc(Map<String,String> netDesc){
		if(netDesc != null){
			MonitorDataContainer.netDesc = netDesc;
		}
	}
	
	public static Map<String,String> getNetDesc(){
		return MonitorDataContainer.netDesc;
	}
} 
