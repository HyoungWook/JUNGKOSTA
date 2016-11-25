package jungkosta.auction.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jungkosta.auction.domain.AuctionReplyVO;
import jungkosta.auction.service.AuctionReplyService;

@RestController
public class AuctionReplyController {
	
	@Inject
	private AuctionReplyService service;
	
	
	@RequestMapping(value="/replyRegister", method=RequestMethod.POST)
	public void replyRegister(AuctionReplyVO vo) throws Exception{

		service.replyRegister(vo);
	}
	
	@RequestMapping(value="/replyList/{sale_id}", method=RequestMethod.GET)
	public ResponseEntity<List<AuctionReplyVO>> replyList(@PathVariable int sale_id) throws Exception{
		ResponseEntity<List<AuctionReplyVO>> entity = null;
		
		try {
			
			List<AuctionReplyVO> list = service.replyList(sale_id);
			
			entity = new ResponseEntity<List<AuctionReplyVO>>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<AuctionReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}
