package jungkosta.trade.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.domain.SubCategoryVO;
import jungkosta.trade.service.SaleService;
import jungkosta.trade.service.TradeService;

@Controller
public class TradeController {

	@Inject
	private TradeService service;	//TradeService_ysi
	
	@Inject
	private SaleService service_tw;
	
	//물품 등록_ysi
	@RequestMapping(value= "/tradeRegisterForm", method= RequestMethod.GET)
	public void registerGet(SaleVO saleVO) {
		System.out.println("Insert Form");
	}
	
	//물품 등록_ysi
	@RequestMapping(value= "/tradeRegisterForm", method= RequestMethod.POST)
	public String registPost(SaleVO saleVO) throws Exception{
		service.regist(saleVO);
		
		return "redirect:/Jungkosta";
	}
	
	//물품 상세_tw
	@RequestMapping(value = "/tradeDetail", method=RequestMethod.GET)
	public void tradeDetail(@RequestParam("sale_id") int sale_id, Model model) throws Exception{
		System.out.println("sale_id : " + sale_id);
		
		SaleVO salevo = service_tw.searchSale(sale_id);
		SubCategoryVO subCavo = service_tw.searchSubCategory(salevo.getSubca_id());
		String totalCavo = service_tw.searchTotalCategory(subCavo.getCa_id());
		
		model.addAttribute("totalcategoryName",totalCavo);
		model.addAttribute("subcategory", subCavo);
		model.addAttribute("register", salevo);

	}

	//카테고리별 목록_tw
	@RequestMapping(value = "/tradeList", method=RequestMethod.GET)
	public String tradelistSub(Model model, @RequestParam("subca_id") Integer subca_id) throws Exception{
		System.out.println("subca_id : " + subca_id);
		
		model.addAttribute("list", service_tw.listSalesub(subca_id));
	
		return "tradeList";
	}
	
	//물품 주문_tw
	@RequestMapping(value = "/tradeOrder", method=RequestMethod.GET)
	public void tradeOrderForm(Model model, int sale_id) throws Exception{
		System.out.println("order sale_id : " + sale_id);
		int deliveryPrice = 2500;
		
		model.addAttribute("deliveryPrice", deliveryPrice);
		model.addAttribute("register", service_tw.searchSale(sale_id));
		
	}
}
