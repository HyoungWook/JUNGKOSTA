package jungkosta.trade.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.trade.domain.SaleVO;

@Repository
public class TradeDAOImpl implements TradeDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "jungkosta.mappers.trade.TradeMapper";

	
	@Override
	public void insertSale(SaleVO saleVO) throws Exception {
		sqlSession.insert(namespace + ".insertSale", saleVO);
	}

	@Override
	public int selectS_id() throws Exception {
		return sqlSession.selectOne(namespace + ".selectS_id");
	}

}
