package com.dcits.djk.core.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.dcits.djk.core.util.RedisBaseUtil;


public class RedisThreadPool {
	private ScheduledExecutorService scheduledThreadPool;
	private int coreThreadCount = 5;
	private long redisFlustScheduled = 1800;
	
	private static RedisThreadPool rtp;
	
	private RedisThreadPool(){
		this.scheduledThreadPool = Executors.newScheduledThreadPool(coreThreadCount);
		this.scheduledThreadPool.scheduleAtFixedRate(new RedisFlustThread(),0,redisFlustScheduled,TimeUnit.SECONDS);
	}
	
	public static RedisThreadPool getInstance(){
		if(rtp == null){
			synchronized (RedisThreadPool.class) {
				if(rtp == null){
					rtp = new RedisThreadPool();
				}
			}
		}
		return rtp;
	}
	
	public class RedisFlustThread implements Runnable{
		public void run() {
			RedisBaseUtil.setMasterList();
		}

	}
	
}
