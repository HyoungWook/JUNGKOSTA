package jungkosta.main.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.main.domain.AucPurVO;
import jungkosta.main.persistence.MyPageDAO;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Inject
	private MyPageDAO dao;

	@Override
	public List<AucPurVO> readMyAucPur(String email) throws Exception {

		return dao.readMyAucPur(email);
	}

}
