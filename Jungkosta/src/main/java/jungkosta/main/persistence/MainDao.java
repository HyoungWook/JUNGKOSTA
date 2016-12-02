package jungkosta.main.persistence;

import java.util.List;

import jungkosta.auction.domain.AuctionListVO;
import jungkosta.trade.domain.PurchaseListVO;
import jungkosta.trade.domain.SaleVO;

public interface MainDao {
	
	public List<SaleVO> hotItem();
	
	public List<SaleVO> newItem();
	
	public List<PurchaseListVO> purchaseList(String email);
	
	public List<AuctionListVO> auctionList(String email);
}
