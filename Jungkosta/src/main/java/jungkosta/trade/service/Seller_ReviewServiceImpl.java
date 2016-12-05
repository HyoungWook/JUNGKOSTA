package jungkosta.trade.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.trade.domain.Seller_ReviewVO;
import jungkosta.trade.persistence.Seller_ReviewDAO;

@Service
public class Seller_ReviewServiceImpl implements Seller_ReviewService {

	@Inject
	private Seller_ReviewDAO sellerReviewDAO;
	
	@Override
	public void insertPurchase(Seller_ReviewVO sellerReview) throws Exception {
		sellerReview.setSeller_review_id(sellerReviewDAO.selectSeller_id()+1);
		sellerReviewDAO.insertPurchase(sellerReview);
	}

}
