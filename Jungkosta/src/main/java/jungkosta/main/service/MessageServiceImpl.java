package jungkosta.main.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.main.domain.MessageVO;
import jungkosta.main.persistence.MessageDao;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	private MessageDao messageDao;
	
	@Override
	public void insertMessage(MessageVO vo) {
		
		Integer m_id = messageDao.selectMessageMaxNum();
		
		if(m_id == null){
			vo.setMessage_id(1);
		}else{
			vo.setMessage_id(m_id+1);
		}
		vo.setMessage_isread("N");
		messageDao.insertMessage(vo);
	}
	
	@Override
	public List<MessageVO> messageList(String email) {
		
		return messageDao.messageList(email);
	}
	
	@Override
	public MessageVO selectMessage(int mid) {
		
		MessageVO vo = null;
		
		messageDao.changeReadState(mid);
		
		vo = messageDao.selectMessage(mid);
		
		return vo;
	}
	
	@Override
	public int messageCheck(String email) {
		
		int is_Not_Read = messageDao.messageCheck(email);
		
		return is_Not_Read;
	}
}
