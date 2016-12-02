package jungkosta.auction.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jungkosta.auction.domain.SellerReviewVO;
import jungkosta.auction.service.AuctionReviewService;

@Controller
public class AuctionReviewController {
	
	@Inject
	private AuctionReviewService service;
	
	@RequestMapping(value = "/reviewTest", method = RequestMethod.GET)
	public void test() throws Exception {
	}
	
	
	@RequestMapping(value="auctionComment", method = RequestMethod.POST)
	public String auctionComment(SellerReviewVO vo) throws Exception{
		
		vo.setSeller_review_id(service.sellerReview_id()+1);
		
		service.insertAuctionReview(vo);
		
		return "";

	}
	
}
