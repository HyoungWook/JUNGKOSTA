package jungkosta.main.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.main.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "jungkosta.mappers.main.memberMapper";

	@Override
	public void createMember(MemberVO vo) throws Exception {
		sqlSession.insert(namespace+".createMember", vo);
	}

	@Override
	public MemberVO selectMember(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
