package jungkosta.auction.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.BidVO;
import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.service.AucPurService;
import jungkosta.auction.service.AuctionService;
import jungkosta.auction.service.BiddingService;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.SignupService;

@Controller
public class AuctionPurchaseController {

	@Inject
	private SignupService memberService;

	@Inject
	private AucPurService purchaseService;

	@Inject
	private BiddingService biddingService;

	@Inject
	private AuctionService auctionService;

	@RequestMapping(value = "/auctionPurchaseForm", method = RequestMethod.GET)
	public void paymentRegisterForm_get(HttpServletRequest request, Model model) throws Exception {

		int sale_id = Integer.parseInt(request.getParameter("sale_id"));
		int bidding_id = Integer.parseInt(request.getParameter("bidding_id"));

		String email = (String) request.getSession().getAttribute("email");
		MemberVO member = memberService.selectMemberService(email);
		model.addAttribute("member", member);

		AuctionVO auction = auctionService.read(sale_id);
		BiddingVO bidding = biddingService.readBidding(bidding_id);

		model.addAttribute("item", auction);
		model.addAttribute("bidding", bidding);

	}

	@RequestMapping(value = "/auctionPurchaseForm", method = RequestMethod.POST)
	public String paymentRegisterForm_post(BidVO vo, RedirectAttributes rttr, @RequestParam("sale_id") int sale_id)
			throws Exception {

		purchaseService.registerPurService(vo);

		rttr.addAttribute("bidding_id", vo.getBidding_id());
		rttr.addAttribute("sale_id", sale_id);

		return "redirect:/auction/auctionPurchase";

	}

	@RequestMapping("/auctionPurchase")
	public void auctionPurchase(BidVO vo, @RequestParam("sale_id") int sale_id, Model model) throws Exception {
		BidVO purchase = purchaseService.readBid(vo.getBidding_id());

		AuctionVO item = auctionService.read(sale_id);
		
		model.addAttribute("purchase", purchase);
		model.addAttribute("item", item);
	}

}
