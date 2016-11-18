package jungkosta.main.persistence;

import java.util.List;

import jungkosta.main.domain.BoardVO;

public interface BoardDao {
	
	public void boardInsert(BoardVO vo)throws Exception;
	public List<BoardVO> boardList(int startPage)throws Exception;
	public Integer countBoard()throws Exception;
}
