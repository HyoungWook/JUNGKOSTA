package jungkosta.auction.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.CategoryVO;
import jungkosta.auction.persistence.AuctionDAO;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Inject
	private AuctionDAO dao;

	@Override
	public void register(AuctionVO auction) throws Exception {

		dao.insertAuction(auction);
	}

	// start add by 현우
	@Override
	public AuctionVO read(int sale_id) throws Exception {
		return dao.read(sale_id);
	}

	@Override
	public CategoryVO selectCategory(int subca_id) throws Exception {

		return dao.selectCategory(subca_id);
	}
	// end add by 현우
}
