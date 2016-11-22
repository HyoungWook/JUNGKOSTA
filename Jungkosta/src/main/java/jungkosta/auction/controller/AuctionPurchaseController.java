package jungkosta.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuctionPurchaseController {

	
	@RequestMapping(value="/auctionPurchaseForm", method=RequestMethod.GET)
	public void paymentRegisterForm_get() throws Exception{
		
	}
	
}
