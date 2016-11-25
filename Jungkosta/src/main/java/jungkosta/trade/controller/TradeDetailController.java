package jungkosta.trade.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.domain.SubCategoryVO;
import jungkosta.trade.service.SaleService;

@Controller
public class TradeDetailController {
	
	@Inject
	private SaleService service_tw;
	
	//물품상세_tw
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
}
