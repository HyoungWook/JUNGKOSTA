package jungkosta.main.persistence;

import jungkosta.main.domain.BlackListVO;
import jungkosta.main.domain.MemberVO;

public interface LoginDao {
	
	public MemberVO check_Login(MemberVO vo)throws Exception;
	public BlackListVO checkBlackList(String email)throws Exception;
}
