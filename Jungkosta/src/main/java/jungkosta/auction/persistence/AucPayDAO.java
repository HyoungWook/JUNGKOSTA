package jungkosta.auction.persistence;

import java.util.Map;

import jungkosta.auction.domain.AucAndBidVO;
import jungkosta.auction.domain.AucPayVO;

public interface AucPayDAO {

	public AucAndBidVO readPurchase(int bid_id) throws Exception;

	public void registerPay(AucPayVO vo) throws Exception;

	public int selectPay_id() throws Exception;

	public void updatebid_status(int bid_id) throws Exception;
	
	public void updateSale_status(int sale_id) throws Exception;
	
	public void deleteBid(int bid_id) throws Exception;
	
	public void deleteBidding(int bidding_id) throws Exception;
	
	public void update_del_sale(Map<String, Integer> map) throws Exception;
	
	public void updateAuction_status(int auction_id) throws Exception;
	
	public void plusPoint(Map<String, Object> map) throws Exception;

}
