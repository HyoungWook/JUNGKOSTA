package jungkosta.auction.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jungkosta.auction.domain.BidVO;
import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.persistence.AucPurDAO;
import jungkosta.auction.persistence.BiddingDAO;

@Service
public class AucPurServiceImpl implements AucPurService {

	@Inject
	private AucPurDAO dao;
	
	@Inject
	private BiddingDAO biddingDao;

	@Transactional
	@Override
	public void registerPurService(BidVO vo) throws Exception {
		vo.setBid_id(dao.selectBid_id() + 1);
		vo.setBid_status("입금 대기");
		dao.insertAuctionPurchase(vo);
		
		BiddingVO bidding = biddingDao.readBidding(vo.getBidding_id());
		
		dao.endAuction(bidding.getAuction_id());
	}

	@Override
	public int selectBid_id() throws Exception {

		return dao.selectBid_id();
	}

	@Override
	public BidVO readBid(int bidding_id) throws Exception {

		return dao.readBid(bidding_id);
	}

}
