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
	public void signupProc(MemberVO vo) throws Exception {
		dao.createMember(vo);

	}

}
