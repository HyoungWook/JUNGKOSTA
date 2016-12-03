package jungkosta.main.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.AuctionListVO;
import jungkosta.main.controller.BoardController;
import jungkosta.trade.domain.PurchaseListVO;
import jungkosta.trade.domain.SaleVO;

@Repository
public class MainDaoImpl implements MainDao {

	
	@Inject
	private SqlSession session;
	
	private String namespace = "jungkosta.mappers.main.MainMapper";
	
	@Override
	public List<SaleVO> hotItem() {
		
		List<SaleVO> list = session.selectList(namespace+".hotItem",null,new RowBounds(1, 16));
		
		return list;
	}
	
	
	@Override
	public List<SaleVO> newItem() {
		
		List<SaleVO> list = session.selectList(namespace+".newItem",null,new RowBounds(0, 16));
		
		return list;
	}
	
	@Override
	public List<PurchaseListVO> purchaseList(String email) {
		
		List<PurchaseListVO> list = session.selectList(namespace+".purchaseList",email);
		return list;
	}
	
	@Override
	public List<AuctionListVO> auctionList(String email) {

		List<AuctionListVO> list = session.selectList(namespace+".auctionList",email);
		
		return list;
	}
}
