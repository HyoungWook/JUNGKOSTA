package jungkosta.auction.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.domain.CategoryVO;
import jungkosta.auction.domain.SellerReviewVO;
import jungkosta.auction.service.AuctionReviewService;
import jungkosta.auction.service.AuctionService;
import jungkosta.auction.service.BiddingService;

@Controller
public class AuctionDetailController {

	//start 현우 수정 부분
	
	@Inject
	private AuctionService auctionService;
	
	@Inject
	private BiddingService bidService;
	
	@Inject
	private AuctionReviewService reviewService;

	@RequestMapping(value = "/auctionDetail", method = RequestMethod.GET)
	public void auctionDetail(@RequestParam("sale_id") int sale_id, Model model) throws Exception {

		AuctionVO auction = auctionService.read(sale_id);
		
		List<SellerReviewVO> reviewList = reviewService.reviewList(auction.getEmail());
		
		CategoryVO category = auctionService.selectCategory(auction.getSubca_id());
		
		int count = bidService.countBidding(auction.getAuction_id());

		model.addAttribute("auction", auction);
		model.addAttribute("category", category);
		model.addAttribute("countBidding", count);
		model.addAttribute("thumbnail", auctionService.getThunbnail(auction.getSale_id()));
		model.addAttribute("reviewList", reviewList);
	}
	
	@RequestMapping(value = "auctionbidList", method = RequestMethod.GET)
	public void auctionbidList_GET(@RequestParam("sale_id") int sale_id,Model model) throws Exception {
	
		AuctionVO auction = auctionService.read(sale_id);
		
		int auction_id = auction.getAuction_id();
		
		List<BiddingVO> list = bidService.biddingList(auction_id);
				
		model.addAttribute("auction", auction);
		model.addAttribute("listBidding", list);
		
		
	}
}
