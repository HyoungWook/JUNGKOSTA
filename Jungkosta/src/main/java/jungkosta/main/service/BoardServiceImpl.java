package jungkosta.main.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.main.domain.Board2VO;
import jungkosta.main.domain.BoardVO;
import jungkosta.main.domain.Reply2VO;
import jungkosta.main.domain.ReplyVO;
import jungkosta.main.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDao boardDao;
	
	
	@Override
	public void boardInsert(BoardVO vo) throws Exception {
		boardDao.boardInsert(vo);
	}
	
	@Override
	public List<Board2VO> boardList(int startPage) throws Exception {
		
		List<Board2VO> list = boardDao.boardList(startPage);
		
		return list;
	}
	
	@Override
	public Integer boardCount() throws Exception {
		return boardDao.countBoard();
	}
	
	@Override
	public Board2VO boardDetail(int bno)throws Exception{
	
		return boardDao.boardDetail(bno);
	}
	
	@Override
	public void increaseViewNum(int bno) throws Exception {
			boardDao.increaseViewNum(bno);
	}
	
	@Override
	public Integer replyNum() throws Exception {
		return boardDao.replyNum();
	}
	
	@Override
	public void insertReply(ReplyVO vo) throws Exception {
		boardDao.insertReply(vo);
	}
	
	@Override
	public List<Reply2VO> replyList(int bno) throws Exception {
		return boardDao.replyList(bno);
	}
}
