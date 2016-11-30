package jungkosta.auction.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.commons.util.AucCompleteSale;

@Controller
public class AuctionAfterPayController {

	@RequestMapping(value = "/aucAfterPay", method = RequestMethod.GET)
	public void aucAfterPay(@ModelAttribute("sale_id") int sale_id) throws Exception {

	}

	@ResponseBody
	@RequestMapping("/completeToSale")
	public ResponseEntity<String> completeToSale(@RequestParam("sale_id") int sale_id) throws Exception {
		ResponseEntity<String> entity = null;

		try {

			List<AucCompleteSale> list = AuctionPaymentController.threadList;

			for (AucCompleteSale thread : list) {
				if (thread.getSale_id() == sale_id) {
					thread.setFlag(true);
				}
			}

			entity = new ResponseEntity<>("success", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
