package jungkosta.main.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.FindService;

@Controller
public class FindController {
	
	@Inject
	private FindService service;
	
	@RequestMapping(value="/findEmailForm", method=RequestMethod.GET)
	public String findEmailGET(){
		return "findEmailForm";
	}
	
	@RequestMapping(value="/findEmailProc", method=RequestMethod.POST)
	public String findEmailPOST(HttpServletRequest request, Model model ,MemberVO vo)throws Exception{
		String resident_id = vo.getPassword();
		
		resident_id = resident_id.substring(0,6) +'-'+resident_id.substring(6,13);
		
		vo.setResident_id(resident_id);
		
		MemberVO retVo = service.findEmail(vo);
		
		if(retVo == null){
			model.addAttribute("member","");
		}else{
			model.addAttribute("member",retVo);
		}
		
		
		return "findEmailResult";
	}
	
	@RequestMapping(value="/findPasswordForm", method=RequestMethod.GET)
	public String findPasswordGET(){
		return "findPasswordForm";
	}
	
	@RequestMapping(value="/findPasswordProc",method=RequestMethod.POST)
	public String findPasswordPOST(Model model, MemberVO vo)throws Exception{
		
		MemberVO retVo = service.findPassword(vo);
		
		if(retVo == null){
			model.addAttribute("member","");
		}else{
			model.addAttribute("member",retVo);
		}
		
		return "findPasswordResult";
		
	}
	
}
