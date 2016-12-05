package jungkosta.trade.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.trade.domain.Seller_ReviewVO;

@Repository
public class Seller_ReviewDAOImpl implements Seller_ReviewDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "jungkosta.mappers.trade.TradeSellerReviewMapper";
	
	@Override
	public Integer selectSeller_id() throws Exception {
		if ((sqlSession.selectOne(namespace + ".selectSeller_id")) == null) {
			return 0;
		} else {
			return sqlSession.selectOne(namespace + ".selectSeller_id");
		}
	}

	@Override
	public void insertPurchase(Seller_ReviewVO sellerReview) throws Exception {
		sqlSession.insert(namespace+".insertSellerReview", sellerReview);	
	}

}
