package jungkosta.main.service;

import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import jungkosta.commons.util.Decryption;
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
		Decryption decrypt = new Decryption();
		
		
		HttpSession session = request.getSession();
		
		String ret_Value = null;
		
		if (ret_vo == null) {
			ret_Value = "아이디나 비밀번호가 틀렸습니다.";
		}else {
			BlackListVO b_Vo = loginDao.checkBlackList(vo.getEmail()); 
			
			if(b_Vo == null){
				
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
