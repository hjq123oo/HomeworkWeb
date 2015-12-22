package com.fiverings.homeworkweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		
		Object obj = request.getSession().getAttribute("id");
		if(obj == null){
			response.sendRedirect("/HomeworkWeb/");  
			return false;
		}else{
			return true;
		}
		
	}
}
