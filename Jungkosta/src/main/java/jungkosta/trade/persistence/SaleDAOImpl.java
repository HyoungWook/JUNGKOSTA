package jungkosta.trade.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.domain.SubCategoryVO;

@Repository
public class SaleDAOImpl implements SaleDAO {

	@Inject
	private SqlSession sqlSession; 
	
	private static final String namespace="jungkosta.mappers.trade.TradeMapper";

	@Override //전체 목록_tw
	public List<SaleVO> listSale()throws Exception{
		return sqlSession.selectList(namespace+".listSale");
	}

	@Override
	//서브카테고리 찾기_tw
	public SubCategoryVO searchSubCategory(Integer subca_id) throws Exception{
		return sqlSession.selectOne(namespace + ".searchSubCategory", subca_id);
	}

	@Override
	//물품 찾기_tw
	public SaleVO searchSale(int sale_id)throws Exception {
		
		return sqlSession.selectOne(namespace+".searchSale", sale_id);
	}

	@Override
	//전체카테고리 찾기_tw
	public String searchTotalCategory(int subca_id)throws Exception {
		return sqlSession.selectOne(namespace+".searchTotalCategory", subca_id);
	}

	@Override	//카테고리별 목록_tw
	public List<SaleVO> listSalesub(Integer subca_id)throws Exception {
		return sqlSession.selectList(namespace+".listSalesub", subca_id);
	}

	@Override//거래상태 변경_tw
	public void updateSaleStatusFirst(SaleVO salevo) throws Exception {
		sqlSession.update(namespace+".changeSaleStateFirst", salevo);
		
	}

	@Override
	public void updateReadCount(int sale_id) throws Exception {
		sqlSession.update(namespace+".updateReadCount", sale_id);
	}


}
