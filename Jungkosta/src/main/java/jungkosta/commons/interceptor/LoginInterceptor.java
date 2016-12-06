package jungkosta.commons.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jungkosta.commons.util.Path;
import jungkosta.main.service.LoginService;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Inject
	private LoginService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email") == null){
			
			response.sendRedirect("/Jungkosta/");
			return false;
		}
		
		
		return true;
	}

}
