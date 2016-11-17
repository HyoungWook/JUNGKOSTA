package jungkosta.auction.service;

import javax.inject.Inject;

import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.persistence.BiddingDAO;

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

}
