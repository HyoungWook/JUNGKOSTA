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
	public List<AuctionVO>  listCategory(String categoryList,String statusList) throws Exception {
		
		String [] arr = statusList.split(",");
		
		String[] temp  =categoryList.split(",");
		
		int[] arr2 = new int[temp.length];
		
		for(int i = 0 ; i < arr2.length ; i++){
			arr2[i] = Integer.parseInt(temp[i]);
		}
		
		Map<String,Object> m = new HashMap<String,Object>();
		if(!categoryList.equals("") && categoryList!=null){			
			m.put("categoryList",arr2);
		}
		if(!statusList.equals("") && statusList!=null){		
		m.put("statusList", arr);
		}
		
		if(m.get("statusList") != null){
			String[] aa = (String[]) m.get("statusList");
			
			for(int i=0;i<aa.length;i++){
				System.out.print(aa[i] + ", ");
			}
			System.out.println();
		}
		
		return dao.auctionCate(m);
	}

}
