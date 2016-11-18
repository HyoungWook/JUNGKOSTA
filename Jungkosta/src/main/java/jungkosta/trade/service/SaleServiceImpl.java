package jungkosta.trade.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.domain.SubCategoryVO;
import jungkosta.trade.persistence.SaleDAO;

@Service
public class SaleServiceImpl implements SaleService {

	@Inject
	private SaleDAO saleDAO;
	
	
	@Override
	public int insertSale(SaleVO saleVO) {
		return 0;
	}

	@Override
	public Integer selectS_id() throws Exception{
		return saleDAO.selectS_id();
	}

	@Override
	public List<SaleVO> listSale() throws Exception {
		return saleDAO.listSale();
	}

	@Override
	public SubCategoryVO searchSubCategory(int subca_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleVO searchSale(int sale_id) throws Exception {
		return saleDAO.searchSale(sale_id);
	}

	@Override
	public String searchTotalCategory(int subca_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SaleVO> listSalesub(int subca_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
