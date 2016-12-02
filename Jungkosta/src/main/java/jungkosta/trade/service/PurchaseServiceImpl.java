package jungkosta.trade.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jungkosta.main.domain.MemberVO;
import jungkosta.trade.domain.PurchaseVO;
import jungkosta.trade.persistence.PurchaseDAO;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Inject
	private PurchaseDAO purchaseDAO;
	
	
	@Override
	public void insertPurchase(PurchaseVO purchase) throws Exception {
		purchase.setPurchase_id(purchaseDAO.selectP_id()+1);
		purchaseDAO.insertPurchase(purchase);
	}

	@Override
	public PurchaseVO selectPurchase(int purchase_id) throws Exception {
		return purchaseDAO.selectPurchase(purchase_id);
	}

	@Override
	public void updatePurchase(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.updatePurchase(purchaseVO);
	}

	@Override
	public void deletePurchase(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.deletePurchase(purchaseVO);	
	}

	@Override
	public void usePoint(MemberVO member) throws Exception {
		purchaseDAO.usePoint(member);
		
	}

	@Override
	public void backPoint(MemberVO member) throws Exception {
		purchaseDAO.backPoint(member);
		
	}
	
	


}
