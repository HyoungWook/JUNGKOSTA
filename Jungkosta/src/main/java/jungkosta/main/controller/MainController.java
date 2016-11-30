package jungkosta.main.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.MainService;
import jungkosta.main.service.SignupService;
import jungkosta.trade.domain.SaleVO;

@Controller
public class MainController {
	
	@Inject
	private SignupService service;
	
	@Inject
	private MainService mainService;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = {RequestMethod.GET,RequestMethod.POST})
	public String home(Locale locale, Model model) {
		
		return "main";
	}
	
	//2016/11/25 우성 수정
	
	@ResponseBody
	@RequestMapping(value="/newItem",method=RequestMethod.GET)
	public ResponseEntity<String> newItem(){
		
		ResponseEntity<String> entity = null;
		
		String json = mainService.newItem();
				
		entity = new ResponseEntity<String>(json,HttpStatus.OK);
		
		return entity;
		
	}
	
	@RequestMapping(value="/mainSignupForm", method=RequestMethod.GET)
	public void go(){}
	
	@RequestMapping(value="/mainSignupForm2", method=RequestMethod.GET)
	public String mainSignupForm2(){ 
		
		return "/mainSignupForm2";
		
	}
	
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
	
	@RequestMapping(value="aucList", method=RequestMethod.GET)
	public void aucList(){
		
	}
	
	@RequestMapping(value="saleList", method=RequestMethod.GET)
	public void saleList(){
		
	}
	
	@RequestMapping(value="purchaseList", method=RequestMethod.GET)
	public void purchaseList(){
		
	}
}

