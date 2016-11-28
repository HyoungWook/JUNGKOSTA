package jungkosta.auction.persistence;

import java.util.List;

import jungkosta.auction.domain.AuctionVO;

public interface BidManageDAO {

	public List<AuctionVO> endAuctionList() throws Exception;

	public void endAuction(int auction_id) throws Exception;

	public void updateSale_status(int sale_id) throws Exception;
}
