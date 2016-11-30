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

		Map<String, String> map = new HashMap<String,String>();

		map.put("sort", sort);
		return dao.auctionList(map);
	}

	@Override
	public List<AuctionVO> auctionCate(String categoryList,String statusList) throws Exception {
		
		String [] arr=statusList.split(",");
		
		Map<String,Object> m = new HashMap<String,Object>();
		
		m.put("categoryList", categoryList);
		m.put("statusList", arr);
		
		return dao.auctionCate(m);
	}

}
