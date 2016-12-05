package jungkosta.main.persistence;

import java.io.InputStream;

import javax.inject.Inject;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jungkosta.main.domain.MessageVO;

@Repository
public class MessageDao_khwImpl implements MessageDao_khw{
	public static MessageDao_khwImpl msgDao = new MessageDao_khwImpl();
	private String namespace = "jungkosta.mappers.main.MessageMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	public static MessageDao_khwImpl getInstance(){
		return msgDao;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config.xml";
		InputStream input = null;
		
		try {
			input = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(input);
	}
	
	@Override
	public void insertMessage(MessageVO vo){
		//System.out.println("2");
		sqlSession.insert(namespace+".insertMessage", vo);
	}
	
	@Override
	public Integer selectMessageMaxNum() {
		System.out.println("2");
		return sqlSession.selectOne(namespace+".selectMessageMaxNum");
	}
}
