package jungkosta.main.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.main.controller.BoardController;
import jungkosta.main.domain.BoardVO;

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
	public List<BoardVO> boardList(int startPage) throws Exception {
		
		List<BoardVO> list = session.selectList(namespace+".boardList",new RowBounds(startPage, BoardController.PAGE_SIZE));
		
		return list;
	}
	
	@Override
	public Integer countBoard() throws Exception {
		
		return session.selectOne(namespace+".countBoard");
	}
}
