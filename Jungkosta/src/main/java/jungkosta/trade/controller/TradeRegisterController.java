package jungkosta.trade.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.TradeService;


@Controller
public class TradeRegisterController {

	@Inject
	private TradeService service;
	//물품 등록_tw
	@RequestMapping(value= "/tradeRegisterForm", method= RequestMethod.GET)
	public void registerGet(SaleVO saleVO) {
		System.out.println("Insert Form");
	}
	
	@RequestMapping(value= "/tradeRegisterForm", method= RequestMethod.POST)
	public String registPost(SaleVO saleVO) throws Exception{
		System.out.println(saleVO);
		service.regist(saleVO);
		
		return "redirect:/Jungkosta";

	}
	
}
