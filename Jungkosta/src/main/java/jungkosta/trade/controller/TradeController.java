package jungkosta.trade.controller;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.TradeService;

@Controller
public class TradeController {
	
	@Inject
	private TradeService service;
	
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
	
	@RequestMapping(value= "/tradeList", method= RequestMethod.GET)
	public void tradeList() {
		
	}
	
	@RequestMapping(value= "/tradeDetail", method= RequestMethod.GET)
	public void tradeDetail() {
		
	}
	
	@RequestMapping(value= "/tradeOrder", method= RequestMethod.GET)
	public void tradeOrder() {
		
	}
	
	@RequestMapping(value= "/tradePayment", method= RequestMethod.GET)
	public void tradePayment() {
		
	}
	

}
