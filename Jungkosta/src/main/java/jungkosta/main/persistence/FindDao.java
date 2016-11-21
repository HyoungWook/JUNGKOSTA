package jungkosta.main.persistence;

import jungkosta.main.domain.MemberVO;

public interface FindDao {
	
	public MemberVO findEmail(MemberVO vo)throws Exception;
	public MemberVO findPassword(MemberVO vo)throws Exception;
}
