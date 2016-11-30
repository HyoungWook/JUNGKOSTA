package jungkosta.trade.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import jungkosta.trade.domain.ItemQAVO;
import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.persistence.TradeDAO;

@Service
public class TradeServiceImpl implements TradeService {
	
	@Inject
	private TradeDAO dao; 

	//일반판매물품 등록_ysi
	@Override
	public void regist(SaleVO saleVO) throws Exception {
		saleVO.setSale_id(dao.selectS_id() + 1);
		System.out.println("입력 SaleVO : " + saleVO);
		dao.insertSale(saleVO);
	}

	//일반판매물품list_ysi
	@Override
	public List<SaleVO> listSale(Integer subca_id, String sort) throws Exception {
		return dao.listAll(subca_id, sort);
	}
	
	//물품문의댓글_ysi
		@Override
		public void insertQA(ItemQAVO itemQa) throws Exception {
			System.out.println(itemQa);
			if(itemQa.getItem_qa_id() == 0){
				
				itemQa.setItem_qa_id(dao.selectQa_id() + 1);
			}
			itemQa.setItem_qa_id(dao.selectQa_id() + 1);
			System.out.println("입력 itemQa : " + itemQa);
			dao.insertQA(itemQa);
		}

		//물품문의리스트_ysi
		@Override
		public List<ItemQAVO> listItemQa(Integer sale_id) throws Exception {
			return dao.listItemQa(sale_id);
		}

}
