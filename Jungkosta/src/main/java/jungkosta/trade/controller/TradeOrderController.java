package jungkosta.trade.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.trade.domain.PurchaseVO;
import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.PurchaseService;
import jungkosta.trade.service.SaleService;

@Controller
public class TradeOrderController {

	@Inject
	private SaleService service_tw;
	
	@Inject
	private PurchaseService purchaseService;
	//물품 주문_tw
	@RequestMapping(value = "/tradeOrder", method=RequestMethod.GET)
	public void tradeOrderForm(Model model, int sale_id) throws Exception{
		System.out.println("order sale_id : " + sale_id);
		int deliveryPrice = 2500;
		
		model.addAttribute("deliveryPrice", deliveryPrice);
		model.addAttribute("register", service_tw.searchSale(sale_id));
		
	}
	
	@RequestMapping(value="/tradeOrderProc", method=RequestMethod.POST)
	public String tradeOrderProc(SaleVO saleVO, PurchaseVO purchaseVO)throws Exception{
			System.out.println("주문창 -> 완료"+ saleVO);
			System.out.println("구매 : " + purchaseVO);
			
			SaleVO salevo = service_tw.searchSale(saleVO.getSale_id());
		
			purchaseVO.setPurchase_status("입금대기중");
			purchaseService.insertPurchase(purchaseVO);
			
			String firstStatus = "거래중";
			salevo.setSale_status(firstStatus);
			
			service_tw.updateSaleStatusFirst(salevo);
			
			System.out.println("구매완료 : " + purchaseVO);
			
		return "home";
	}
}
