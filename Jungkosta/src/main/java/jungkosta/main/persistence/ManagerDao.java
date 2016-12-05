package jungkosta.main.persistence;

import java.util.HashMap;
import java.util.List;

import jungkosta.main.domain.BlackListVO;
import jungkosta.main.domain.MemberVO;

public interface ManagerDao {
	public List<MemberVO> customSearch(MemberVO vo);
	public String insertBlackList(BlackListVO vo, String admin);
	public MemberVO emailSearch(String email);
	public void editWarningNum(HashMap<String, String> map);
	
}
