package jungkosta.main.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.main.domain.BoardVO;
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
	public List<BoardVO> boardList() throws Exception {
		
		List<BoardVO> list = boardDao.boardList();
		
		return list;
	}
	
	@Override
	public Integer boardCount() throws Exception {
		return boardDao.countBoard();
	}
}
