package jungkosta.auction.service;

import jungkosta.auction.domain.BiddingVO;

public interface BiddingService {
	
	public void registerBid(BiddingVO vo) throws Exception;
	public int selectBidding_id() throws Exception;

}
