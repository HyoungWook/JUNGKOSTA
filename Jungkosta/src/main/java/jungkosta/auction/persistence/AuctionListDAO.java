package jungkosta.auction.persistence;

import java.util.List;

import jungkosta.auction.domain.AuctionVO;

public interface AuctionListDAO {
	
	public List<AuctionVO> auctionList() throws Exception;

}
