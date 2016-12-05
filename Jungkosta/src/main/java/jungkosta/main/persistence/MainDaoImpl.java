package jungkosta.main.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.AuctionListVO;
import jungkosta.main.domain.CustomPreferVO;
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
		
		System.out.println("newItem : "+list.size());
		
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
	//2016/12/03 우성 수정
	@Override
	public void increasePrefer(CustomPreferVO prefer) {
		Integer customprefer_id = session.selectOne(namespace+".checkPrefer",prefer);
		
		if(customprefer_id == null){
			
			Integer max_id = session.selectOne(namespace+".maxNum");
			
			if(max_id == null){
				prefer.setCustomprefer_id(1);
			}else{
				prefer.setCustomprefer_id(max_id+1);
			}
			
			prefer.setView_num(1);
			session.insert(namespace+".insertPrefer",prefer);
			
		}else{
			
			session.update(namespace+".updatePrefer",customprefer_id);
			
		}
		
		
	}
	
	@Override
	public List<CustomPreferVO> allList() {

		List<CustomPreferVO> list = session.selectList(namespace+".allList");
		
		return list;
	}
	
	@Override
	public List<SaleVO> similarPersonList(String email) {
		
		List<CustomPreferVO> list1 = session.selectList(namespace+".similarPersonList1", email, new RowBounds(1, 8));
		List<SaleVO> list2 = new ArrayList<SaleVO>();
		
		for(int i = 0 ; i < list1.size() ; i++){
			
			SaleVO vo = session.selectOne(namespace+".similarPersonList2",list1.get(i).getSale_id());
			
			list2.add(vo);
			
		}
		
		return list2;
	}
	
	@Override
	public List<String> allEmail() {
		
		return session.selectList(namespace+".allEmail");
		
	}
}
