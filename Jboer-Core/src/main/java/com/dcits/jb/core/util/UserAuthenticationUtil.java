package com.dcits.jb.core.util;

import java.util.Map;

import com.dcits.jb.core.cache.ServMainInfoCache;
import com.dcits.jb.core.cache.ServMainUserCache;

public class UserAuthenticationUtil {
	
	public static boolean userAuthentication(String serviceId,String userId){
		Map<String,String> servMap = ServMainInfoCache.getServMainInfoByServiceId(serviceId);
		if(servMap == null){
			return false;
		}
		String serviceType = StringUtil.getNullStr(servMap.get("serviceType"));
		if("1".equals(serviceType)){
			return true;
		}
		servMap = ServMainUserCache.getUserServMainByUserIdAndServId(userId, serviceId);
		if(servMap == null){
			return false;
		}
		return true;
	}
}
