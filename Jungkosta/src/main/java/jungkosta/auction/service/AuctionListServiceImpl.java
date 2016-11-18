package jungkosta.auction.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.persistence.AuctionListDAO;

@Service
public class AuctionListServiceImpl implements AuctionListService {

	@Inject
	private AuctionListDAO dao;

	@Override
	public List<AuctionVO> auctionList(String sort) throws Exception {

		Map<String, String> map = new HashMap<>();

		map.put("sort", sort);
		
		System.out.println(map);

		return dao.auctionList(map);
	}

}
