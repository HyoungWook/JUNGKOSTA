package jungkosta.trade.persistence;

import jungkosta.main.domain.MemberVO;
import jungkosta.trade.domain.PurchaseVO;


	public interface PurchaseDAO {
		
	public Integer selectP_id() throws Exception;

	public void insertPurchase(PurchaseVO purchase)throws Exception;
	
	public PurchaseVO selectPurchase(int purchase_id)throws Exception;

	public void updatePurchase(PurchaseVO purchaseVO)throws Exception;

	public void deletePurchase(PurchaseVO purchaseVO)throws Exception;
	
	public void usePoint(MemberVO member)throws Exception;
	
	public void backPoint(MemberVO member)throws Exception;
}
