package jungkosta.trade.persistence;

import java.util.List;

import jungkosta.trade.domain.ItemQAVO;
import jungkosta.trade.domain.SaleVO;


public interface TradeDAO {
	
	public void insertSale(SaleVO sale) throws Exception;
	
	public Integer selectS_id() throws Exception;
	
	public List<SaleVO> listAll(Integer subca_id, String sort) throws Exception;
	
	public void insertQA(ItemQAVO itemQa) throws Exception;

	public Integer selectQa_id() throws Exception;
	
	public List<ItemQAVO> listItemQa(Integer sale_id) throws Exception;

}
