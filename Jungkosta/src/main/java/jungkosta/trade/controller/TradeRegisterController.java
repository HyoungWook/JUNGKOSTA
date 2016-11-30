package jungkosta.trade.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.SignupService;
import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.TradeService;


@Controller
public class TradeRegisterController {

	@Inject
	private TradeService service;
	 
	@Inject
	private SignupService memberService;
	//물품 등록_tw
	@RequestMapping(value= "/tradeRegisterForm", method= RequestMethod.GET)
	public void registerGet(HttpServletRequest request, SaleVO salevo, Model model) throws Exception {
		System.out.println("Insert Form");
		
		HttpSession session = request.getSession();
		
		String email = (String)session.getAttribute("email");
		try {
			MemberVO member = memberService.selectMemberService(email);
			model.addAttribute("member", member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value= "/tradeRegisterForm", method= RequestMethod.POST)
	public String registPost(SaleVO saleVO, HttpServletRequest request) throws Exception{
		System.out.println(saleVO);
		int subca_id = saleVO.getSubca_id();
		service.regist(saleVO);
		
		return "redirect:/trade/tradeList?subca_id=" + subca_id;

	}
	
}
