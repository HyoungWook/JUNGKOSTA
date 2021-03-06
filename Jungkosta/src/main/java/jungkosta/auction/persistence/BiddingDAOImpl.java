package jungkosta.auction.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.BiddingVO;

@Repository
public class BiddingDAOImpl implements BiddingDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "jungkosta.main.mappers.auction.BidMapper";

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

	@Override
	public int countBidding(int auction_id) throws Exception {
		return sqlSession.selectOne(namespace + ".countBidding", auction_id);
	}

	@Override
	public BiddingVO readBidding(int bidding_id) throws Exception {
		
		return sqlSession.selectOne(namespace + ".readBidding", bidding_id);
	}

	@Override
	public List<BiddingVO> biddingList(int auction_id) throws Exception {
		return sqlSession.selectList(namespace+".biddingList", auction_id);
	}

	@Override
	public BiddingVO bid_person(int auction_id) throws Exception {
		return sqlSession.selectOne(namespace + ".bid_person", auction_id);
	}

}
