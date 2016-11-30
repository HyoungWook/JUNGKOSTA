package jungkosta.trade.persistence;

import jungkosta.trade.domain.PaymentVO;
import jungkosta.trade.domain.PurchaseVO;

public interface PaymentDAO {

	public void insertPayment(PaymentVO paymentvo)throws Exception;
	
	public Integer selectPayment_id() throws Exception;
	
}
