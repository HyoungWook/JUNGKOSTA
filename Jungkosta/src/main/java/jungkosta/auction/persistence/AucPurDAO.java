package jungkosta.auction.persistence;

import jungkosta.auction.domain.BidVO;

public interface AucPurDAO {

	public void insertAuctionPurchase(BidVO vo) throws Exception;

	public int selectBid_id() throws Exception;

	public BidVO readBid(int bid_id) throws Exception;

}
