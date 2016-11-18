package jungkosta.main.persistence;

import jungkosta.main.domain.MemberVO;

public interface LoginDao {
	
	public MemberVO check_Login(MemberVO vo)throws Exception;
	
}
