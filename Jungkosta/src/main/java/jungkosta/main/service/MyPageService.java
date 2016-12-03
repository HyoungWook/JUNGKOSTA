package jungkosta.main.service;

import java.util.List;

import jungkosta.main.domain.AucAndSaleVO;
import jungkosta.main.domain.AucPurVO;

public interface MyPageService {
	
	public List<AucPurVO> readMyAucPur(String email) throws Exception;
	
	public List<AucAndSaleVO> readMyAucSale(String email) throws Exception;
	
	public int bestBiddingCost(int auction_id) throws Exception;

}
