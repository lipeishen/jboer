package com.dcits.jb.core.env;

import com.dcits.jb.core.util.PropertyUtil;

public class RedisConfigEnv {
	private static String redis_ip;
	private static String redis_port;
	private static String redis_password;
	private static Integer redis_max_connect;
	private static Integer redis_max_idle;
	private static Integer redis_timeout;
	private static Integer redis_soTimeout;
	private static Boolean redis_is_Test;
	private static Boolean redis_need_password;
	
	static{
		if(redis_ip == null || redis_ip.equals("")){
			RedisConfigEnv.redis_ip = PropertyUtil.getPropertyManager("redisConfig").getProperty("redisIp");
		}
		if(redis_port == null || redis_port.equals("")){
			RedisConfigEnv.redis_port = PropertyUtil.getPropertyManager("redisConfig").getProperty("redisPort");
		}
		if(redis_password == null || redis_password.equals("")){
			RedisConfigEnv.redis_password = PropertyUtil.getPropertyManager("redisConfig").getProperty("redisHideval");
		}
		if(redis_max_connect == null || redis_max_connect.equals("")){
			RedisConfigEnv.redis_max_connect = 1024;
			String redisMaxConnect = PropertyUtil.getPropertyManager("redisConfig").getProperty("redisMaxConnect");
			try{
				if(redisMaxConnect != null && !redisMaxConnect.equals("")){
					RedisConfigEnv.redis_max_connect = Integer.parseInt(redisMaxConnect);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(redis_max_idle == null || redis_max_idle.equals("")){
			RedisConfigEnv.redis_max_idle = 200;
			String redisMacIdle = PropertyUtil.getPropertyManager("redisConfig").getProperty("redisMacIdle");
			try{
				if(redisMacIdle != null && !redisMacIdle.equals("")){
					RedisConfigEnv.redis_max_idle = Integer.parseInt(redisMacIdle);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(redis_timeout == null || redis_timeout.equals("")){
			RedisConfigEnv.redis_timeout = 10000;
			String redisTimeout = PropertyUtil.getPropertyManager("redisConfig").getProperty("redisTimeout");
			try{
				if(redisTimeout != null && !redisTimeout.equals("")){
					RedisConfigEnv.redis_timeout = Integer.parseInt(redisTimeout);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(redis_soTimeout == null || redis_soTimeout.equals("")){
			RedisConfigEnv.redis_soTimeout = 10000;
			String redisSoTimeout = PropertyUtil.getPropertyManager("redisConfig").getProperty("redisSoTimeout");
			try{
				if(redisSoTimeout != null && !redisSoTimeout.equals("")){
					RedisConfigEnv.redis_soTimeout = Integer.parseInt(redisSoTimeout);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(redis_is_Test == null){
			RedisConfigEnv.redis_is_Test = true;
			String redisIsTest = PropertyUtil.getPropertyManager("redisConfig").getProperty("redisIsTest");
			if("true".equals(redisIsTest)){
				RedisConfigEnv.redis_is_Test = true;
			}else{
				RedisConfigEnv.redis_is_Test = false;
			}
			
		}
		if(redis_need_password == null){
			RedisConfigEnv.redis_need_password = true;
			String redisNeedPassword = PropertyUtil.getPropertyManager("redisConfig").getProperty("redisNeedHideval");
			if("true".equals(redisNeedPassword)){
				RedisConfigEnv.redis_need_password = true;
			}else{
				RedisConfigEnv.redis_need_password = false;
			}
			
		}
	}
	
	public static String getRedisIp(){
		return RedisConfigEnv.redis_ip;
	}
	public static String getRedisPort(){
		return RedisConfigEnv.redis_port;
	}
	public static String getRedisPassword(){
		return RedisConfigEnv.redis_password;
	}
	public static Integer getRedisMaxConnect(){
		return RedisConfigEnv.redis_max_connect;
	}
	public static Integer getRedisMacIdle(){
		return RedisConfigEnv.redis_max_idle;
	}
	public static Integer getRedisTimeout(){
		return RedisConfigEnv.redis_timeout;
	}
	public static Integer getRedisSoTimeout(){
		return RedisConfigEnv.redis_soTimeout;
	}
	public static Boolean getRedisIsTest(){
		return RedisConfigEnv.redis_is_Test;
	}
	public static Boolean getRedisNeedPassword(){
		return RedisConfigEnv.redis_need_password;
	}
}
