package jungkosta.auction.persistence;

import java.util.List;

import jungkosta.auction.domain.AuctionVO;

public interface AuctionDAO {
	
	public void insertAuction(AuctionVO auction) throws Exception;
	public void insertSale(AuctionVO auction)throws Exception;
	public int selectAuction_id()throws Exception;
	public int selectSale_id()throws Exception;
	public List<AuctionVO> listAuction()throws Exception;
	//public List<AuctionVO> listAuctionEnd(Sort sort)throws Exception;
	public AuctionVO selectSale(int sale_id)throws Exception;
	public AuctionVO selectAuction(int auction_id)throws Exception;
}
