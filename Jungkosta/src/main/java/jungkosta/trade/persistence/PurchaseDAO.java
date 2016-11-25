package jungkosta.trade.persistence;

import jungkosta.trade.domain.PurchaseVO;


	public interface PurchaseDAO {
		
	public Integer selectP_id() throws Exception;

	public void insertPurchase(PurchaseVO purchase)throws Exception;
	
	
}
