package jungkosta.main.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.persistence.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Inject
	private LoginDao loginDao;

	@Override
	public MemberVO check_Login(MemberVO vo)throws Exception{
		
		MemberVO ret_vo = loginDao.check_Login(vo);
		return ret_vo;
	}
	
	
}
