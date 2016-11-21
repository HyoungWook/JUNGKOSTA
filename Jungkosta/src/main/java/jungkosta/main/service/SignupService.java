package jungkosta.main.service;

import jungkosta.main.domain.MemberVO;

public interface SignupService {
	public void signupProc(MemberVO vo)throws Exception;
	public MemberVO selectMemberService(String email)throws Exception;
	
}
