package jungkosta.trade.service;

import jungkosta.trade.domain.PurchaseVO;

public interface PurchaseService {

	//주문_결제-tw
	public void insertPurchase(PurchaseVO purchase)throws Exception;
	
	public void insertPaymentTx(PurchaseVO purchase)throws Exception;
}
