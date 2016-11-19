package jungkosta.main.service;

import jungkosta.main.domain.MemberVO;

public interface LoginService {
	
	public MemberVO check_Login(MemberVO vo)throws Exception;
}
