package jungkosta.main.service;

import javax.servlet.http.HttpServletRequest;

import jungkosta.main.domain.MemberVO;

public interface LoginService {
	
	//2016/11/19 우성 수정
	public String check_Login(HttpServletRequest request, MemberVO vo)throws Exception;
}
