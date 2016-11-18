package jungkosta.main.service;

import java.util.List;

import jungkosta.main.domain.BoardVO;

public interface BoardService {
	
	public void boardInsert(BoardVO vo)throws Exception;
	public List<BoardVO> boardList(int startPage)throws Exception;
	public Integer boardCount()throws Exception;
}
