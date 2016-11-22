package jungkosta.main.service;

import java.util.ArrayList;

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
		Encryption encrypt = new Encryption();
		
		char[] chrPass = pass.toCharArray(); 
		String[] bryPass = new String[chrPass.length];
		char[] bryChr = new char[bryPass.length];
		String shiftResult = "";
		
		for(int i=0; i<chrPass.length; i++){
			bryPass[i] = Long.toBinaryString(chrPass[i]);
		}
		
		for(int i=0; i<bryPass.length; i++){
			bryChr = bryPass[i].toCharArray();
			
			shiftResult += "#"+encrypt.refactoring(bryChr);
		}
		
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
