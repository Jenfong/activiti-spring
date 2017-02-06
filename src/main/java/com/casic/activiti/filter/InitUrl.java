package com.casic.activiti.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.casic.activiti.util.URLUtil;

public class InitUrl implements Filter {
	
	@Override
	public void destroy() {
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,FilterChain arg2) throws IOException, ServletException {
		String rootUrl = URLUtil.getBasePath((HttpServletRequest)arg0);
		arg0.setAttribute(URLUtil.ROOTURL, rootUrl);
		arg2.doFilter(arg0, arg1);
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
