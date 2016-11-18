package jungkosta.trade.persistence;

import jungkosta.trade.domain.SaleVO;

public interface TradeDAO {
	
	public void insertSale(SaleVO sale) throws Exception;
	
	public int selectS_id() throws Exception;

}
