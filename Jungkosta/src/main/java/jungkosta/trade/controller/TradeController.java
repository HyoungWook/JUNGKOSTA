package jungkosta.trade.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.TradeService;

@Controller
public class TradeController {
	
	@Inject
	private TradeService service;
	
	@RequestMapping(value= "/tradeRegisterForm", method= RequestMethod.GET)
	public void registerGet() {
		System.out.println("Insert Form");
	}
	
	@RequestMapping(value= "/tradeRegisterForm", method= RequestMethod.POST)
	public String registPost(SaleVO saleVO, Model model) throws Exception{
		System.out.println(saleVO.getItem_name());
		service.regist(saleVO);
		model.addAttribute("result", "SUCCESS");
		
		return "redirect:/jungkosta/";
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
