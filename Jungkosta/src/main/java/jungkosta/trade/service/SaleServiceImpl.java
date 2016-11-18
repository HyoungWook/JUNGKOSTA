package jungkosta.trade.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.trade.domain.SaleVO_tw;
import jungkosta.trade.domain.SubCategoryVO;
import jungkosta.trade.persistence.SaleDAO;

@Service
public class SaleServiceImpl implements SaleService {

	@Inject
	private SaleDAO saleDAO;
	
	
	@Override
	public int insertSale(SaleVO_tw saleVO) {
		return 0;
	}

	@Override
	public Integer selectS_id() throws Exception{
		return saleDAO.selectS_id();
	}

	@Override
	public List<SaleVO_tw> listSale() throws Exception {
		return saleDAO.listSale();
	}
	
	@Override
	public List<SaleVO_tw> listSalesub(Integer subca_id) throws Exception {
		return saleDAO.listSalesub(subca_id);
	}
	
	@Override
	public SubCategoryVO searchSubCategory(int subca_id) throws Exception {
		return saleDAO.searchSubCategory(subca_id);
	}

	@Override
	public SaleVO_tw searchSale(int sale_id) throws Exception {
		return saleDAO.searchSale(sale_id);
	}

	@Override
	public String searchTotalCategory(int subca_id) throws Exception {
		return saleDAO.searchTotalCategory(subca_id);
	}



}
