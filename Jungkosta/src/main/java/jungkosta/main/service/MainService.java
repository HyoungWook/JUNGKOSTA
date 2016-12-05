package jungkosta.main.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import jungkosta.auction.domain.AuctionListVO;
import jungkosta.trade.domain.PurchaseListVO;
import jungkosta.trade.domain.SaleVO;

public interface MainService {
	
	public void hotItem(Model model);
	
	public String newItem();
	
	public List<PurchaseListVO> paymentList(HttpSession session);
	
	public List<AuctionListVO> auctionList(HttpSession session);
}
