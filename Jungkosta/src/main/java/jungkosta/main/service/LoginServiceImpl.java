package jungkosta.main.service;

import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import jungkosta.commons.util.AvlTree;
import jungkosta.commons.util.DataStructure;
import jungkosta.commons.util.Decryption;
import jungkosta.commons.util.Node;
import jungkosta.main.domain.BlackListVO;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.persistence.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Inject
	private LoginDao loginDao;
	
	
	//2016/11/19 우성 수정
	@Override
	public String check_Login(HttpServletRequest request,MemberVO vo, String pass)throws Exception{		
		MemberVO ret_vo = loginDao.check_Login(vo);
		
		
		//2016/12/04 우성 수정
		if(ret_vo == null){
			return URLEncoder.encode("E-mail이 틀렸습니다.","utf-8");
		}
		
		//끝
		Decryption decrypt = new Decryption();		//복호화 객체
		
		String[] brypass = decrypt.covertHtoOne(ret_vo.getPassword());	//db저장비번 이진수로 변환
		long[] dry = new long[brypass.length];
		
		//이진수 => 십진수변환
		for(int i=0; i<brypass.length-1; i++){
			dry[i] = decrypt.refactoring(brypass[i+1]); 	
			
		}
		
		//십진수 => 문자열로 변환 복호화완료
		String password = "";
		for(int i=0; i<dry.length; i++){
			password += decrypt.decriptOk(dry[i]);		
		}
		
		password = password.trim();
		System.out.println(password);
		HttpSession session = request.getSession();
				
		String ret_Value = null;
		
		if(password.equals(pass) == false || vo.getEmail().equals(ret_vo.getEmail()) == false){
			if (password.equals(pass) == false) {
				ret_Value = "비밀번호가 틀렸습니다.";
			}
			else
				ret_Value = "E-mail이 틀렸습니다.";
		}else{
			
			
			BlackListVO b_Vo = loginDao.checkBlackList(vo.getEmail()); 
			
			if(b_Vo == null){
				
				AvlTree tree =  DataStructure.getTree();
				
				Node node = new Node();
				
				node.setEmail(vo.getEmail());
				node.setSession(request.getSession());
				
				if(tree.insertNode(node) == AvlTree.FAIL){
					tree.deleteNode(vo.getEmail());
					tree.insertNode(node);
				}
				
				session.setAttribute("email", ret_vo.getEmail());
				session.setAttribute("name", ret_vo.getName());
				session.setAttribute("password", ret_vo.getPassword());
				
				ret_Value = ret_vo.getName()+"님 환영합니다.";
			}
			else{
				ret_Value = "블랙 리스트로 등록 되었습니다.(사유 : "+b_Vo.getReason()+" )";
			}			
		}
				
		ret_Value = URLEncoder.encode(ret_Value, "UTF-8");
		
		return ret_Value;
	}
	
	
}
