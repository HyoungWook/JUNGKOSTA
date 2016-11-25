package jungkosta.auction.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.CategoryVO;
import jungkosta.auction.persistence.AuctionDAO;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Inject
	private AuctionDAO dao;
	
	@Transactional
	@Override
	public void register(AuctionVO auction) throws Exception {
		
		dao.insertSale(auction);
		dao.insertAuction(auction);
		
	}

	@Override
	public int auction_id() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAuction_id();
	}

	@Override
	public int sale_id() throws Exception {

		return dao.selectSale_id();
	}
	
	@Override
	public AuctionVO read(int sale_id) throws Exception {
		return dao.read(sale_id);
	}

	@Override
	public CategoryVO selectCategory(int subca_id) throws Exception {

		return dao.selectCategory(subca_id);
	}

	@Override
	public void updateDetail(AuctionVO auction) throws Exception {
		dao.updateItemCost(auction);
	}


		// start 현우 추가 부분
	@Override
	public List<String> getThunbnail(int sale_id) throws Exception {
		AuctionVO vo = dao.read(sale_id);

		List<String> list = new ArrayList<>();

		list.add(vo.getItem_pic1());
		list.add(vo.getItem_pic2());
		list.add(vo.getItem_pic3());
		list.add(vo.getItem_pic4());

		return list;
	}
	// end 현우 추가 부분
	
}
