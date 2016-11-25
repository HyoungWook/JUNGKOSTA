package jungkosta.auction.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.BidVO;

@Repository
public class AucPurDAOImpl implements AucPurDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "jungkosta.main.mappers.auction.AuctionPurchaseMapper";

	@Override
	public void insertAuctionPurchase(BidVO vo) throws Exception {
		sqlSession.insert(namespace + ".insertAuctionPurchase", vo);
	}

	@Override
	public int selectBid_id() throws Exception {

		if (sqlSession.selectOne(namespace + ".selectBid_id") != null) {
			return sqlSession.selectOne(namespace + ".selectBid_id");
		} else {
			return 0;
		}

	}

	@Override
	public BidVO readBid(int bidding_id) throws Exception {

		return sqlSession.selectOne(namespace + ".readBid", bidding_id);
	}

	@Override
	public void endAuction(int auction_id) throws Exception {
		sqlSession.update(namespace + ".endAuction", auction_id);

	}

}
