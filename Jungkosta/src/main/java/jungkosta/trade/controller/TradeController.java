package jungkosta.trade.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.SaleService;

@Controller
public class TradeController {

	@Inject
	private SaleService service;
	
	@RequestMapping(value = "/tradeRegisterForm", method=RequestMethod.GET)
	public void registerForm(Model model){
		String test ="테스트";
		model.addAttribute("test", test);
	}
	
	@RequestMapping(value = "/tradeDetail", method=RequestMethod.GET)
	public void registerProc(Model model){
		String test ="테스트2";
		model.addAttribute("test", test);
	}
	
	@RequestMapping(value = "/tradeList", method=RequestMethod.GET)
	public void tradelist(Model model, SaleVO salevo) throws Exception{
		System.out.println(salevo);
		model.addAttribute("list", service.listSale());
		
	}
	@RequestMapping(value = "/tradeOrder", method=RequestMethod.GET)
	public void tradeOrder() throws Exception{
	}
}
