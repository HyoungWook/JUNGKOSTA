package jungkosta.auction.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.BidVO;
import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.persistence.AucPurDAO;
import jungkosta.auction.persistence.AuctionDAO;
import jungkosta.auction.persistence.BiddingDAO;
import jungkosta.commons.util.AuctionCheck;

@Service
public class AucPurServiceImpl implements AucPurService {

	@Inject
	private AucPurDAO dao;

	@Inject
	private BiddingDAO biddingDao;

	@Inject
	private AuctionDAO auctionDao;

	@Transactional
	@Override
	public void registerPurService(BidVO vo, int sale_id) throws Exception {
		vo.setBid_id(dao.selectBid_id() + 1);
		vo.setBid_status("입금 대기");
		dao.insertAuctionPurchase(vo);

		BiddingVO bidding = biddingDao.readBidding(vo.getBidding_id());

		dao.updateSale_status(sale_id);
		dao.endAuction(bidding.getAuction_id());
		
		System.out.println("주문 완료");
	}

	@Override
	public int selectBid_id() throws Exception {

		return dao.selectBid_id();
	}

	@Override
	public BidVO readBid(int bidding_id) throws Exception {

		return dao.readBid(bidding_id);
	}

	@Transactional
	@Override
	public void cancelPurchase(int sale_id, int bidding_id) throws Exception {
		AuctionVO auction = auctionDao.read(sale_id);

		Map<String, Integer> map = new HashMap<>();

		map.put("sale_id", sale_id);
		map.put("auction_id", auction.getAuction_id());
		if (AuctionCheck.compareTime(auction.getAuction_end_date())) {
			dao.deleteBidding(bidding_id);
			dao.updateSale_cost(map);
		}
		
		System.out.println("주문 취소");
	}

}
