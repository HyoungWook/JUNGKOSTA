package jungkosta.main.service;

import java.util.List;

import jungkosta.main.domain.Board2VO;
import jungkosta.main.domain.BoardVO;
import jungkosta.main.domain.Reply2VO;
import jungkosta.main.domain.ReplyVO;

public interface BoardService {
	
	public void boardInsert(BoardVO vo)throws Exception;
	public List<Board2VO> boardList(int startPage)throws Exception;
	public Integer boardCount()throws Exception;
	public Board2VO boardDetail(int bno)throws Exception;
	public void increaseViewNum(int bno)throws Exception;
	public Integer replyNum()throws Exception;
	public void insertReply(ReplyVO vo)throws Exception;
	public List<Reply2VO> replyList(int bno)throws Exception;
}
