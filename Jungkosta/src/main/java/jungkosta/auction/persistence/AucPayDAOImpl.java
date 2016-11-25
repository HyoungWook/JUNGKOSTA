package jungkosta.auction.persistence;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.AucAndBidVO;
import jungkosta.auction.domain.AucPayVO;

@Repository
public class AucPayDAOImpl implements AucPayDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "jungkosta.main.mappers.auction.AuctionPaymentMapper";

	@Override
	public AucAndBidVO readPurchase(int bid_id) throws Exception {

		return sqlSession.selectOne(namespace + ".readPurchase", bid_id);
	}

	@Override
	public void registerPay(AucPayVO vo) throws Exception {
		sqlSession.insert(namespace + ".registerPay", vo);

	}

	@Override
	public int selectPay_id() throws Exception {

		if (sqlSession.selectOne(namespace + ".selectPay_id") != null) {
			return sqlSession.selectOne(namespace + ".selectPay_id");

		} else {
			return 0;
		}

	}

	@Override
	public void updatebid_status(int bid_id) throws Exception {
		sqlSession.update(namespace + ".updatebid_status", bid_id);

	}

	@Override
	public void updateSale_status(int sale_id) throws Exception {

		sqlSession.update(namespace + ".updateSale_status", sale_id);
	}

	@Override
	public void deleteBid(int bid_id) throws Exception {
		sqlSession.delete(namespace + ".deleteBid", bid_id);
	}

	@Override
	public void deleteBidding(int bidding_id) throws Exception {
		sqlSession.delete(namespace + ".deleteBidding", bidding_id);
	}

	@Override
	public void update_del_sale(Map<String, Integer> map) throws Exception {
		sqlSession.update(namespace + ".update_del_sale", map);
	}

	@Override
	public void updateAuction_status(int auction_id) throws Exception {
		
		sqlSession.update(namespace + ".updateAuction_status", auction_id);
	}

}
