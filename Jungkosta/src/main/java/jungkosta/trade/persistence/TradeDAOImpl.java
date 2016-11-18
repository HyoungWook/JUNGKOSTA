package jungkosta.trade.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.trade.domain.SaleVO_tw;

@Repository
public class TradeDAOImpl implements TradeDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "jungkosta.mappers.trade.tradeMapper";

	@Override
	public void insertSale(SaleVO_tw sale) throws Exception {
		sqlSession.insert(namespace + ".insertSale", sale);
	}

}
