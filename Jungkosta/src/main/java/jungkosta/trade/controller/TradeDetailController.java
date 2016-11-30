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
	
	/*//ItemQa_Ajax_ysi
	@ResponseBody
	@RequestMapping(value= "/itemQa/{sale_id}", method=RequestMethod.POST)
	public String itemQaAjax(@PathVariable("sale_id") Integer sale_id, ItemQAVO itemQa) throws Exception {
		ItemQAVO itemQa = new ItemQAVO(); 
		itemQa.setSale_id(sale_id);
		System.out.println("sale_id(Controller) : " + sale_id);
		System.out.println("itemQa(Controller) : " + itemQa);
		service.insertQA(itemQa);
		
		return "SUCCESS";
	}
	
	//ItemQa_getJSON_ysi
	@ResponseBody
	@RequestMapping(value= "/listQa/{sale_id}")
	public List<ItemQAVO> itemQaList(@PathVariable("sale_id") Integer sale_id) throws Exception{
		List<ItemQAVO> list = service.listItemQa(sale_id);
		System.out.println("sale_id(Controller) : " + list.get(0).getSale_id());
		return list;
	}*/
	
}
