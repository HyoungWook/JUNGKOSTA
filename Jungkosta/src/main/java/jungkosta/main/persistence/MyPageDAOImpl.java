package jungkosta.main.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.main.domain.AucAndSaleVO;
import jungkosta.main.domain.AucPurVO;

@Repository
public class MyPageDAOImpl implements MyPageDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "jungkosta.mappers.main.MyPageMapper";

	@Override
	public List<AucPurVO> readMyAucPur(String email) throws Exception {
		return sqlSession.selectList(namespace + ".readMyAucPur", email);
	}

	@Override
	public List<AucAndSaleVO> readMyAucSale(String email) throws Exception {
		return sqlSession.selectList(namespace + ".readMyAucSale", email);
	}

	@Override
	public int bestBiddingCost(int auction_id) throws Exception {
		return sqlSession.selectOne(namespace + ".bestBiddingCost", auction_id);
	}

}
