package jungkosta.main.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.main.domain.MessageVO;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	@Inject
	private SqlSession session;
	
	private String namespace = "jungkosta.mappers.main.MessageMapper";
	
	@Override
	public void insertMessage(MessageVO vo) {
		
		session.insert(namespace+".insertMessage",vo);
		
	}
	
	@Override
	public Integer selectMessageMaxNum() {
		
		return session.selectOne(namespace+".selectMessageMaxNum");
	}
	
	@Override
	public List<MessageVO> messageList(String email) {
		
		return session.selectList(namespace+".messageList",email);
	}
	
	@Override
	public void changeReadState(int mid) {
		session.update(namespace+".changeReadState",mid);
	}
	
	@Override
	public MessageVO selectMessage(int mid) {
		return session.selectOne(namespace+".selectMessage",mid);
	}
	
	@Override
	public int messageCheck(String email) {
		
		int count = session.selectOne(namespace+".notReadMessage",email);
		return count;
	}
}
