package jungkosta.auction.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.auction.domain.SellerReviewVO;
import jungkosta.auction.persistence.AuctionReviewDAO;

@Service
public class AuctionReviewServiceImpl implements AuctionReviewService {

	@Inject
	private AuctionReviewDAO dao;
	
	@Override
	public void insertAuctionReview(SellerReviewVO vo) throws Exception {
		
		dao.insertSellerReview(vo);	
	}

	@Override
	public int sellerReview_id() throws Exception {
		return dao.selectReview_id();
	}

	@Override
	public List<SellerReviewVO> reviewList(String seller) throws Exception {
		return dao.sellerReviewList(seller);
	}

}
