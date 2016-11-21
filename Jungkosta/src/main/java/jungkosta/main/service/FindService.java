package jungkosta.main.service;

import jungkosta.main.domain.MemberVO;

public interface FindService {
	public MemberVO findEmail(MemberVO vo)throws Exception;
	public MemberVO findPassword(MemberVO vo)throws Exception;
}
