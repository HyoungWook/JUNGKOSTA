package jungkosta.main.persistence;

import java.util.List;

import jungkosta.main.domain.AucAndSaleVO;
import jungkosta.main.domain.AucPurVO;

public interface MyPageDAO {
	
	public List<AucPurVO> readMyAucPur(String email) throws Exception;

	public List<AucAndSaleVO> readMyAucSale(String email) throws Exception;
	
	public int bestBiddingCost(int auction_id) throws Exception;
}
