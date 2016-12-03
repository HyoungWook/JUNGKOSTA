package jungkosta.main.service;

import java.util.List;

import jungkosta.main.domain.AucPurVO;

public interface MyPageService {
	
	public List<AucPurVO> readMyAucPur(String email) throws Exception;

}
