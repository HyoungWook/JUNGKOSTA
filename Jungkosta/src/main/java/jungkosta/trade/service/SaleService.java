package jungkosta.trade.service;

import java.util.List;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.domain.SaleVO_tw;
import jungkosta.trade.domain.SubCategoryVO;

public interface SaleService {
	public List<SaleVO> listSale() throws Exception;
	
	public List<SaleVO> listSalesub(Integer subca_id)throws Exception;

	public SubCategoryVO searchSubCategory(int subca_id)throws Exception;

	public SaleVO searchSale(int sale_id)throws Exception;

	public String searchTotalCategory(int subca_id)throws Exception;
	
	public void updateSaleStatusFirst(SaleVO salevo)throws Exception;

	public void updateReadCount(int sale_id)throws Exception;

	public void updateDealCount(String email)throws Exception;
	
}