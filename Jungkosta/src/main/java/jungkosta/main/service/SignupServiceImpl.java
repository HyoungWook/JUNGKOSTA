package jungkosta.main.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.commons.util.Encryption;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.persistence.MemberDAO;

@Service
public class SignupServiceImpl implements SignupService {
	
	@Inject
	private MemberDAO dao;

	@Override
	public void signupProc(MemberVO vo, String pass) throws Exception {
		Encryption encrypt = new Encryption();				//암호화 객체	
		
		String password = encrypt.passEcnript(pass);
		vo.setPassword(password);
		
		dao.createMember(vo);
	}

	@Override
	public MemberVO selectMemberService(String email) throws Exception {
		return dao.selectMember(email);
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception {
		dao.updateMember(vo);
		
	}

}
