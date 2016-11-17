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

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.service.AuctionListServiceImpl;

@Controller
public class AuctionListController {
	
	@Inject
	private AuctionListServiceImpl service;

	@RequestMapping(value="/auctionList", method=RequestMethod.GET)
	public void auctionList_GET(Model model) throws Exception{
		
		List<AuctionVO> listAuction = service.auctionList(null);
		
		model.addAttribute("listAuction", listAuction);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/auctionListSort", method=RequestMethod.POST)
	public ResponseEntity<List<AuctionVO>> listSort(@RequestParam("sort") String sort) throws Exception{
		ResponseEntity<List<AuctionVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.auctionList(sort), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	
}
