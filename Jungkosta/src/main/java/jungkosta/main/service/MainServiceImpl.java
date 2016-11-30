package jungkosta.main.service;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jungkosta.main.persistence.MainDao;
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
		
		System.out.println("워우 : "+list.size());
		String json = null;
		
		JSONArray jsonArray =  JSONArray.fromObject(list);
		
		json = jsonArray.toString();
		System.out.println(json);
		try {
			json = URLEncoder.encode(json, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
		
	}
}
