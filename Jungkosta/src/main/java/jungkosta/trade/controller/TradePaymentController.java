package jungkosta.trade.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.trade.service.SaleService;

@Controller
public class TradePaymentController {

	@Inject
	private SaleService service;
	
	//결제 폼_tw
	@RequestMapping(value="/tradePayment", method=RequestMethod.GET)
	public void tradePaymentForm(){
		System.out.println("결제 폼");
	}
}
