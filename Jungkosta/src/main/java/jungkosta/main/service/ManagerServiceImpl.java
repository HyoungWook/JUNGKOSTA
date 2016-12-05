package jungkosta.main.service;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.main.domain.BlackListVO;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.domain.MessageVO;
import jungkosta.main.persistence.ManagerDao;
import jungkosta.main.persistence.MessageDao;
import net.sf.json.JSONArray;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Inject
	private ManagerDao managerDao;
	
	@Inject
	private MessageDao messageDao;
	
	@Override
	public String customSearch(String name) {
		
		MemberVO vo = new MemberVO();
		
		String json = null;
		
		vo.setName("%"+name+"%");
		
		List<MemberVO> list = managerDao.customSearch(vo);
		
		if(list != null){
			
			JSONArray jsonArray =  JSONArray.fromObject(list);
			json = jsonArray.toString();
			
			try {
				json = URLEncoder.encode(json,"utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return json;
	}
	
	@Override
	public String insertBlackList(BlackListVO vo, String admin) {
		
		return managerDao.insertBlackList(vo, admin);
	}
	
	@Override
	public MemberVO emailSearch(String email) {
		return managerDao.emailSearch(email);
	}
	
	@Override
	public String editWarningNum(MessageVO vo, String warning_num) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		String result = null;
		
		map.put("warning_num", warning_num);
		map.put("email", vo.getReceiver());
		
		managerDao.editWarningNum(map);
		
		if(!warning_num.equals("2")){
			
			messageDao.insertMessage(vo);
			System.out.println("젠장2");
			result = "경고 횟수 변환 및 메시지 전송 완료";
			
		}else{
			
			BlackListVO member = new BlackListVO();
			
			member.setReason(vo.getContent());
			member.setEmail(vo.getReceiver());
			member.setAdmin_id(1);
			
			managerDao.insertBlackList(member, "admin@admin.com");
			System.out.println("젠장3");
			result = "경고 횟수 변환 및 블랙리스트 등록 완료";
		}
		
		try {
			result = URLEncoder.encode(result, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
