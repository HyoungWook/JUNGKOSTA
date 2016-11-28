package jungkosta.auction.persistence;

import java.util.List;

import jungkosta.auction.domain.SellerReviewVO;

public interface AuctionReviewDAO {
	
	public void insertSellerReview(SellerReviewVO vo) throws Exception;
	
	public int selectReview_id() throws Exception;
	
	public List<SellerReviewVO>sellerReviewList(String seller) throws Exception;
	
}
