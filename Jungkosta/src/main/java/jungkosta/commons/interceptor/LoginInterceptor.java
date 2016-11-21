package jungkosta.commons.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String prev_Url = request.getHeader("referer");
		
		String url = Path.getInstance().determine_url(prev_Url);
		
		System.out.println(url);
		
		return true;
	}

}
