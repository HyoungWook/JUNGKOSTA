package jungkosta.main.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.main.domain.MemberVO;

@Repository
public class FindDaoImpl implements FindDao {
	
	private String namespace = "jungkosta.mappers.main.FindMapper";
	
	@Inject
	private SqlSession session;
	
	public MemberVO findEmail(MemberVO vo)throws Exception{
		
		return session.selectOne(namespace+".findEmail",vo);
	}
	
	@Override
	public MemberVO findPassword(MemberVO vo) throws Exception {
		return session.selectOne(namespace+".findPassword",vo);
	}
}
