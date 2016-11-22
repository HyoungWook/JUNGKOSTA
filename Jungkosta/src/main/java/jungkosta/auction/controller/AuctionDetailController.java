package jungkosta.auction.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.CategoryVO;
import jungkosta.auction.service.AuctionService;
import jungkosta.auction.service.BiddingService;

@Controller
public class AuctionDetailController {

	//start 현우 수정 부분
	
	@Inject
	private AuctionService auctionService;
	
	@Inject
	private BiddingService bidService;

	@RequestMapping(value = "/auctionDetail", method = RequestMethod.GET)
	public void auctionDetail(@RequestParam("sale_id") int sale_id, Model model) throws Exception {

		AuctionVO auction = auctionService.read(sale_id);
		
		CategoryVO category = auctionService.selectCategory(auction.getSubca_id());
		
		int count = bidService.countBidding(auction.getAuction_id());

		model.addAttribute("auction", auction);
		model.addAttribute("category", category);
		model.addAttribute("countBidding", count);

	}
	
	//end 현우 수정 부분
}
