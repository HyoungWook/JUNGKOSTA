package jungkosta.auction.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.persistence.AuctionDAO;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Inject
	private AuctionDAO dao;
	
	@Override
	public void register(AuctionVO auction) throws Exception {
		
		dao.insertAuction(auction);
	}

}
