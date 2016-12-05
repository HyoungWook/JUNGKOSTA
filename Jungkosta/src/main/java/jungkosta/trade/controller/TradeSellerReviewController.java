package jungkosta.trade.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@ResponseBody
	@RequestMapping(value="/tradeSellerReview", method=RequestMethod.POST)
	public ResponseEntity<String> tradeSellerReview(@RequestParam("sale_id") int sale_id, 
			Seller_ReviewVO sellerReview, HttpServletRequest request){
			SaleVO salevo = null;
			ResponseEntity<String> entity = null;
			HttpSession session = request.getSession();
			
			String email = (String)session.getAttribute("email");
			
		try {
			 salevo = saleService.searchSale(sale_id);
			 sellerReview.setPurchaser(email);
			 sellerReview.setSeller(salevo.getEmail());
			 System.out.println("판매자 평" + sellerReview);
			 sellerReviewService.insertPurchase(sellerReview);
			 entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
