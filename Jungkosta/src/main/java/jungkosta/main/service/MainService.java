package jungkosta.main.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import jungkosta.trade.domain.SaleVO;

public interface MainService {
	
	public void hotItem(Model model);
	
	public String newItem();
}
