package com.dcits.jb.manager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.dcits.jb.core.util.StringUtil;



public class CharacterCheckFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //过滤特殊字符
        request = new Request(request);
		
        filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
	
	class Request extends HttpServletRequestWrapper {

		public Request(HttpServletRequest request) {
			super(request);
		}
		
		public String getParameter(String name) {
			return StringUtil.filterSpecialChar(super.getRequest().getParameter(name));
		}
		
		public String[] getParameterValues(String name) {
			String[] values = super.getRequest().getParameterValues(name);
			if(values == null){
				return null;
			}
			// 通过循环进行过滤
			for (int i = 0; i < values.length; i++) {
				values[i] = StringUtil.filterSpecialChar(values[i]);
			}
			return values;
		}
	}
}
