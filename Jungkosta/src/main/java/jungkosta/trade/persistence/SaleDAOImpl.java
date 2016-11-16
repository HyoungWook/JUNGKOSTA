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
	@Override
	
	public int insertSale(SaleVO register) {
		return 0;
	}

	@Override
	public Integer selectS_id()throws Exception {
		return sqlSession.selectOne(namespace+".selectS_id");
	}

	@Override //전체 목록
	public List<SaleVO> listSale()throws Exception{
		return sqlSession.selectList(namespace+".listSale");
	}

	
	
	@Override
	public SubCategoryVO searchSubCategory(int subca_id) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleVO searchSale(int sale_id)throws Exception {
		return sqlSession.selectOne(namespace+".searchSale", sale_id);
	}

	@Override
	public String searchTotalCategory(int subca_id)throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override	//카테고리별 목록
	public List<SaleVO> listSalesub(int subca_id)throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
