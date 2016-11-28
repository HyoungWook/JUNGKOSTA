package jungkosta.auction.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jungkosta.auction.domain.AucAndBidVO;
import jungkosta.auction.domain.AucPayVO;
import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.persistence.AucPayDAO;
import jungkosta.auction.persistence.AuctionDAO;
import jungkosta.commons.util.AuctionCheck;

@Service
public class AucPayServiceImpl implements AucPayService {

	@Inject
	private AucPayDAO dao;

	@Inject
	private AuctionDAO auctionDao;

	@Override
	public AucAndBidVO readPurchase(int bid_id) throws Exception {

		return dao.readPurchase(bid_id);
	}

	@Transactional
	@Override
	public void registerPay(AucPayVO vo, int sale_id) throws Exception {

		vo.setAuctionpay_id(selectPay_id() + 1);
		dao.registerPay(vo);
		dao.updatebid_status(vo.getBid_id());
		dao.updateSale_status(sale_id);
	}

	@Override
	public int selectPay_id() throws Exception {
		return dao.selectPay_id();
	}

	@Override
	public void updateBid_status(int bid_id) throws Exception {
		dao.updatebid_status(bid_id);

	}

	@Override
	public void updateSale_status(int sale_id) throws Exception {
		dao.updateSale_status(sale_id);
	}

	@Transactional
	@Override
	public void cancelPay(AucAndBidVO vo) throws Exception {
		System.out.println("결제 취소");
		Map<String, Integer> map = new HashMap<>();

		map.put("auction_id", vo.getAuction_id());
		map.put("sale_id", vo.getSale_id());

		dao.deleteBid(vo.getBid_id());

		AuctionVO auction = auctionDao.read(vo.getAuction_id());

		if (AuctionCheck.compareTime(auction.getAuction_end_date())) {
			dao.deleteBidding(vo.getBidding_id());
			dao.updateAuction_status(vo.getAuction_id());
			dao.update_del_sale(map);
		}

	}

}
