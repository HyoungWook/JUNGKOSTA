package jungkosta.auction.service;

import java.util.List;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.CategoryVO;

public interface AuctionService {

	public void register(AuctionVO auction) throws Exception;

	public int auction_id() throws Exception;

	public int sale_id() throws Exception;

	public AuctionVO read(int sale_id) throws Exception;

	public CategoryVO selectCategory(int subca_id) throws Exception;

	// start 현우 추가 부분
	public List<String> getThunbnail(int sale_id) throws Exception;
	// end 현우 추가 부분
}
