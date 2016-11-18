package jungkosta.trade.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.domain.SaleVO_tw;
import jungkosta.trade.domain.SubCategoryVO;

@Repository
public class SaleDAOImpl implements SaleDAO {

	@Inject
	private SqlSession sqlSession; 
	
	private static final String namespace="jungkosta.mappers.trade.tradeMapper";
	@Override
	
	public int insertSale(SaleVO_tw register) {
		return 0;
	}

	@Override
	//max(id) 값 찾기_tw
	public Integer selectS_id()throws Exception {
		if((sqlSession.selectOne(namespace+".selectS_id")) == null){
			return 0;
		}
		else{
			return sqlSession.selectOne(namespace+".selectS_id");
		}
	}

	@Override //전체 목록_tw
	public List<SaleVO_tw> listSale()throws Exception{
		return sqlSession.selectList(namespace+".listSale");
	}

	@Override
	//서브카테고리 찾기_tw
	public SubCategoryVO searchSubCategory(Integer subca_id) throws Exception{
		return sqlSession.selectOne(namespace + ".searchSubCategory", subca_id);
	}

	@Override
	//물품 찾기_tw
	public SaleVO_tw searchSale(int sale_id)throws Exception {
		return sqlSession.selectOne(namespace+".searchSale", sale_id);
	}

	@Override
	//전체카테고리 찾기_tw
	public String searchTotalCategory(int subca_id)throws Exception {
		return sqlSession.selectOne(namespace+".searchTotalCategory", subca_id);
	}

	@Override	//카테고리별 목록_tw
	public List<SaleVO_tw> listSalesub(Integer subca_id)throws Exception {
		return sqlSession.selectList(namespace+".listSalesub", subca_id);
	}

	@Override
	public List<SaleVO> listSalesub(int subca_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
