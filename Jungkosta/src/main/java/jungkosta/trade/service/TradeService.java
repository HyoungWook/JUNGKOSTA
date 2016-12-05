package jungkosta.trade.service;

import jungkosta.trade.domain.ItemQAVO;
import jungkosta.trade.domain.SaleVO;
import java.util.List;

public interface TradeService {
	
	public void regist(SaleVO saleVO) throws Exception;
	
	public List<SaleVO> listSale(Integer subca_id, String sort) throws Exception;

	public void insertQA(ItemQAVO itemQa) throws Exception;
	
	public List<ItemQAVO> listItemQa(Integer sale_id) throws Exception;

}
