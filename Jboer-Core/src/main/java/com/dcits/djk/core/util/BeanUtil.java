package com.dcits.djk.core.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类工具类
 * @author caoxiaoa
 * 2016年3月25日
 */
public class BeanUtil {
	
	/**
	 * 实体类转成map
	 * @author caoxiaoa
	 * @param obj
	 * @return
	 */
	public static Map<String, String> transBean2Map(Object obj) { 
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        if(obj == null){  
            return null;  
        }          
        Map<String, String> map = new HashMap<String, String>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();
                Class<?> propertyType = property.getPropertyType();
                // 过滤class属性  
                if (!key.equals("class")) {
                	if("class java.util.Date".equals(propertyType.toString())){
                		  // 得到property对应的getter方法  
                        Method getter = property.getReadMethod();
                        String value = "";
                        if(getter.invoke(obj) != null){
                        	value = fmt.format(new Date(getter.invoke(obj).toString()));
                        }
                        map.put(key, value);  
                	}else{
                		 // 得到property对应的getter方法  
                        Method getter = property.getReadMethod();  
                        String value = getter.invoke(obj)==null?"":getter.invoke(obj).toString();  
                        map.put(key, value);  
                	}
                }  
            }  
        } catch (Exception e) {  
            System.out.println("transBean2Map Error " + e);  
        }  
        return map;  
    }
	
	/**
	 * map转实体类
	 * @author lips
	 * @param map
	 * @param obj
	 */
	 // Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean  
    public static void transMap2Bean(Map<String, Object> map, Object obj) {  
  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                if (map.containsKey(key)) {  
                    Object value = map.get(key);  
                    // 得到property对应的setter方法  
                    Method setter = property.getWriteMethod();  
                    setter.invoke(obj, value);  
                }  
  
            }  
  
        } catch (Exception e) {  
            System.out.println("transMap2Bean Error " + e);  
        }  
  
        return;  
  
    }  
	
	public static List<Object> Pagenation(List<Object> objList, int rows, int page){
		List<Object> oList = new ArrayList<Object>();
		if(objList != null && objList.size() > 0){
			if(objList.size() < rows){
				oList = objList;
			}else{
				if(rows * page < objList.size()){
					for(int i = (page-1)*rows;i < page*rows;i++){
						Object obj = objList.get(i);
						oList.add(obj);
					}
				}else{
					if(objList.size()%rows > 0){
						page = objList.size()/rows + 1;
					}else{
						page = objList.size()/rows;
					}
					for(int i = (page-1)*rows;i < objList.size();i++){
						Object obj = objList.get(i);
						oList.add(obj);
					}
				}
			}
		}
		return oList;
	}
	
	public static void main(String[] args) {
	}
}
