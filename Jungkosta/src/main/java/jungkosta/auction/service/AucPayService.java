package jungkosta.auction.service;

import jungkosta.auction.domain.AucAndBidVO;
import jungkosta.auction.domain.AucPayVO;

public interface AucPayService {

	public AucAndBidVO readPurchase(int bid_id) throws Exception;

	public void registerPay(AucPayVO vo, int sale_id, String email) throws Exception;

	public int selectPay_id() throws Exception;

	public void updateBid_status(int bid_id) throws Exception;

	public void updateSale_status(int sale_id) throws Exception;
	
	public void cancelPay(AucAndBidVO vo) throws Exception;
	
	public void plusPoint(String email, int point) throws Exception;

}
