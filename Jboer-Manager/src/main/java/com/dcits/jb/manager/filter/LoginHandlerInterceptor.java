package com.dcits.jb.manager.filter;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dcits.jb.core.util.StringUtil;
import com.dcits.jb.manager.single.model.BhSysUserLoginInfo;
import com.dcits.jb.manager.util.SessionUtil;

public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{
private List<String> excludeMappings;
	
	
    public void setExcludeMappings(List<String> excludeMappings) {
		this.excludeMappings = excludeMappings;
	}
    
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		String path = request.getServletPath();
		for (String s:excludeMappings) {
			if (path.contains(s)){
				return true;	
			}
		}
		BhSysUserLoginInfo bhSysUserLoginInfos = SessionUtil.getSessionUser(request);
		if(bhSysUserLoginInfos != null){
			if(path.contains("/user/") || path.contains("/common/")){
				return true;
			}
			List<Map<String,String>> modularList = SessionUtil.getSessionModularList(request);
			if(this.checkPathVaild(modularList, path)){
				return true;
			}else{
				response.sendRedirect(request.getContextPath() + "/user/filterNoAuthority.do");
				return false;
			}
		}else{
			response.sendRedirect(request.getContextPath() + "/user/filterMiddlePage.do");
			return false;
		}
	}
	
	private boolean checkPathVaild(List<Map<String,String>> modularList,String thisPath){
		for(int i = 0;i < modularList.size();i++){
			Map<String,String> modular = modularList.get(i);
			String modularUrl = StringUtil.getNullStr(modular.get("modularUrl"));
			String packageUrl = modularUrl.substring(0,modularUrl.lastIndexOf("/"));
			if(thisPath.contains(packageUrl)){
				return true;
			}
		}
		return false;
	}
	
//	public static void main(String[] arg){
//		String s = "/selftest/selfTestManage/toSelfTestCache.do";
//		System.out.println(s.substring(0,s.lastIndexOf("/")));
//	}
}
