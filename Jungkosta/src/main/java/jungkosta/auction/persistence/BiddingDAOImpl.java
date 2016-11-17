package jungkosta.auction.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import jungkosta.auction.domain.BiddingVO;

public class BiddingDAOImpl implements BiddingDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "jungkosta.mappers.auction.BidMapper";

	@Override
	public void registerBid(BiddingVO vo) throws Exception {
		sqlSession.insert(namespace + ".registerBid", vo);
	}

	@Override
	public int selectBidding_id() throws Exception {

		if (sqlSession.selectOne(namespace + ".selectBidding_id") != null) {
			return sqlSession.selectOne(namespace + ".selectBidding_id");
		} else {
			return 0;
		}

	}

}
