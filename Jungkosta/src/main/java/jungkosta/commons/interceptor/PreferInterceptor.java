package jungkosta.commons.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jungkosta.main.persistence.MainDao;

public class PreferInterceptor implements HandlerInterceptor {
	
	
	@Inject
	private MainDao dao;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {
		
		
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		HttpSession session = request.getSession();
		
		String email = (String)session.getAttribute("email");
		
		if(email != null){
			System.out.println("hi");
		}else{
			if(dao == null){
				System.out.println("h2");
			}
		}
		
		return true;
	}

}
