package jungkosta.main.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.main.domain.MemberVO;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Inject
	private SqlSession session;
	
	private String namespace = "jungkosta.mappers.main.LoginMapper";
	
	@Override
	public MemberVO check_Login(MemberVO vo) throws Exception {
		
		MemberVO ret_vo = session.selectOne(namespace+".check_Login_ws",vo);
		return ret_vo;
	}
	
	
}
