package jungkosta.auction.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.service.AuctionListService;
import jungkosta.auction.service.BiddingService;

@RestController
public class AuctionListController {

	@Inject
	private AuctionListService service;
	
	@Inject
	private BiddingService bservice;


	@RequestMapping(value = "/auctionListSort", method = RequestMethod.GET)
	public ResponseEntity<List<AuctionVO>> listSort(@RequestParam("sort") String sort) throws Exception {
		ResponseEntity<List<AuctionVO>> entity = null;

		try {
			List<AuctionVO> list = service.auctionList(sort);
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
