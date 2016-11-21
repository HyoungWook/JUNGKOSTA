package jungkosta.main.persistence;

import java.util.List;

import jungkosta.main.domain.MessageVO;

public interface MessageDao {

	public void insertMessage(MessageVO vo);
	public Integer selectMessageMaxNum();
	public List<MessageVO> messageList(String email);
	public void changeReadState(int mid);
	public MessageVO selectMessage(int mid);
	public int messageCheck(String email);
}
