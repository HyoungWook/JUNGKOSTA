package jungkosta.auction.service;

import java.util.List;

import jungkosta.auction.domain.AuctionVO;

public interface BidManageService {

	public List<AuctionVO> endAuctionList() throws Exception;

	public void endAuction(int auction_id) throws Exception;

	public void updateSale_status(int sale_id) throws Exception;

}
