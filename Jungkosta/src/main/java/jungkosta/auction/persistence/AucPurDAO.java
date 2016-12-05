package jungkosta.auction.persistence;

import java.util.Map;

import jungkosta.auction.domain.AucAndBidVO;
import jungkosta.auction.domain.BidVO;

public interface AucPurDAO {

	public void insertAuctionPurchase(BidVO vo) throws Exception;

	public int selectBid_id() throws Exception;

	public BidVO readBid(int bidding_id) throws Exception;
	
	public void endAuction(int auction_id) throws Exception;
	
	public void updateSale_status(int sale_id) throws Exception;
	
	public void deleteBidding(int bidding_id) throws Exception;
	
	public void updateSale_cost(Map<String, Integer> map) throws Exception;
	
	public AucAndBidVO readAucAndBid(int sale_id) throws Exception;

}
