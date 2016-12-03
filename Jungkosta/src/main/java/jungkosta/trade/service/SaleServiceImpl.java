package jungkosta.trade.service;

import java.util.ArrayList;
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
	public List<SaleVO> listSale() throws Exception {
		return saleDAO.listSale();
	}
	
	@Override
	public List<SaleVO> listSalesub(Integer subca_id) throws Exception {
		System.out.println("2");
		return saleDAO.listSalesub(subca_id);
	}
	
	@Override
	public SubCategoryVO searchSubCategory(int subca_id) throws Exception {
		return saleDAO.searchSubCategory(subca_id);
	}

	@Override
	public SaleVO searchSale(int sale_id) throws Exception {
		return saleDAO.searchSale(sale_id);
	}

	@Override
	public String searchTotalCategory(int subca_id) throws Exception {
		return saleDAO.searchTotalCategory(subca_id);
	}

	@Override
	public void updateSaleStatusFirst(SaleVO salevo) throws Exception {
		saleDAO.updateSaleStatusFirst(salevo);
	}

	@Override
	public void updateReadCount(int sale_id) throws Exception {
		saleDAO.updateReadCount(sale_id);
	}

	@Override
	public void updateDealCount(String email) throws Exception {
		saleDAO.updateDealCount(email);
	}

/*	@Override
	public List<String> getThunbnail(int sale_id) throws Exception {
		SaleVO salevo = saleDAO.searchSale(sale_id);
		
		List<String> list = new ArrayList<>();
		
		list.add(salevo.getItem_pic1());
		list.add(salevo.getItem_pic2());
		list.add(salevo.getItem_pic3());
		list.add(salevo.getItem_pic4());
		return list;
	}
*/
}
