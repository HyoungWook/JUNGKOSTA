package jungkosta.auction.service;

import java.util.List;

import jungkosta.auction.domain.AuctionVO;

public interface AuctionListService {
	
	public List<AuctionVO> auctionList(String sort) throws Exception;
	
	
	public List<AuctionVO> auctionCate(String categoryList,String statusList)throws Exception;
}
