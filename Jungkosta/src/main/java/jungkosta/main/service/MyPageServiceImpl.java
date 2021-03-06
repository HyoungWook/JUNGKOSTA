package jungkosta.main.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.main.domain.AucAndSaleVO;
import jungkosta.main.domain.AucPurVO;
import jungkosta.main.domain.TradePurVO;
import jungkosta.main.persistence.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Inject
	private MyPageDAO dao;

	@Override
	public List<AucPurVO> readMyAucPur(String email) throws Exception {

		return dao.readMyAucPur(email);
	}

	@Override
	public List<AucAndSaleVO> readMyAucSale(String email) throws Exception {
		return dao.readMyAucSale(email);
	}

	@Override
	public int bestBiddingCost(int auction_id) throws Exception {
		return dao.bestBiddingCost(auction_id);
	}

	@Override
	public List<TradePurVO> readMyTradePur(String email) throws Exception {
		return dao.readMyTradePur(email);
	}

}
