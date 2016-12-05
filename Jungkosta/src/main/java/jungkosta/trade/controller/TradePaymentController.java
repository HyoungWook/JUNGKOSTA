package jungkosta.trade.controller;

import javax.inject.Inject;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jungkosta.commons.util.Encryption;
import jungkosta.commons.util.TradeThread;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.SignupService;
import jungkosta.trade.domain.PaymentVO;
import jungkosta.trade.domain.PurchaseVO;
import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.PaymentService;
import jungkosta.trade.service.PurchaseService;
import jungkosta.trade.service.SaleService;

@Controller
public class TradePaymentController {
	
	@Inject
	private PaymentService paymentService;
	
	@Inject
	private PurchaseService purchaseService;
	
	@Inject
	private SignupService memberService;
	
	@Inject
	private SaleService saleService;
	
	
	//결제 폼_tw
	@RequestMapping(value="/tradePayment", method=RequestMethod.GET)
	public void tradePaymentForm(){
		System.out.println("결제 폼");
	}
	
	@RequestMapping(value="/tradepaymentProc", method=RequestMethod.POST)
	public String tradePaymentProc(Model model, PaymentVO paymentVo, PurchaseVO purchaseVo) throws Exception{
		System.out.println("purchase_id : " + purchaseVo.getPurchase_id());
		PurchaseVO purchasevo = purchaseService.selectPurchase(purchaseVo.getPurchase_id());
			
		System.out.println(purchasevo.getPurchase_id());
		paymentVo.setPayment_status("결제완료");
		
		purchasevo.setPurchase_status("배송 완료");
		purchaseService.updatePurchase(purchasevo);
		paymentVo.setPayment_cost(purchasevo.getPurchase_cost());
		
		paymentService.insertPayment(paymentVo);
		System.out.println("결제완료");
		
		MemberVO member = memberService.selectMemberService(purchasevo.getEmail());
	
		SaleVO sale = saleService.searchSale(purchasevo.getSale_id());
	
	
		TradeThread thread = new TradeThread(saleService, memberService, purchaseService, 
				purchasevo.getSale_id(), purchaseVo.getPurchase_id());
		thread.start();
		TradeAfterPayController.threadList.add(thread);
		
		return "redirect:/purchase_info";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/passCheck", method=RequestMethod.POST)
	public ResponseEntity<String> passCheck(@RequestParam("password") String password){
		ResponseEntity<String> entity = null;
		String pass = null;
		System.out.println("패스워드 : " + password);
		Encryption encrypt = new Encryption();		
		try {
			pass = encrypt.passEcnript(password);
			System.out.println("암호화후 "  + pass);
			entity = new ResponseEntity<String>(pass, HttpStatus.OK);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			return entity;
		}
		
		
	}
}
