package jungkosta.trade.persistence;

import jungkosta.trade.domain.SaleVO_tw;

public interface TradeDAO {
	
	public void insertSale(SaleVO_tw sale) throws Exception;

}
