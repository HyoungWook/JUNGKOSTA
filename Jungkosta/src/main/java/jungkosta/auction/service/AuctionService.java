package jungkosta.auction.service;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.CategoryVO;

public interface AuctionService {


	public void register(AuctionVO auction)throws Exception;

	public int auction_id()throws Exception;
	
	public int sale_id()throws Exception;

	public AuctionVO read(int sale_id) throws Exception; 
	public CategoryVO selectCategory(int subca_id) throws Exception;
	
}
