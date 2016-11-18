package jungkosta.main.controller;

import java.util.StringTokenizer;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.LoginService;

@Controller
public class LoginController {

	@Inject
	private LoginService service;

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpServletRequest request) {

		String url = determine_url(request.getHeader("referer"));

		HttpSession session = request.getSession();

		session.removeAttribute("email");
		session.removeAttribute("name");
		session.removeAttribute("password");

		return "redirect:"+url;
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public String loginPost(HttpServletRequest request, MemberVO vo) throws Exception {
		
		MemberVO ret_vo = service.check_Login(vo);

		String url = null;

		HttpSession session = request.getSession();
		System.out.println(request.getHeader("referer"));
		url = determine_url(request.getHeader("referer"));

		if (ret_vo == null) {

		} else {
			session.setAttribute("email", ret_vo.getEmail());
			session.setAttribute("name", ret_vo.getName());
			session.setAttribute("password", ret_vo.getPassword());
		}
		
		System.out.println(url);
		
		return "redirect:"+url;
	}

	public String determine_url(String prev_URL) {

		StringTokenizer tok = new StringTokenizer(prev_URL, "/");
		String url = "";
		
		tok = new StringTokenizer(prev_URL, "/");

		for (int i = 0; i < 3; i++)
			tok.nextToken();
		if(!tok.hasMoreTokens()){
			url = "/";
		}
		while (tok.hasMoreTokens()) {
			url += "/" + tok.nextToken();
		}
		
		return url;
	}
}
