package jungkosta.main.service;

import java.util.List;

import jungkosta.main.domain.MessageVO;

public interface MessageService {
	
	public void insertMessage(MessageVO vo);
	public List<MessageVO> messageList(String email);
	public MessageVO selectMessage(int mid);
	public int messageCheck(String email);
}
