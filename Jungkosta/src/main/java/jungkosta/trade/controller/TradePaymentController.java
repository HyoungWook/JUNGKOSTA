package jungkosta.trade.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public static List<TradeThread> threadList = Collections.synchronizedList(new ArrayList<>());
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
	public String tradePaymentProc(RedirectAttributes rttr, PaymentVO paymentVo, PurchaseVO purchaseVo) throws Exception{
		System.out.println("purchase_id : " + purchaseVo.getPurchase_id());
		PurchaseVO purchasevo = purchaseService.selectPurchase(purchaseVo.getPurchase_id());
			
		System.out.println(purchasevo.getPurchase_id());
		paymentVo.setPayment_status("결제완료");
		
		purchasevo.setPurchase_status("배송완료");
		purchaseService.updatePurchase(purchasevo);
		paymentVo.setPayment_cost(purchasevo.getPurchase_cost());
		
		paymentService.insertPayment(paymentVo);
		System.out.println("결제완료");
		
		MemberVO member = memberService.selectMemberService(purchasevo.getEmail());
	
		SaleVO sale = saleService.searchSale(purchasevo.getSale_id());
	
		rttr.addAttribute("email", member.getEmail());
		rttr.addAttribute("purchase_id",purchasevo.getPurchase_id());
		rttr.addAttribute("payment_id", paymentVo.getPayment_id());
		rttr.addAttribute("sale_id", sale.getSale_id());
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/trade/threadTest2";
	}
	
	@RequestMapping(value="/threadTest2", method=RequestMethod.GET)
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
	
	@RequestMapping(value="/threadTest2", method=RequestMethod.POST)
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
	
	@ResponseBody
	@RequestMapping(value="/passCheck", method=RequestMethod.POST)
	public ResponseEntity<String> passCheck(@RequestParam("password") String password){
		ResponseEntity<String> entity = null;
		String pass = null;
		Encryption encrypt = new Encryption();		
		try {
			pass = encrypt.passEcnript(password);
			entity = new ResponseEntity<String>(pass, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
