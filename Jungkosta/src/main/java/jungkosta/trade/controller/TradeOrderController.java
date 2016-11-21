package jungkosta.trade.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.trade.service.SaleService;

@Controller
public class TradeOrderController {

	@Inject
	private SaleService service_tw;
	
	//물품 주문_tw
	@RequestMapping(value = "/tradeOrder", method=RequestMethod.GET)
	public void tradeOrderForm(Model model, int sale_id) throws Exception{
		System.out.println("order sale_id : " + sale_id);
		int deliveryPrice = 2500;
		
		model.addAttribute("deliveryPrice", deliveryPrice);
		model.addAttribute("register", service_tw.searchSale(sale_id));
		
	}
}
