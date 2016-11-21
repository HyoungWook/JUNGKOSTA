package jungkosta.main.service;

import java.util.List;

import jungkosta.main.domain.BlackListVO;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.domain.MessageVO;

public interface ManagerService {
	
	public String customSearch(String name);
	public String insertBlackList(BlackListVO vo, String admin);
	public MemberVO emailSearch(String email);
	public String editWarningNum(MessageVO vo, String warning_num);
}
