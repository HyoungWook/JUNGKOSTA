package jungkosta.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ManagerInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		String email = (String)session.getAttribute("email");
		
		if(email == null){
			
			response.sendRedirect("/Jungkosta/");
			
			return false;
			
		}else if(!email.equals("admin@admin.com")){
			
			response.sendRedirect("/Jungkosta/");
			
			return false;
			
		}
		
		return true;
	}
	
}
