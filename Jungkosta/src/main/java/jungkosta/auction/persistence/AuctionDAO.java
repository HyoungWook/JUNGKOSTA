package jungkosta.auction.persistence;

import java.util.List;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.CategoryVO;

public interface AuctionDAO {

	public void insertAuction(AuctionVO auction) throws Exception;

	public void insertSale(AuctionVO auction) throws Exception;

	public Integer selectAuction_id() throws Exception;

	public Integer selectSale_id() throws Exception;

	public List<AuctionVO> listAuction() throws Exception;

	// public List<AuctionVO> listAuctionEnd(Sort sort)throws Exception;
	public AuctionVO selectSale(int sale_id) throws Exception;

	public AuctionVO selectAuction(int auction_id) throws Exception;

	// start 현우 추가 부분
	public AuctionVO read(int sale_id) throws Exception;
	public CategoryVO selectCategory(int subca_id) throws Exception;
	// end 현우 추가 부분
}
