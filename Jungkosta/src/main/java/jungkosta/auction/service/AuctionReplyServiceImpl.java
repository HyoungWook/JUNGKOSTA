package jungkosta.auction.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jungkosta.auction.domain.AuctionReplyVO;
import jungkosta.auction.persistence.AuctionReplyDAO;

@Service
public class AuctionReplyServiceImpl implements AuctionReplyService {

	@Inject
	private AuctionReplyDAO dao;

	@Transactional
	@Override
	public void replyRegister(AuctionReplyVO vo) throws Exception {
		vo.setItem_qa_id(dao.selectR_id() + 1);

		if (vo.getQa_level() != 1) {
			vo.setRef(vo.getItem_qa_id());
		} else {
			vo.setStep(dao.getStep(vo.getRef())+1);
		}

		dao.replyRegister(vo);
	}

	@Override
	public int selectR_id() throws Exception {

		return dao.selectR_id();
	}

	@Override
	public List<AuctionReplyVO> replyList(int sale_id) throws Exception {

		return dao.replyList(sale_id);
	}

	@Override
	public int getStep(int ref) throws Exception {
		return dao.getStep(ref);
	}

}
