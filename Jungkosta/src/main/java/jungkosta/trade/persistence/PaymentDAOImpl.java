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
	public void insertPayment(PaymentVO paymentvo) throws Exception {
			sqlSession.insert(namespace+".insertPayment", paymentvo);

	}

	//payment_Id-tw
	@Override
	public Integer selectPayment_id() throws Exception {
		if ((sqlSession.selectOne(namespace + ".selectPayment_id")) == null) {
			return 0;
		} else {
			return sqlSession.selectOne(namespace + ".selectPayment_id");
		}
	}

}
