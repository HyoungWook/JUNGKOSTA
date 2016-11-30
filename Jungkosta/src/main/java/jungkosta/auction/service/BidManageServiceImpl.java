package jungkosta.auction.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.persistence.BidManageDAO;

@Service
public class BidManageServiceImpl implements BidManageService {

	@Inject
	private BidManageDAO dao;

	@Override
	public List<AuctionVO> endAuctionList() throws Exception {

		List<AuctionVO> list = dao.endAuctionList();

		if (list == null) {
			list = new ArrayList<>();
		}

		if (list.size() != 0) {
			System.out.println("경매 종료 상품 : " + list.size() + "개");
		}

		return list;
	}

	@Override
	public void endAuction(int auction_id) throws Exception {

		System.out.println(auction_id + " 경매 종료");

		dao.endAuction(auction_id);
	}

	@Override
	public void updateSale_status(int sale_id) throws Exception {

		System.out.println(sale_id + " 거래 상태 'update 거래중' ");

		dao.updateSale_status(sale_id);
	}

}
