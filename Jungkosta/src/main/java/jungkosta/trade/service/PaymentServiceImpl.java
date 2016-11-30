package jungkosta.trade.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.trade.domain.PaymentVO;
import jungkosta.trade.persistence.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Inject
	private PaymentDAO paymentDAO;

	
	
	//주문-결제_tw
	@Override
	public void insertPayment(PaymentVO paymentvo) throws Exception {
		paymentvo.setPayment_id(paymentDAO.selectPayment_id()+1);
		System.out.println(paymentvo.getPayment_id());
		paymentDAO.insertPayment(paymentvo);
	}


}
