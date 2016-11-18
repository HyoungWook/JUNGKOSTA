package jungkosta.trade.persistence;

import java.util.List;

import jungkosta.trade.domain.SaleVO_tw;
import jungkosta.trade.domain.SubCategoryVO;


public interface SaleDAO {
	public int insertSale(SaleVO_tw register)throws Exception;

	public Integer selectS_id()throws Exception;

	public List<SaleVO_tw> listSale()throws Exception;

	public SubCategoryVO searchSubCategory(Integer subca_id)throws Exception;

	public SaleVO_tw searchSale(int sale_id)throws Exception;

	public String searchTotalCategory(int subca_id)throws Exception;

	public List<SaleVO_tw> listSalesub(Integer subca_id)throws Exception;
}
