package jungkosta.main.service;

import java.util.ArrayList;

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

		ArrayList<Long> num = new ArrayList<>();
		String hexa = "";
		
		for(int i=0; i<password.length; i++){
			
			num.add((long)password[i]);
			hexa = Long.toHexString(num.get(i)+1);

		}
		
		password = hexa.toCharArray();
		for(int i=0; i<password.length; i++){
			System.out.println(password[i] + 1);
		}
		
		dao.createMember(vo);		
	}

	@Override
	public MemberVO selectMemberService(String email) throws Exception {
		return dao.selectMember(email);
	}

}
