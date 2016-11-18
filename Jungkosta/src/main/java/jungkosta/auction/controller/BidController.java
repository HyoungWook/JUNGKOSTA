package jungkosta.auction.controller;


import javax.inject.Inject;

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
		
		return "/bidRegisterForm";
	}
	
	@RequestMapping(value="/bidRegisterForm", method=RequestMethod.POST)
	public void biddingForm_POST(BiddingVO vo) throws Exception{
		
		bidService.registerBid(vo);
		
	}
	

}
