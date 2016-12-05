package jungkosta.trade.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.main.domain.MemberVO;
import jungkosta.trade.domain.PurchaseVO;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "jungkosta.mappers.trade.TradePurchaseMapper";
	
	@Override
	public Integer selectP_id() throws Exception {
		if ((sqlSession.selectOne(namespace + ".selectP_id")) == null) {
			return 0;
		} else {
			return sqlSession.selectOne(namespace + ".selectP_id");
		}
	}

	@Override
	public void insertPurchase(PurchaseVO purchase) throws Exception {
		sqlSession.insert(namespace+".insertPurchase", purchase);
	}

	@Override
	public PurchaseVO selectPurchase(int purchase_id) throws Exception {
		return sqlSession.selectOne(namespace+".selectPurchase", purchase_id);
	}

	@Override
	public void updatePurchase(PurchaseVO purchaseVO) throws Exception {
		sqlSession.update(namespace+".updatePurchase", purchaseVO);
	}

	@Override
	public void deletePurchase(PurchaseVO purchaseVO) throws Exception {
		sqlSession.delete(namespace+".deletePurchase", purchaseVO);
		
	}

	@Override
	public void usePoint(MemberVO member) throws Exception {
		sqlSession.update(namespace+".usePoint", member);
		
	}

	@Override
	public void backPoint(MemberVO member) throws Exception {
		sqlSession.update(namespace+".backPoint", member);
		
	}

	@Override
	public PurchaseVO findPurchase(int sale_id) throws Exception {
		return sqlSession.selectOne(namespace+".findPurchase", sale_id);
	}


}
