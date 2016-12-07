package jungkosta.trade.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
   
   //실시간 계좌이체로 결제 시 스레드 실행-tw
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
         purchasevo = purchaseService.selectPurchase(purchase_id);
         purchasevo.setPurchase_status("배송 완료");
         purchaseService.updatePurchase(purchasevo);
         
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
   
   @RequestMapping("/tradeDeposit")
   public String tradeDeposit(){
      
      
      return "tradeThread";
   }
   //무통장으로 결제시 스레드 실행-tw
   @ResponseBody
   @RequestMapping(value="tradeWithdraw", method=RequestMethod.POST)
   public ResponseEntity<String> moneyCheck(PaymentVO payment, @RequestParam("sale_id") int sale_id){
      ResponseEntity<String> entity = null;
      System.out.println("결제 : " + payment);
      PurchaseVO purchasevo = null;
      try {
         purchasevo = purchaseService.findPurchase(sale_id);
         if(payment.getPayment_cost() == purchasevo.getPurchase_cost()){
            paymentService.insertPayment(payment);
            purchasevo = purchaseService.selectPurchase(payment.getPurchase_id());
            purchasevo.setPurchase_status("배송 완료");
            purchaseService.updatePurchase(purchasevo);
            TradeThread thread = new TradeThread(saleService, memberService, purchaseService, 
                  sale_id, payment.getPurchase_id());
            thread.start();
            threadList.add(thread);
            entity = new ResponseEntity<String>("success", HttpStatus.OK);
         }else{
            entity = new ResponseEntity<String>("fail", HttpStatus.OK);
         }
          
      } catch (Exception e) {
         e.printStackTrace();
         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);   
      }
   
      return entity;
   }
   
   
   //실시간 계좌이체-tw
   @ResponseBody
   @RequestMapping("/tradeThread2")
   public ResponseEntity<String> threadTestProc(@RequestParam("purchase_id") int purchase_id, 
         @RequestParam("sale_id") int sale_id){
      
      System.out.println("테스트");
      ResponseEntity<String> entity = null;
      boolean flag = false;
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
   
   
   @RequestMapping("/tradewithDrawProc")
   public String threadTestProc2(@RequestParam("purchase_id") int purchase_id, 
         @RequestParam("sale_id") int sale_id){
      
      System.out.println("테스트!!");
      
      boolean flag = false;
      try {
         System.out.println("ajax 테스트");
         for(int i = 0 ; i < threadList.size();i++){
            if(threadList.get(i).getSale_id() ==sale_id){
               flag = true;
               threadList.get(i).setFlag(flag);
            }
         }
         
      } catch (Exception e) {
         e.printStackTrace();
         
      }
      return "tradeThread";
   }
   
   
   
   //무통장입금 구매확정 버튼 눌렀을시 -tw
   @ResponseBody
   @RequestMapping("/successTotrade")
   public ResponseEntity<String> threadwithProc(@RequestParam("sale_id") int sale_id){
      
      System.out.println("테스트");
      //System.out.println(flag);
      ResponseEntity<String> entity = null;
      boolean flag = false;
      
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