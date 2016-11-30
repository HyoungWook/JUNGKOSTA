package jungkosta.main.persistence;

import java.util.List;

import jungkosta.trade.domain.SaleVO;

public interface MainDao {
	
	public List<SaleVO> hotItem();
	
	public List<SaleVO> newItem();
	
}
