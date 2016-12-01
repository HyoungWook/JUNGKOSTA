package jungkosta.auction.persistence;

import java.util.List;
import java.util.Map;

import jungkosta.auction.domain.AuctionCriteria;
import jungkosta.auction.domain.AuctionVO;

public interface AuctionListDAO {
	
	public List<AuctionVO> auctionList(AuctionCriteria cri) throws Exception;

}
