package jungkosta.trade.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.trade.domain.PaymentVO;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "jungkosta.mappers.trade.TradePaymentMapper";
	
	
	//주문_결제-tw
	@Override
	public void insertPaymentTx(PaymentVO paymentvo) throws Exception {
	

	}

}
