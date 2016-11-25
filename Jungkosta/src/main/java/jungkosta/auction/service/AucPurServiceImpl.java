package jungkosta.auction.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.auction.domain.BidVO;
import jungkosta.auction.persistence.AucPurDAO;

@Service
public class AucPurServiceImpl implements AucPurService {

	@Inject
	private AucPurDAO dao;

	@Override
	public void registerPurService(BidVO vo) throws Exception {
		vo.setBid_id(dao.selectBid_id() + 1);
		vo.setBid_status("입금 대기");

		dao.insertAuctionPurchase(vo);
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
