package jungkosta.trade.persistence;

import java.util.List;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.domain.SubCategoryVO;


public interface SaleDAO {
	public int insertSale(SaleVO register)throws Exception;

	public Integer selectS_id()throws Exception;

	public List<SaleVO> listSale()throws Exception;

	public SubCategoryVO searchSubCategory(int subca_id)throws Exception;

	public SaleVO searchSale(int sale_id)throws Exception;

	public String searchTotalCategory(int subca_id)throws Exception;

	public List<SaleVO> listSalesub(int subca_id)throws Exception;
}
