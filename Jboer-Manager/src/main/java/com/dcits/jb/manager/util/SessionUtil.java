package com.dcits.jb.manager.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.dcits.jb.manager.single.model.BhSysUserLoginInfo;

public final class SessionUtil {
	private static final Logger logger = Logger.getLogger(SessionUtil.class);
	
	private static final String SESSION_USER = "session_user";
	
	private static final String SESSION_MODULAR_LIST = "session_modular_list";
	
	private static final String SESSION_MODULAR_HEAD_LIST = "session_modular_head_list";
	
	public static BhSysUserLoginInfo getSessionUser(HttpServletRequest request){
		Object obj = request.getSession(true).getAttribute(SessionUtil.SESSION_USER);
		if(obj != null && obj instanceof BhSysUserLoginInfo){
			return (BhSysUserLoginInfo) obj;
		}else{
			return null;
		}
	}
	
	public static void setSessionUser(HttpServletRequest request,BhSysUserLoginInfo bhSysUserLoginInfo){
		request.getSession(true).setAttribute(SessionUtil.SESSION_USER, bhSysUserLoginInfo);
	}
	
	public static void removeSessionUser(HttpServletRequest request){
		request.getSession(true).removeAttribute(SessionUtil.SESSION_USER);
	}
	
	public static void setSessionModularList(HttpServletRequest request,List<Map<String,String>> modularList){
		request.getSession(true).setAttribute(SessionUtil.SESSION_MODULAR_LIST, modularList);
	}
	
	public static List<Map<String,String>> getSessionModularList(HttpServletRequest request){
		Object obj = request.getSession(true).getAttribute(SessionUtil.SESSION_MODULAR_LIST);
		if(obj != null && obj instanceof List){
			return (List<Map<String,String>>) obj;
		}else{
			return null;
		}
	}
	
	public static void removeSessionModularList(HttpServletRequest request){
		request.getSession(true).removeAttribute(SessionUtil.SESSION_MODULAR_LIST);
	}
	
	public static void setSessionModularHeadList(HttpServletRequest request,List<Map<String,String>> modularHeadList){
		request.getSession(true).setAttribute(SessionUtil.SESSION_MODULAR_HEAD_LIST, modularHeadList);
	}
	
	public static List<Map<String,String>> getSessionModularHeadList(HttpServletRequest request){
		Object obj = request.getSession(true).getAttribute(SessionUtil.SESSION_MODULAR_HEAD_LIST);
		if(obj != null && obj instanceof List){
			return (List<Map<String,String>>) obj;
		}else{
			return null;
		}
	}
	
	public static void removeSessionModularHeadList(HttpServletRequest request){
		request.getSession(true).removeAttribute(SessionUtil.SESSION_MODULAR_HEAD_LIST);
	}
	
	public static void removeAll(HttpServletRequest request){
		request.getSession(true).invalidate();
	}
}
