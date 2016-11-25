package jungkosta.auction.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.auction.domain.AuctionReplyVO;

@Repository
public class AuctionReplyDAOImpl implements AuctionReplyDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "jungkosta.main.mappers.auction.AuctionReplyMapper";

	@Override
	public void replyRegister(AuctionReplyVO vo) throws Exception {
		sqlSession.insert(namespace + ".replyRegister", vo);
	}

	@Override
	public int selectR_id() throws Exception {
		
		Integer id = sqlSession.selectOne(namespace + ".selectR_id");
		
		if(id != null){
			return id;
		}else{
			return 0;
		}
	}

	@Override
	public List<AuctionReplyVO> replyList(int sale_id) throws Exception {

		
		return sqlSession.selectList(namespace + ".replyList", sale_id);
	}

	@Override
	public int getStep(int ref) throws Exception {
		
		return sqlSession.selectOne(namespace + ".getStep", ref);
	}

}
