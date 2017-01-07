package com.dcits.jb.manager.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {
	private static Map mgrs = new HashMap();
    private Properties props = null;

    public static synchronized PropertyUtil getPropertyManager(String name) {
        Object item = mgrs.get(name);
        if (item == null)
            return new PropertyUtil(name);
        else
            return (PropertyUtil) item;
    }
    
    private PropertyUtil(String name) {
        props = new Properties();
        InputStream in = null;
        try {
        	in = getPropertiesStream(name);
            props.load(in);
        } catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
 			try {
 				if (in != null) {
 					in.close();
 				}
 			} catch (IOException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
        }
    }
    
	public String getProperty(String propName) {
        return props.getProperty(propName);
	}
    
    private InputStream getPropertiesStream(String name) {
        String filename = "/" + name + ".properties";
        InputStream in = getClass().getResourceAsStream(filename);
        return in;
    }

//    public static void main(String[] args) {
//    	//测试日志及读取配置文件
//    	System.out.println(PropertyUtil.getPropertyManager("redisConfig").getProperty("redisIp"));
//	}
}
