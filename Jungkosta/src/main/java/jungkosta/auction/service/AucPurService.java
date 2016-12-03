package jungkosta.auction.service;

import jungkosta.auction.domain.AucAndBidVO;
import jungkosta.auction.domain.BidVO;

public interface AucPurService {

	public void registerPurService(BidVO vo, int sale_id) throws Exception;

	public int selectBid_id() throws Exception;

	public BidVO readBid(int bidding_id) throws Exception;
	
	public void cancelPurchase(int sale_id, int bidding_id) throws Exception;
	
	public AucAndBidVO readAucAndBid(int sale_id) throws Exception;

}
