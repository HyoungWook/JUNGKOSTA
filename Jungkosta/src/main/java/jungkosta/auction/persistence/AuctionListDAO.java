package jungkosta.auction.persistence;

import java.util.List;
import java.util.Map;

import jungkosta.auction.domain.AuctionVO;

public interface AuctionListDAO {
	
	public List<AuctionVO> auctionList(Map<String, String> map) throws Exception;
	
	public List<AuctionVO> auctionCate(Map<String, Object> map) throws Exception;

}
