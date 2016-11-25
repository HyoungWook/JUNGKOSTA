package jungkosta.auction.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.auction.domain.AucAndBidVO;
import jungkosta.auction.domain.AucPayVO;
import jungkosta.auction.service.AucPayService;

@Controller
public class AuctionPaymentController {

	@Inject
	private AucPayService service;

	@RequestMapping(value = "/aucPaymentForm", method = RequestMethod.GET)
	public String aucPaymentForm(@ModelAttribute("bid_id") int bid_id, Model model) throws Exception {

		AucAndBidVO vo = service.readPurchase(bid_id);

		model.addAttribute("total_cost", vo.getTotal_cost());

		return "aucPaymentForm";
	}

	@ResponseBody
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

}
