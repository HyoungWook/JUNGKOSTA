package jungkosta.trade.persistence;

import java.util.List;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.domain.SubCategoryVO;


public interface SaleDAO {
	public List<SaleVO> listSale()throws Exception;

	public SubCategoryVO searchSubCategory(Integer subca_id)throws Exception;

	public SaleVO searchSale(int sale_id)throws Exception;

	public String searchTotalCategory(int subca_id)throws Exception;

	public List<SaleVO> listSalesub(Integer subca_id)throws Exception;
	
	public void updateSaleStatusFirst(SaleVO salevo)throws Exception;

	public void updateReadCount(int sale_id)throws Exception;
	
	public void updateDealCount(String email)throws Exception;
}
