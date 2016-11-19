package jungkosta.main.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.main.domain.MemberVO;
import jungkosta.main.persistence.MemberDAO;

@Service
public class SignupServiceImpl implements SignupService {
	
	@Inject
	private MemberDAO dao;

	@Override
	public void signupProc(MemberVO vo, String pass) throws Exception {
		char[] password = pass.toCharArray();
		long num = (long)password[0];
		
		System.out.println(Long.toHexString(num));
		dao.createMember(vo);
	}

	@Override
	public MemberVO selectMemberService(String email) throws Exception {
		return dao.selectMember(email);
	}

}
