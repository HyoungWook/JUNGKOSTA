package jungkosta.trade.service;

import java.util.List;

import jungkosta.trade.domain.SaleVO_tw;
import jungkosta.trade.domain.SubCategoryVO;

public interface SaleService {
	public int insertSale(SaleVO_tw saleVO);

	public Integer selectS_id()throws Exception;

	public List<SaleVO_tw> listSale() throws Exception;
	
	public List<SaleVO_tw> listSalesub(Integer subca_id)throws Exception;

	public SubCategoryVO searchSubCategory(int subca_id)throws Exception;

	public SaleVO_tw searchSale(int sale_id)throws Exception;

	public String searchTotalCategory(int subca_id)throws Exception;



	
}