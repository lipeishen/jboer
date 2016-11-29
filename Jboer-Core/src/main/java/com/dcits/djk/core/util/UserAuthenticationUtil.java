package com.dcits.djk.core.util;

import java.util.Map;

import com.dcits.djk.core.cache.ServMainInfoCache;
import com.dcits.djk.core.cache.ServMainUserCache;

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
