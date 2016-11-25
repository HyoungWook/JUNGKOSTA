package jungkosta.auction.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jungkosta.auction.domain.AucAndBidVO;
import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.BidVO;
import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.service.AucPayService;
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

	@Inject
	private AucPayService aucPayService;

	@RequestMapping(value = "/auctionPurchaseForm", method = RequestMethod.GET)
	public void paymentRegisterForm_get(HttpServletRequest request, Model model) throws Exception {

		int sale_id = Integer.parseInt(request.getParameter("sale_id"));
		int bidding_id = Integer.parseInt(request.getParameter("bidding_id"));

		String email = (String) request.getSession().getAttribute("email");
		MemberVO member = memberService.selectMemberService(email);
		model.addAttribute("member", member);

		String[] address = member.getAddress().split("/");

		AuctionVO auction = auctionService.read(sale_id);
		BiddingVO bidding = biddingService.readBidding(bidding_id);

		model.addAttribute("item", auction);
		model.addAttribute("bidding", bidding);
		model.addAttribute("address1", address[0]);
		model.addAttribute("address2", address[1]);
		model.addAttribute("address3", address[2]);
	}

	@RequestMapping(value = "/auctionPurchaseForm", method = RequestMethod.POST)
	public String paymentRegisterForm_post(BidVO vo, RedirectAttributes rttr, HttpServletRequest request)
			throws Exception {

		int sale_id = Integer.parseInt(request.getParameter("sale_id"));
		String[] address = request.getParameterValues("address");
		String postCode = request.getParameter("postCode");

		String realAddress = address[0] + " " + address[1] + "/" + postCode;

		vo.setDel_address(realAddress);

		purchaseService.registerPurService(vo, sale_id);

		rttr.addAttribute("bidding_id", vo.getBidding_id());
		rttr.addAttribute("sale_id", sale_id);

		return "redirect:/auction/auctionPurchase";

	}

	@RequestMapping("/auctionPurchase")
	public void auctionPurchase(BidVO vo, @RequestParam("sale_id") int sale_id, Model model) throws Exception {
		BidVO purchase = purchaseService.readBid(vo.getBidding_id());

		AuctionVO item = auctionService.read(sale_id);

		MemberVO admin = memberService.selectMemberService("admin@admin.com");

		AucAndBidVO aab = aucPayService.readPurchase(item.getAuction_id());

		model.addAttribute("sale_id", sale_id);
		model.addAttribute("purchase", purchase);
		model.addAttribute("item", item);
		model.addAttribute("admin", admin);
	}

	@ResponseBody
	@RequestMapping(value = "/purchaseCancel", method = RequestMethod.POST)
	public ResponseEntity<String> purchaseCancel(@RequestParam("sale_id") int sale_id,
			@RequestParam("bidding_id") int bidding_id) throws Exception {
		ResponseEntity<String> entity = null;

		try {

			purchaseService.cancelPurchase(sale_id, bidding_id);
			
			entity = new ResponseEntity<>("success", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
