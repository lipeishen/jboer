package com.dcits.djk.core.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.dcits.djk.core.monitor.CpuMonitorTool;
import com.dcits.djk.core.monitor.DiskMonitorTool;
import com.dcits.djk.core.monitor.MemMonitorTool;
import com.dcits.djk.core.monitor.NetMonitorTool;

public class MonitorThreadPool {
	private ScheduledExecutorService scheduledThreadPool;
	private int coreThreadCount = 20;
	private long cpuMonitorScheduled = 5*60;
	private long memMonitorScheduled = 5*60;
	private long diskMonitorScheduled = 60*60;
	private long netMonitorScheduled = 5*60;
	
	private static MonitorThreadPool mtp;
	
	private MonitorThreadPool(){
		this.scheduledThreadPool = Executors.newScheduledThreadPool(coreThreadCount);
		this.scheduledThreadPool.scheduleAtFixedRate(new CpuMonitorThread(),0,cpuMonitorScheduled,TimeUnit.SECONDS);
		this.scheduledThreadPool.scheduleAtFixedRate(new MemMonitorThread(),0,memMonitorScheduled,TimeUnit.SECONDS);
		this.scheduledThreadPool.scheduleAtFixedRate(new DiskMonitorThread(),0,diskMonitorScheduled,TimeUnit.SECONDS);
		this.scheduledThreadPool.scheduleAtFixedRate(new NetMonitorThread(),0,netMonitorScheduled,TimeUnit.SECONDS);
	}
	
	public static MonitorThreadPool getInstance(){
		if(mtp == null){
			synchronized (MonitorThreadPool.class) {
				if(mtp == null){
					mtp = new MonitorThreadPool();
				}
			}
		}
		return mtp;
	}
	
	public class CpuMonitorThread implements Runnable{
		public void run() {
			CpuMonitorTool.collectCpuInfo();
		}

	}
	
	public class NetMonitorThread implements Runnable{
		public void run() {
			NetMonitorTool.collectNetInfo();
		}

	}
	public class MemMonitorThread implements Runnable{
		public void run() {
			MemMonitorTool.collectMemInfo();
		}

	}
	public class DiskMonitorThread implements Runnable{
		public void run() {
			DiskMonitorTool.collectDiskData();
		}

	}
}	
