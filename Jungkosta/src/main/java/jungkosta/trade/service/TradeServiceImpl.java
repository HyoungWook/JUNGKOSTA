package jungkosta.trade.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.trade.domain.SaleVO_tw;
import jungkosta.trade.persistence.TradeDAO;

@Service
public class TradeServiceImpl implements TradeService {
	
	@Inject
	private TradeDAO dao; 

	@Override
	public void regist(SaleVO_tw sale) throws Exception {
			dao.insertSale(sale);
	}

}
