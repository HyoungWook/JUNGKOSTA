package jungkosta.auction.persistence;

import java.util.List;

import jungkosta.auction.domain.BiddingVO;

public interface BiddingDAO {

	public void registerBid(BiddingVO vo) throws Exception;

	public int selectBidding_id() throws Exception;

	public int countBidding(int auction_id) throws Exception;

	public BiddingVO readBidding(int bidding_id) throws Exception;
	
	public List<BiddingVO> biddingList(int auction_id) throws Exception;
	
	public BiddingVO bid_person(int auction_id) throws Exception;
}
