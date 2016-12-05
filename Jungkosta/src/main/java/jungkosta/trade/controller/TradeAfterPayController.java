package jungkosta.trade.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.commons.util.TradeThread;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.SignupService;
import jungkosta.trade.domain.PurchaseVO;
import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.PaymentService;
import jungkosta.trade.service.PurchaseService;
import jungkosta.trade.service.SaleService;

@Controller
public class TradeAfterPayController {
	public static List<TradeThread> threadList = Collections.synchronizedList(new ArrayList<>());
	
	@Inject
	private PaymentService paymentService;
	
	@Inject
	private PurchaseService purchaseService;
	
	@Inject
	private SignupService memberService;
	
	@Inject
	private SaleService saleService;
	
	@RequestMapping(value="/tradeThread", method=RequestMethod.GET)
	public void threadTest2(int purchase_id, Model model, int payment_id, int sale_id){
		System.out.println("넘어온 구매번호 : " + purchase_id);
		SaleVO salevo = null;
		PurchaseVO purchasevo = null;
		MemberVO member = null;
		try {
			purchasevo = purchaseService.selectPurchase(purchase_id);
			member = memberService.selectMemberService(purchasevo.getEmail());
			
			salevo = saleService.searchSale(sale_id);
			model.addAttribute("purchase", purchasevo);
			model.addAttribute("payment_id", payment_id);
			model.addAttribute("sale", salevo);
			model.addAttribute("subca_id", salevo.getSubca_id());
			model.addAttribute("member", member);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		TradeThread thread = new TradeThread(saleService, memberService, purchaseService, 
				sale_id, purchase_id);
		thread.start();
		threadList.add(thread);
	}
	
	@ResponseBody
	@RequestMapping(value="/tradeThread", method=RequestMethod.POST)
	public ResponseEntity<String> threadTestProc(@RequestParam("purchase_id") int purchase_id, 
			@RequestParam("sale_id") int sale_id, @RequestParam("flag") boolean flag){
		
		System.out.println("테스트");
		System.out.println(flag);
		ResponseEntity<String> entity = null;
	
		try {
			System.out.println("ajax 테스트");
			for(int i = 0 ; i < threadList.size();i++){
				if(threadList.get(i).getSale_id() ==sale_id){
					flag = true;
					threadList.get(i).setFlag(flag);
				}
			}
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
