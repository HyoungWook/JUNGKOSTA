package jungkosta.trade.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.SignupService;
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
	
	@Inject
	private SignupService memberService;
	
	//물품 주문,멤버 추가_tw 
	@RequestMapping(value = "/tradeOrder", method=RequestMethod.GET)
	public void tradeOrderForm(Model model, int sale_id, HttpServletRequest request) throws Exception{
		
		int deliveryPrice = 2500;
		
		HttpSession session = request.getSession();
		
		MemberVO member = memberService.selectMemberService((String)session.getAttribute("email"));
		String[] str = member.getAddress().split("/");
		try {
			model.addAttribute("member", member);
			model.addAttribute("address1",str[0]);
			model.addAttribute("address2",str[1]);
			model.addAttribute("address3",str[2]);
			model.addAttribute("deliveryPrice", deliveryPrice);
			model.addAttribute("register", service_tw.searchSale(sale_id));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//주문_tw
	@RequestMapping(value="/tradeOrderProc", method=RequestMethod.POST)
	public String tradeOrderProc(SaleVO saleVO, PurchaseVO purchaseVO, Model model)throws Exception{
			System.out.println("주문창 -> 완료"+ saleVO);
			System.out.println("구매 : " + purchaseVO);
			
			SaleVO salevo = service_tw.searchSale(saleVO.getSale_id());
			
			if(purchaseVO.getPayment_method().equals("실시간계좌이체")){//실시간계좌이체
					purchaseVO.setPurchase_status("입금대기중");
					purchaseService.insertPurchase(purchaseVO);
				
					String firstStatus = "거래중";
					salevo.setSale_status(firstStatus);
				
					service_tw.updateSaleStatusFirst(salevo);
				
					model.addAttribute("register", salevo);
					model.addAttribute("purchase_ktw", purchaseVO);
				
				return "tradePayment";
				
				
			}else{//무통장입금
				
				purchaseVO.setPurchase_status("입금대기중");
				purchaseService.insertPurchase(purchaseVO);
				
				String firstStatus = "거래중";
				salevo.setSale_status(firstStatus);
				
				service_tw.updateSaleStatusFirst(salevo);
				
				System.out.println("구매완료 : " + purchaseVO);
				
				return "redirect:/trade/tradeList?subca_id=" + salevo.getSubca_id();
			}
	}
	
}
