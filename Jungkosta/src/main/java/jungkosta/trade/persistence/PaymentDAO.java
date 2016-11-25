package jungkosta.trade.persistence;

import jungkosta.trade.domain.PaymentVO;

public interface PaymentDAO {

	public void insertPaymentTx(PaymentVO paymentvo)throws Exception;
}
