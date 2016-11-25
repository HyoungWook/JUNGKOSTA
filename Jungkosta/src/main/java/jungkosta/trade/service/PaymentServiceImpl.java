package jungkosta.trade.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.trade.domain.PaymentVO;
import jungkosta.trade.persistence.PaymentDAO;
import jungkosta.trade.persistence.PurchaseDAO;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Inject
	private PaymentDAO paymentDAO;
	
	@Inject
	private PurchaseDAO purchaseDAO;

	
	//주문-결제_tw
	@Override
	public void insertPaymentTx(PaymentVO paymentvo) throws Exception {
		//purchaseDAO.insertPurchase(paymentvo);

	}

}
