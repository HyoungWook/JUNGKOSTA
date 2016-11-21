package jungkosta.trade.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.trade.domain.PurchaseVO;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "jungkosta.mappers.trade.TradePurchaseMapper";
	
	@Override
	public Integer selectP_id() throws Exception {
		if ((sqlSession.selectOne(namespace + ".selectP_id")) == null) {
			return 0;
		} else {
			return sqlSession.selectOne(namespace + ".selectP_id");
		}
	}

	@Override
	public void insertPurchase(PurchaseVO purchase) throws Exception {
		sqlSession.insert(namespace+".insertPurchase", purchase);
	}

}
