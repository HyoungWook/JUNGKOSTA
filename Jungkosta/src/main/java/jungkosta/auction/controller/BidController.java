package jungkosta.auction.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.service.AuctionService;
import jungkosta.auction.service.BiddingService;
import jungkosta.commons.util.BidThread;

@Controller
public class BidController {
	
	@Inject
	private BiddingService bidService;
	
	@Inject
	private AuctionService auctionService;
	
	public BidController() {
		
		new BidThread().start();
		
	}
	
	
	@RequestMapping(value="/bidRegisterForm/{sale_id}", method=RequestMethod.GET)
	public String biddingForm_GET(@PathVariable("sale_id") int sale_id,  Model model) throws Exception{
		
		AuctionVO auction = auctionService.read(sale_id);
		model.addAttribute("auction", auction);
			
		return "bidRegisterForm";
	}
	
	@RequestMapping(value="bidRegisterForm/bidRegister", method=RequestMethod.POST)
	public String biddingForm_POST(BiddingVO vo,AuctionVO auction,HttpServletRequest request) throws Exception{
		int item_cost = Integer.parseInt(request.getParameter("bidding_cost"));
		
		vo.setBidding_id(bidService.selectBidding_id());
		
		bidService.registerBid(vo);
		
		
		auction.setItem_cost(item_cost);
		auction.setAuction_stcost(item_cost);
		
		auctionService.updateDetail(auction);
		
		return "pageProc";
		
	}
	


}
