package jungkosta.main.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jungkosta.main.domain.BlackListVO;
import jungkosta.main.domain.MemberVO;

@Repository
public class ManagerDaoImpl implements ManagerDao {
	
	private String namespace="jungkosta.mappers.main.ManagerMapper";
	
	@Inject
	private SqlSession session;
	
	@Override
	public List<MemberVO> customSearch(MemberVO vo) {
		List<MemberVO> list = session.selectList(namespace+".customSearch",vo);
		
		return list;
	}
	
	@Override
	public String insertBlackList(BlackListVO vo, String admin) {
		
		Integer admin_Id = session.selectOne(namespace+".ManagerID",admin);
		
		if(admin_Id == null)
			return "0";
		
		int admin_Number = admin_Id;
		
		vo.setAdmin_id(admin_Number);
		session.update(namespace+".registBlackList",vo.getEmail());
		session.insert(namespace+".insertBlackList",vo);
		
		return "1";
	}
	

	@Override
	public MemberVO emailSearch(String email) {
		return session.selectOne(namespace+".emailSearch",email);
	}
	
	@Override
	public void editWarningNum(HashMap<String, String> map) {
		session.update(namespace+".increaseWarningNumber",map);
		
	}
	
	
}
