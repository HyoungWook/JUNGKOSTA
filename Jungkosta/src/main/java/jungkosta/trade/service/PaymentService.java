package jungkosta.trade.service;

import jungkosta.trade.domain.PaymentVO;

public interface PaymentService {

	//주문_결제-tw
	public void insertPaymentTx(PaymentVO paymentvo)throws Exception;
}
