package jungkosta.main.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.main.controller.BoardController;
import jungkosta.main.domain.Board2VO;
import jungkosta.main.domain.BoardVO;
import jungkosta.main.domain.Reply2VO;
import jungkosta.main.domain.ReplyVO;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Inject
	private SqlSession session;
	
	private String namespace = "jungkosta.mappers.main.BoardMapper";
	
	
	@Override
	public void boardInsert(BoardVO vo) throws Exception {
		
		Integer bno = session.selectOne(namespace+".BoardNumber");
		
		if(bno == null){
			vo.setBoard_id(1);
		}else{
			vo.setBoard_id(bno+1);
		}
		
		session.insert(namespace+".insertBoard",vo);
	}
	
	@Override
	public List<Board2VO> boardList(int startPage) throws Exception {
		System.out.println(startPage);
		List<Board2VO> list = session.selectList(namespace+".boardList",null,new RowBounds(startPage, BoardController.PAGE_SIZE));
		
		return list;
	}
	
	@Override
	public Integer countBoard() throws Exception {
		
		return session.selectOne(namespace+".countBoard");
	}
	
	@Override
	public Board2VO boardDetail(int bno)throws Exception{
		
		return session.selectOne(namespace+".boardDetail",bno);
	}
	
	@Override
	public void increaseViewNum(int bno) throws Exception {
		session.update(namespace+".increaseViewNum",bno);
	}
	
	@Override
	public Integer replyNum() throws Exception {
		return session.selectOne(namespace+".replyNum");
	}
	
	@Override
	public void insertReply(ReplyVO vo) throws Exception {
		session.insert(namespace+".insertReply",vo);
	}
	
	@Override
	public List<Reply2VO> replyList(int bno) throws Exception {
		return session.selectList(namespace+".replyList", bno);
	}
}
