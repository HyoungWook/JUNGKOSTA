package jungkosta.auction.service;

import java.util.List;

import jungkosta.auction.domain.AuctionReplyVO;

public interface AuctionReplyService {
	
	public void replyRegister(AuctionReplyVO vo) throws Exception;
	
	public int selectR_id() throws Exception;
	
	public List<AuctionReplyVO> replyList(int sale_id) throws Exception;
	
	public int getStep(int ref) throws Exception;

}
