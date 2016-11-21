package jungkosta.main.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.SignupService;

@Controller
public class MainController {
	
	@Inject
	private SignupService service;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = {RequestMethod.GET,RequestMethod.POST})
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
	@RequestMapping(value="/mainSignupForm", method=RequestMethod.GET)
	public void go(){ }
	
	@RequestMapping(value="/mainSignupForm2", method=RequestMethod.GET)
	public void mainSignupForm2(){ }
	
	//회원가입 처리
	@RequestMapping(value="/mainSignupForm2", method=RequestMethod.POST)
	public String mainSignupProc(MemberVO vo, 
			@RequestParam("resident_id") String[] resi,
			@RequestParam("address") String[] adr,
			@RequestParam("interests") String[] inter,
			@RequestParam("password") String pass)throws Exception{
		
		vo.setResident_id(resi[0] + '-' + resi[1]);
		vo.setAddress(adr[0] + '/' + adr[1] + '/' + adr[2]);
		vo.setInterests_1(inter[0]);
		vo.setInterests_2(inter[1]);
		vo.setInterests_3(inter[2]);
		
		service.signupProc(vo, pass);

		return "redirect:/";

	}
	
}

