package jungkosta.auction.service;

import java.util.List;

import jungkosta.auction.domain.AuctionCriteria;
import jungkosta.auction.domain.AuctionVO;

public interface AuctionListService {
	
	public List<AuctionVO> auctionList(AuctionCriteria cri) throws Exception;
	
	

}
