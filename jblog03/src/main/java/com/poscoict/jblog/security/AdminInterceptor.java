package com.poscoict.jblog.security;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.poscoict.jblog.service.BlogService;
import com.poscoict.jblog.service.UserService;
import com.poscoict.jblog.vo.BlogVo;
import com.poscoict.jblog.vo.UserVo;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private BlogService blogService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Map<String, String> pathVariables = (Map<String, String>) request.getAttribute
				(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		String id = pathVariables.get("id");
		
		HttpSession session = request.getSession(true);
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		BlogVo blogVo = blogService.findOne(id);
		
		if(authUser == null) {
			response.sendRedirect(request.getContextPath()+"/blog/"+blogVo.getUserId());
			return false;
			
		}
		
		if (!authUser.getId().equals(blogVo.getUserId())) {
			response.sendRedirect(request.getContextPath()+"/blog/"+blogVo.getUserId());
			return false;
		}
		return true;
	}

}
