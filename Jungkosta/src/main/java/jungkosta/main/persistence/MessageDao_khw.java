package jungkosta.main.persistence;

import jungkosta.main.domain.MessageVO;

public interface MessageDao_khw {
	public void insertMessage(MessageVO vo);
	
	public Integer selectMessageMaxNum();
}
