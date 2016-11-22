package jungkosta.auction.persistence;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.CategoryVO;

public interface AuctionDAO {

	public void insertAuction(AuctionVO auction) throws Exception;

	public void insertSale(AuctionVO auction) throws Exception;

	public int selectAuction_id() throws Exception;

	public int selectSale_id() throws Exception;

	public AuctionVO read(int sale_id) throws Exception;

	public CategoryVO selectCategory(int subca_id) throws Exception;

	public void updateItemCost(AuctionVO auction) throws Exception;

	public void updateAuctionSt(AuctionVO auction) throws Exception;
}
