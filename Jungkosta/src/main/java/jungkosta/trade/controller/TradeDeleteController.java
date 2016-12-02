package jungkosta.trade.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.SignupService;
import jungkosta.trade.domain.PurchaseVO;
import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.PurchaseService;
import jungkosta.trade.service.SaleService;

@RestController
public class TradeDeleteController {

	@Inject
	private PurchaseService purchaseService;
	
	@Inject
	private SaleService saleService;
	
	@Inject
	private SignupService memberService;
	
	@ResponseBody
	@RequestMapping(value="/DeletePurchase", method=RequestMethod.POST)
	public ResponseEntity<String> tradeDeletePurchase(@RequestParam("purchase_id") int purchase_id, HttpServletRequest request) throws Exception{
		System.out.println("구매번호 : " +purchase_id);
		ResponseEntity<String> entity = null;
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		MemberVO member = memberService.selectMemberService(email);
		
		try {
			PurchaseVO purchasevo = purchaseService.selectPurchase(purchase_id);
			SaleVO salevo = saleService.searchSale(purchasevo.getSale_id());
			
			int point = purchasevo.getUse_point();
			System.out.println("회수할 포인트 : " + point);
			member.setPoint(point);
			purchaseService.backPoint(member);
			System.out.println("회수 완료 후 멤버 : " + member);
			
			System.out.println("판매 : " + salevo);
			salevo.setSale_status("거래가능");
			saleService.updateSaleStatusFirst(salevo);
			purchaseService.deletePurchase(purchasevo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@ResponseBody
	@RequestMapping("/DeletePurchase2")
	public ResponseEntity<String> tradeDeletePurchase2(@RequestParam("purchase_id") int purchase_id, HttpServletRequest request) throws Exception{
		System.out.println("구매번호 : " +purchase_id);
		ResponseEntity<String> entity = null;
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		MemberVO member = memberService.selectMemberService(email);
		
		
		try {
			PurchaseVO purchasevo = purchaseService.selectPurchase(purchase_id);
			SaleVO salevo = saleService.searchSale(purchasevo.getSale_id());
			
			int point = purchasevo.getUse_point();
			System.out.println("회수할 포인트 : " + point);
			member.setPoint(point);
			purchaseService.backPoint(member);
			System.out.println("회수 완료 후 멤버 : " + member);
			
			System.out.println("판매 : " + salevo);
			salevo.setSale_status("거래가능");
			saleService.updateSaleStatusFirst(salevo);
			purchaseService.deletePurchase(purchasevo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
}
