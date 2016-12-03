package jungkosta.auction.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.SellerReviewVO;
import jungkosta.auction.service.AuctionReviewService;
import jungkosta.auction.service.AuctionService;

@Controller
public class AuctionReviewController {

	@Inject
	private AuctionReviewService service;

	@Inject
	private AuctionService auctionService;

	@ResponseBody
	@RequestMapping("/auctionComment")
	public ResponseEntity<String> auctionComment(SellerReviewVO vo, HttpServletRequest request) throws Exception {
		ResponseEntity<String> entity = null;

		try {

			String purchaser = (String) request.getSession().getAttribute("email");

			int sale_id = Integer.parseInt(request.getParameter("sale_id"));

			AuctionVO auction = auctionService.read(sale_id);

			vo.setPurchaser(purchaser);
			vo.setSeller(auction.getEmail());
			vo.setSeller_review_id(service.sellerReview_id() + 1);

			service.insertAuctionReview(vo);

			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
