package jungkosta.auction.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.AuctionVO;

@Repository
public class BidManageDAOImpl implements BidManageDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "jungkosta.main.mappers.auction.BidManageMapper";

	@Override
	public List<AuctionVO> endAuctionList() throws Exception {
		return sqlSession.selectList(namespace + ".endAuctionList");
	}

	@Override
	public void endAuction(int auction_id) throws Exception {
		sqlSession.update(namespace + ".endAuction", auction_id);
	}

	@Override
	public void updateSale_status(int sale_id) throws Exception {
		sqlSession.update(namespace + ".updateSale_status", sale_id);
	}

}
