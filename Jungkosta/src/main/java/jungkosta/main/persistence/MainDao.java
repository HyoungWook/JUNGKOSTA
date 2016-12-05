package jungkosta.main.persistence;

import java.util.List;

import jungkosta.auction.domain.AuctionListVO;
import jungkosta.main.domain.CustomPreferVO;
import jungkosta.trade.domain.PurchaseListVO;
import jungkosta.trade.domain.SaleVO;

public interface MainDao {
	
	public List<SaleVO> hotItem();
	
	public List<SaleVO> newItem();
	
	public List<PurchaseListVO> purchaseList(String email);
	
	public List<AuctionListVO> auctionList(String email);
	//2016/12/03 추가 우성
	public void increasePrefer(CustomPreferVO prefer);
	
	public List<CustomPreferVO> allList();
	
	public List<SaleVO> similarPersonList(String email);
	
	public List<String> allEmail();
}
