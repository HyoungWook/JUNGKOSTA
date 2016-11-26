package jungkosta.auction.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jungkosta.auction.domain.AucAndBidVO;
import jungkosta.auction.domain.AucPayVO;
import jungkosta.auction.service.AucPayService;

@RestController
public class AuctionPaymentController {

	@Inject
	private AucPayService service;

	@RequestMapping(value = "/aucPaymentForm", method = RequestMethod.POST)
	public ResponseEntity<String> aucPaymentForm_post(AucPayVO vo, @RequestParam("form_btn") String form_btn)
			throws Exception {

		ResponseEntity<String> entity = null;

		try {
			AucAndBidVO view = service.readPurchase(vo.getBid_id());

			if (form_btn.equals("complete_btn")) {
				service.registerPay(vo, view.getSale_id());
			} else {
				service.cancelPay(view);
			}

			entity = new ResponseEntity<>("success", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping("/closePay")
	public ResponseEntity<String> closePay(AucPayVO vo) throws Exception {
		
		System.out.println(vo);
		
		ResponseEntity<String> entity = null;
		System.out.println("브라우저 종료 or 새로고침");
		
		try {
			AucAndBidVO view = service.readPurchase(vo.getBid_id());
			service.cancelPay(view);
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
