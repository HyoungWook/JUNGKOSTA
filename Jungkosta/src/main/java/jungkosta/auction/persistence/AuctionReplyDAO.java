package jungkosta.auction.persistence;

import java.util.List;

import jungkosta.auction.domain.AuctionReplyVO;

public interface AuctionReplyDAO {

	public void replyRegister(AuctionReplyVO vo) throws Exception;

	public int selectR_id() throws Exception;

	public List<AuctionReplyVO> replyList(int sale_id) throws Exception;
	
	public int getStep(int ref) throws Exception;

}
