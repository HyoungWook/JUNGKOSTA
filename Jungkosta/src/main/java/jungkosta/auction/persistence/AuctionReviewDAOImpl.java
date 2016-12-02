package jungkosta.auction.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.SellerReviewVO;

@Repository
public class AuctionReviewDAOImpl implements AuctionReviewDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "jungkosta.main.mappers.auction.AuctionReviewMapper";
	
	@Override
	public void insertSellerReview(SellerReviewVO vo) throws Exception {
		
		sqlSession.insert(namespace+".insertSellerReview",vo);
	}

	@Override
	public int selectReview_id() throws Exception {
		
		if(sqlSession.selectOne(namespace+".selectReview_id")!=null){
		return sqlSession.selectOne(namespace+".selectReview_id");
		}
		else{
			return 0;
		}
	}

	@Override
	public List<SellerReviewVO> sellerReviewList(String seller) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".sellerReviewList", seller);
	}
	
}
