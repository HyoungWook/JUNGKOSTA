package jungkosta.main.service;

import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import jungkosta.commons.util.AvlTree;
import jungkosta.commons.util.DataStructure;
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
	public String check_Login(HttpServletRequest request,MemberVO vo)throws Exception{
		
		MemberVO ret_vo = loginDao.check_Login(vo);
		
		HttpSession session = request.getSession();
		
		String ret_Value = null;
		
		if (ret_vo == null) {
			ret_Value = "아이디나 비밀번호가 틀렸습니다.";
		}else {
			
			//2016/11/21 우성 중복 로그인 수정.
			
			AvlTree tree = DataStructure.getTree();
			
			Node pNew = new Node();
			
			pNew.setEmail(vo.getEmail());
			pNew.setSession(session);
			
			
			int result = tree.insertNode(pNew);
			
			if(result == AvlTree.FAIL){
				tree.deleteNode(vo.getEmail());
				tree.insertNode(pNew);
			}
			
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
