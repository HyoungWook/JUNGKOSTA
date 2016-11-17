package jungkosta.auction.persistence;

import jungkosta.auction.domain.BiddingVO;

public interface BiddingDAO {
	
	public void registerBid(BiddingVO vo) throws Exception;
	public int selectBidding_id() throws Exception;
	public int countBidding(int auction_id) throws Exception;

}
