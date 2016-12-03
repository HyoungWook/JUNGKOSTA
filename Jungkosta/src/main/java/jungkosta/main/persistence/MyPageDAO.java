package jungkosta.main.persistence;

import java.util.List;

import jungkosta.main.domain.AucPurVO;

public interface MyPageDAO {
	
	public List<AucPurVO> readMyAucPur(String email) throws Exception;

}
