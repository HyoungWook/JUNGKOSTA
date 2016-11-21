package jungkosta.main.controller;

import java.util.StringTokenizer;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.commons.util.Path;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.LoginService;

@Controller
public class LoginController {

	@Inject
	private LoginService service;

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpServletRequest request) {
		
		Path path = Path.getInstance();
		
		String url = path.determine_url(request.getHeader("referer"));

		HttpSession session = request.getSession();

		session.removeAttribute("email");
		session.removeAttribute("name");
		session.removeAttribute("password");

		return "redirect:"+url;
	}
	
	//2016/11/19일 수정 우성 ajax로 수정함.
	@ResponseBody
	@RequestMapping(value = "/loginProc", method=RequestMethod.POST)
	public ResponseEntity<String> loginPost(HttpServletRequest request,@RequestParam("email") String email,
							@RequestParam("password") String password) throws Exception {
		
		MemberVO vo = new MemberVO();
		ResponseEntity<String> entity = null;
		vo.setEmail(email);
		vo.setPassword(password);
		
		String result = service.check_Login(request,vo);
		
		entity = new ResponseEntity<String>(result,HttpStatus.OK);
		
		return entity;
	}
	/////////////////////////////////////////////////////////////////////////
}
