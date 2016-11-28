package jungkosta.main.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.SignupService;

@Controller
public class UpdateInfoController {
	
	@Inject 
	SignupService service;
	
	//정보수정 페이지
	@RequestMapping(value="/memberInfoForm", method=RequestMethod.GET)
	public void memberInfoForm()throws Exception{
	}
	
	@RequestMapping(value="/memberInfoForm", method=RequestMethod.POST)
	public void memberInfoForm(Model model, HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		MemberVO member = service.selectMemberService(email);
		String[] address = member.getAddress().split("/");
		
		String address1 = address[0];
		String address2 = address[1];
		String address3 = address[2];
		
		model.addAttribute("address1",address1);
		model.addAttribute("address2",address2);
		model.addAttribute("address3",address3);
		
		model.addAttribute("member",member);
	}
	
	//정보수정 OK
	@RequestMapping(value="/memberUpdateProc", method=RequestMethod.POST)
	public String memberInfoProc(MemberVO vo,
			@RequestParam("address") String[] adr,
			@RequestParam("interests") String[] inter)throws Exception{
		
		vo.setAddress(adr[0] + '/' + adr[1] + '/' + adr[2]);
		vo.setInterests_1(inter[0]);
		vo.setInterests_2(inter[1]);
		vo.setInterests_3(inter[2]);
		
		System.out.println(vo.toString());
		
		service.updateMember(vo);
		return "redirect:/main";
	}
	
}
