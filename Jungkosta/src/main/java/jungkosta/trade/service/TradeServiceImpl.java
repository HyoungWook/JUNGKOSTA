package jungkosta.trade.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.persistence.TradeDAO;

@Service
public class TradeServiceImpl implements TradeService {
	
	@Inject
	private TradeDAO dao; 

	//일반판매물품 등록_ysi
	@Override
	public void regist(SaleVO saleVO) throws Exception {
		saleVO.setSale_id(dao.selectS_id() + 1);
		System.out.println("입력 SaleVO : " + saleVO);
		dao.insertSale(saleVO);
	}

	//일반판매물품list_ysi
	@Override
	public List<SaleVO> listSale(Integer subca_id) throws Exception {
		return dao.listAll(subca_id);
	}

}
