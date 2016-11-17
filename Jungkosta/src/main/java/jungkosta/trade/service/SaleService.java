package jungkosta.trade.service;

import java.util.List;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.domain.SubCategoryVO;

public interface SaleService {
	public int insertSale(SaleVO saleVO);

	public Integer selectS_id()throws Exception;

	public List<SaleVO> listSale() throws Exception;

	public SubCategoryVO searchSubCategory(int subca_id)throws Exception;

	public SaleVO searchSale(int sale_id)throws Exception;

	public String searchTotalCategory(int subca_id)throws Exception;

	public List<SaleVO> listSalesub(int subca_id)throws Exception;

}
