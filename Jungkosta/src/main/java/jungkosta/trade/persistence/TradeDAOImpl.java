package jungkosta.trade.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.trade.domain.SaleVO;

@Repository
public class TradeDAOImpl implements TradeDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "jungkosta.mappers.trade.TradeMapper";

	//일반 판매 등록_ysi
	@Override
	public void insertSale(SaleVO sale) throws Exception {
		sqlSession.insert(namespace + ".insertSale", sale);
		
	}
	
	//sale_id select_ysi
	@Override
	public Integer selectS_id()throws Exception {
		if((sqlSession.selectOne(namespace+".selectS_id")) == null){
			return 0;
		}
		else{
			return sqlSession.selectOne(namespace+".selectS_id");
		}
	}

	//listSale_ysi
	@Override
	public List<SaleVO> listAll(Integer subca_id, String sort) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("subca_id", subca_id);
		paramMap.put("sort", sort);
		
		return sqlSession.selectList(namespace + ".listSale", paramMap);
	}

}
