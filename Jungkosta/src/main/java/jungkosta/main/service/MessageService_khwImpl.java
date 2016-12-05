package jungkosta.main.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.main.domain.MessageVO;
import jungkosta.main.persistence.MessageDao_khw;


@Service
public class MessageService_khwImpl implements MessageService_khw{
	
	public static MessageService_khwImpl msgService = new MessageService_khwImpl();

	//public static MessageDao_khwImpl msgDao = new MessageDao_khwImpl();
	
	@Inject
	private MessageDao_khw msgDao;
	
	/*public static MessageService_khw getService() {
		msgDao = MessageDao_khwImpl.getInstance();
		return msgService;
	}*/

	@Override
	public void insertMessage(MessageVO vo) {
		System.out.println("1");
		Integer m_id = msgDao.selectMessageMaxNum();
		System.out.println("3");
		if (m_id == null) {
			vo.setMessage_id(1);
		} else {
			vo.setMessage_id(m_id + 1);
		}
		vo.setMessage_isread("N");
		msgDao.insertMessage(vo);
	}

}
