package jungkosta.trade.service;

import jungkosta.trade.domain.SaleVO;
import java.util.List;


public interface TradeService {
	
	public void regist(SaleVO saleVO) throws Exception;
	
	public List<SaleVO> listSale(Integer subca_id, String sort) throws Exception;


}
