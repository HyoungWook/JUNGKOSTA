package jungkosta.trade.persistence;

import jungkosta.trade.domain.Seller_ReviewVO;

public interface Seller_ReviewDAO {

	public Integer selectSeller_id() throws Exception;

	public void insertPurchase(Seller_ReviewVO sellerReview)throws Exception;
	
}
