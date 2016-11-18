package jungkosta.main.persistence;

import jungkosta.main.domain.MemberVO;

public interface MemberDAO {
	public void createMember(MemberVO vo)throws Exception;
	
	public MemberVO selectMember(String email)throws Exception;
}
