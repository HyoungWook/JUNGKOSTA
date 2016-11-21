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
	public void insertSale(SaleVO sale) throws Exception {
		sqlSession.insert(namespace + ".insertSale", sale);
		
	}
	
	@Override
	public Integer selectS_id()throws Exception {
		if((sqlSession.selectOne(namespace+".selectS_id")) == null){
			return 0;
		}
		else{
			return sqlSession.selectOne(namespace+".selectS_id");
		}
	}


	

}
