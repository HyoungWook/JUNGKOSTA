package jungkosta.auction.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.auction.domain.AuctionCriteria;
import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.persistence.AuctionListDAO;

@Service
public class AuctionListServiceImpl implements AuctionListService {

	@Inject
	private AuctionListDAO dao;

	@Override
	public List<AuctionVO> auctionList(AuctionCriteria cri, String categoryList, String statusList) throws Exception {

		Map<String, Object> map = new HashMap<>();
		map.put("cri", cri);

		if (categoryList != null) {
			String[] temp = categoryList.split(",");
			map.put("category", temp);
		}

		if (statusList != null) {
			String[] status = statusList.split(",");

			map.put("status", status);
		}

		return dao.auctionList(map);
	}
}
