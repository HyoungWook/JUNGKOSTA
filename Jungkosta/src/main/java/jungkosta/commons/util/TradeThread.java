package jungkosta.commons.util;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.SignupService;
import jungkosta.trade.controller.TradeAfterPayController;
import jungkosta.trade.controller.TradePaymentController;
import jungkosta.trade.domain.PurchaseVO;
import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.PaymentService;
import jungkosta.trade.service.PurchaseService;
import jungkosta.trade.service.SaleService;

@Component
public class TradeThread extends Thread {

	@Inject
	private PaymentService paymentService;

	@Inject
	private SaleService saleService;

	@Inject
	private SignupService memberService;

	@Inject
	private PurchaseService purchaseService;

	private boolean flag;
	private int sale_id;
	private int purchase_id;

	public TradeThread() {
	}

	public TradeThread(SaleService saleService, SignupService memberService, PurchaseService purchaseService,
			int sale_id, int purchase_id) {
		super();
		this.saleService = saleService;
		this.memberService = memberService;
		this.purchaseService = purchaseService;
		this.sale_id = sale_id;
		this.purchase_id = purchase_id;
	}

	public SaleService getSaleService() {
		return saleService;
	}

	public void setSaleService(SaleService saleService) {
		this.saleService = saleService;
	}

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	SaleVO salevo = null;
	PurchaseVO purchasevo = null;
	MemberVO member = null;

	@Override
	public void run() {

		System.out.println("배송 완료 후 처리를 위한 thread 시작!....");
		try {
			System.out.println("스레드 시작..");
			// 클릭시 처리 로직
			for (int i = 0; i < 100; i++) {
				Thread.sleep(1000);
				if (flag == true) {
					logic();
					for (int j = 0; j < TradeAfterPayController.threadList.size(); j++) {
						if (sale_id == TradeAfterPayController.threadList.get(j).getSale_id()) {
							TradeAfterPayController.threadList.remove(j);
							System.out.println("스레드 종료");
							return;
						}
					}
				}
				System.out.println("스레드 실행중.." + (i + 1));
			}
			logic();
			System.out.println("스레드 종료..");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void logic() {
		try {
			salevo = saleService.searchSale(sale_id);
			System.out.println(salevo);
			salevo.setSale_status("거래완료");
			saleService.updateSaleStatusFirst(salevo); // 거래완료로 상태 변경

			//purchasevo = purchaseService.selectPurchase(purchase_id);
			//purchasevo.setPurchase_status("배송 완료");
			//purchaseService.updatePurchase(purchasevo);
			
			member = memberService.selectMemberService(purchasevo.getEmail());
			int price = purchasevo.getPurchase_cost();
			int extra_price = (int) (price * 0.01); // 적립금
			System.out.println("상품가격 : " + price);
			member.setPoint(extra_price);
			System.out.println("적립할 마일리지 : " + extra_price);
			purchaseService.backPoint(member);
			saleService.updateDealCount(purchasevo.getEmail());
			// 마일리지 적립
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
