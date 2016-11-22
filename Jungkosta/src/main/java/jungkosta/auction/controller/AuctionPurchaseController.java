package jungkosta.auction.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.auction.domain.BidVO;
import jungkosta.auction.service.AucPurService;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.SignupService;

@Controller
public class AuctionPurchaseController {

	@Inject
	private SignupService memberService;
	
	@Inject
	private AucPurService purchaseService;

	@RequestMapping(value = "/auctionPurchaseForm", method = RequestMethod.GET)
	public void paymentRegisterForm_get(HttpServletRequest request, Model model) throws Exception {

		// start 현우 추가 부분
		String email = (String) request.getSession().getAttribute("email");
		MemberVO member = memberService.selectMemberService(email);
		model.addAttribute("member", member);
		// end 현우 추가 부분
	}

	@RequestMapping(value = "/auctionPurchaseForm", method = RequestMethod.POST)
	public String paymentRegisterForm_post(BidVO vo) throws Exception {
		
		System.out.println(vo);
		
		return "redirect:auctionPurchase";

	}
	
	@RequestMapping("auctionPurchase")
	public void auctionPurchase() throws Exception{
		
	}

}
