package jungkosta.trade.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jungkosta.trade.domain.PurchaseVO;
import jungkosta.trade.persistence.PurchaseDAO;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Inject
	private PurchaseDAO purchaseDAO;
	
	@Override
	public void insertPurchase(PurchaseVO purchase) throws Exception {
		purchase.setPurchase_id(purchaseDAO.selectP_id()+1);
		System.out.println(purchase.getPurchase_id());
		purchaseDAO.insertPurchase(purchase);
	}

	@Transactional
	@Override
	public void insertPaymentTx(PurchaseVO purchase) throws Exception {
		
		
	}

}
