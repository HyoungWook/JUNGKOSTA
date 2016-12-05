package jungkosta.trade.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jungkosta.auction.domain.SellerReviewVO;
import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.domain.Seller_ReviewVO;
import jungkosta.trade.service.SaleService;
import jungkosta.trade.service.Seller_ReviewService;

@Controller
public class TradeSellerReviewController {

	@Inject
	private Seller_ReviewService sellerReviewService;
	
	@Inject
	private SaleService saleService;
	
	@RequestMapping(value="/tradeSellerReview", method=RequestMethod.POST)
	public String tradeSellerReview(@RequestParam("sale_id") int sale_id, 
			Seller_ReviewVO sellerReview, RedirectAttributes rttr){
		SaleVO salevo = null;
		
		try {
			 salevo = saleService.searchSale(sale_id);
			 System.out.println("판매자 평" + sellerReview);
			 sellerReviewService.insertPurchase(sellerReview);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/trade/tradeList?subca_id=" + salevo.getSubca_id();
	}
}
