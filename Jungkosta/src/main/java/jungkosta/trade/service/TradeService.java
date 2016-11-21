package jungkosta.trade.service;

import java.util.List;

import jungkosta.trade.domain.SaleVO;

public interface TradeService {
	
	public void regist(SaleVO saleVO) throws Exception;
	
	public List<SaleVO> listSale(Integer subca_id) throws Exception;

}
