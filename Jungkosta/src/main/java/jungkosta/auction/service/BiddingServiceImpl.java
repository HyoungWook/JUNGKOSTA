package jungkosta.auction.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.persistence.BiddingDAO;

@Service
public class BiddingServiceImpl implements BiddingService {

	@Inject
	private BiddingDAO dao;

	@Override
	public void registerBid(BiddingVO vo) throws Exception {

		vo.setBidding_id(selectBidding_id() + 1);
		dao.registerBid(vo);

	}

	@Override
	public int selectBidding_id() throws Exception {

		return dao.selectBidding_id();
	}

	@Override
	public int countBidding(int auction_id) throws Exception {
		return dao.countBidding(auction_id);
	}

	@Override
	public BiddingVO readBidding(int bidding_id) throws Exception {
		return dao.readBidding(bidding_id);
	}

	@Override
	public List<BiddingVO> biddingList(int auction_id) throws Exception {
		return dao.biddingList(auction_id);
	}

	@Override
	public BiddingVO bid_person(int auction_id) throws Exception {
		return dao.bid_person(auction_id);
	}

}
