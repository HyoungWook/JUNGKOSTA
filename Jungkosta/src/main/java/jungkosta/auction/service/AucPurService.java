package jungkosta.auction.service;

import jungkosta.auction.domain.BidVO;

public interface AucPurService {

	public void registerPurService(BidVO vo) throws Exception;

	public int selectBid_id() throws Exception;

	public BidVO readBid(int bidding_id) throws Exception;

}
