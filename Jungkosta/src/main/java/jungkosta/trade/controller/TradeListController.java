package jungkosta.trade.controller;

import java.util.List;

import javax.inject.Inject;
import javax.mail.search.IntegerComparisonTerm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.PurchaseService;
import jungkosta.trade.service.SaleService;
import jungkosta.trade.service.TradeService;

@Controller
public class TradeListController {

	@Inject
	private SaleService service_tw;
	
	@Inject
	private TradeService service;
	
	@Inject
	private PurchaseService purchaseService;

	//카테고리별 목록_ysi
	@RequestMapping(value = "/tradeList", method=RequestMethod.GET)
	public void tradelistSub(Model model, @RequestParam("subca_id") Integer subca_id, String sort) throws Exception{
		model.addAttribute("list", service.listSale(subca_id, sort));
	}
	
	//tradeList 정렬_ysi
	@ResponseBody
	@RequestMapping(value= "/listSale/{subca_id}/{sort}")
	public List<SaleVO> sortAjax( 
			@PathVariable("sort") String sort, 
			@PathVariable("subca_id") Integer subca_id) throws Exception {
		
		return service.listSale(subca_id, sort);
	}
}
