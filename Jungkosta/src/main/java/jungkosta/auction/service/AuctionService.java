package jungkosta.auction.service;

import jungkosta.auction.domain.AuctionVO;

public interface AuctionService {


	public void register(AuctionVO auction)throws Exception;

	public int auction_id()throws Exception;
	
	public int sale_id()throws Exception;
}
