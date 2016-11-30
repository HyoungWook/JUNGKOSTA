package jungkosta.auction.service;

import java.util.List;

import jungkosta.auction.domain.SellerReviewVO;

public interface AuctionReviewService {
	
	public void insertAuctionReview(SellerReviewVO vo)throws Exception;
	
	public int sellerReview_id()throws Exception;
	
	public List<SellerReviewVO> reviewList(String seller)throws Exception;
		
}
