package jungkosta.auction.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.CategoryVO;
import jungkosta.auction.persistence.AuctionDAO;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Inject
	private AuctionDAO dao;
	
	@Transactional
	@Override
	public void register(AuctionVO auction) throws Exception {
		
		dao.insertSale(auction);
		dao.insertAuction(auction);
		
	}

	@Override
	public int auction_id() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAuction_id();
	}

	@Override
	public int sale_id() throws Exception {

		return dao.selectSale_id();
	}
	
	@Override
	public AuctionVO read(int sale_id) throws Exception {
		return dao.read(sale_id);
	}

	@Override
	public CategoryVO selectCategory(int subca_id) throws Exception {

		return dao.selectCategory(subca_id);
	}

}
