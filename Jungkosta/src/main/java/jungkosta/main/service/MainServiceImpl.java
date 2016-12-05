package jungkosta.main.service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jungkosta.auction.domain.AuctionListVO;
import jungkosta.main.persistence.MainDao;
import jungkosta.trade.domain.PurchaseListVO;
import jungkosta.trade.domain.SaleVO;
import net.sf.json.JSONArray;

@Service
public class MainServiceImpl implements MainService {
	
	@Inject
	private MainDao dao;
	
	@Override
	public void hotItem(Model model) {
		
	}
	
	@Override
	public String newItem() {
		
		List<SaleVO> list = dao.newItem();
		
		String json = null;
		
		JSONArray jsonArray =  JSONArray.fromObject(list);
		
		json = jsonArray.toString();

		try {
			json = URLEncoder.encode(json, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
		
	}
	
	@Override
	public List<PurchaseListVO> paymentList(HttpSession session) {
		
		String email = (String)session.getAttribute("email");
		
		List<PurchaseListVO> list = dao.purchaseList(email);
		
		String pic = "";
		
		for(int i = 0 ; i < list.size() ; i++){
			
			pic = list.get(i).getItem_pic1();
			
			pic = "/Jungkosta/auction/displayFile?fileName="+pic;
			
			list.get(i).setItem_pic1(pic);
		}
		
		return list;
	}
	
	@Override
	public List<AuctionListVO> auctionList(HttpSession session) {

		String email = (String)session.getAttribute("email");
		
		List<AuctionListVO> list = dao.auctionList(email);
		
		String pic = "";
		
		for(int i = 0 ; i < list.size() ; i++){
			
			pic = list.get(i).getItem_pic1();
			
			
			pic = "/Jungkosta/auction/displayFile?fileName="+pic;
			
			list.get(i).setItem_pic1(pic);
			
		}
		
		return list;
	}
}
