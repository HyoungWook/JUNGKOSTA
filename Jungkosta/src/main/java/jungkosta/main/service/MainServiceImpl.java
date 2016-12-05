package jungkosta.main.service;

import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jungkosta.auction.domain.AuctionListVO;
import jungkosta.commons.util.PreferCustomTool;
import jungkosta.main.domain.CustomPreferVO;
import jungkosta.main.persistence.MainDao;
import jungkosta.trade.domain.PurchaseListVO;
import jungkosta.trade.domain.SaleVO;
import net.sf.json.JSONArray;

@Service
public class MainServiceImpl implements MainService {
	
	@Inject
	private MainDao dao;
	
	@Override
	public String hotItem(){
		
		String json = null;
		String jsonArray = null;
		
		List<SaleVO> list = dao.hotItem();
		
		JSONArray array = JSONArray.fromObject(list);
		
		jsonArray = array.toString();
	
		try {
			json = URLEncoder.encode(jsonArray,"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
		
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
	
	//2016/12/03 우성 추가
	@Override
	public List<SaleVO> preferList(String email) {
		
		List<CustomPreferVO> list = dao.allList();
		
		PreferCustomTool tool = PreferCustomTool.getInstance();
		
		Set<String> userSet = new HashSet<String>();
		Set<String> itemSet = new HashSet<String>();
		
		List<String> userList = dao.allEmail();
		
		for(int i = 0 ; i < list.size() ; i++){
			
			itemSet.add(((Integer)list.get(i).getSale_id()).toString());
			
		}
		
		
		String [] user = new String[userList.size()];
		
		String [] item = tool.makeArr(itemSet);
		
		for(int i = 0 ; i < userList.size() ; i++){
			user[i] = userList.get(i);
		}
		
		
		Integer userIndex = tool.searchIndex(user, email);
		
		Integer [][] i_Matrix = tool.makeMatrix(user.length, itemSet.size());
		
		i_Matrix = tool.setMatrix(i_Matrix, user, item, list);
		
		Double [][] d_Matrix = tool.Normalization(i_Matrix, user.length, itemSet.size());
		
		Double [] preferValue = tool.calculatePrefer(d_Matrix,user.length,userIndex);
		
		Integer similarFindIndex = tool.findSimilarPerson(preferValue, userIndex);
		
		String similarPerson = null;
		
		if(similarFindIndex == null){
			similarPerson = user[userIndex];
		}else{
			similarPerson = user[similarFindIndex];
			
		}
		
		List<SaleVO> similarPersonList = dao.similarPersonList(similarPerson);
		
		return similarPersonList;
	}
}
