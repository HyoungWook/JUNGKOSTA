package jungkosta.commons.util;

import java.util.List;

import jungkosta.auction.controller.AuctionPaymentController;
import jungkosta.auction.service.AucPayService;

public class AucCompleteSale extends Thread {

	private AucPayService service;
	private int sale_id;

	private boolean flag = false;

	public AucCompleteSale(AucPayService service, int sale_id) {
		this.service = service;
		this.sale_id = sale_id;
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

	@Override
	public void run() {
		System.out.println("'구매확정' 버튼 입력 대기중");
		List<AucCompleteSale> list = AuctionPaymentController.threadList;
		System.out.println("현재 구매 확정 버튼 대기중 : " + list.size());
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				if (flag) {
					treadEnd(list);
					return;
				}
			}
			treadEnd(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void treadEnd(List<AucCompleteSale> list) throws Exception {
		for (AucCompleteSale thread : list) {
			if (thread.getSale_id() == sale_id) {
				list.remove(thread);
				break;
			}
		}
		service.updateSale_status(sale_id);
	}
}
