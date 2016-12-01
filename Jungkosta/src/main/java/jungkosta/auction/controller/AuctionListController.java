package jungkosta.auction.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.service.AuctionListService;
import jungkosta.auction.service.AuctionService;
import jungkosta.auction.service.BiddingService;

@RestController
public class AuctionListController {

	@Inject
	private AuctionListService auctionListService;
	
	@Inject
	private AuctionService auctionService;

	@RequestMapping(value = "/auctionListSort", method = RequestMethod.GET)
	public ResponseEntity<List<AuctionVO>> listSort(@RequestParam("sort") String sort) throws Exception {
		ResponseEntity<List<AuctionVO>> entity = null;

		try {

			List<AuctionVO> list = auctionListService.auctionList(sort);

			entity = new ResponseEntity<List<AuctionVO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<AuctionVO>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value = "/item_pic/{sale_id}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> item_picList(@PathVariable("sale_id") int sale_id) throws Exception {
		ResponseEntity<List<String>> entity = null;

		try {

			List<String> item_list = auctionService.getThunbnail(sale_id);
			entity = new ResponseEntity<List<String>>(item_list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value = "auctionCategory", method = RequestMethod.POST)
	public List<AuctionVO> auctionCategory(Model model,String categoryList,String statusList) throws Exception{
		
		return auctionListService.auctionCate(categoryList, statusList);
		
	}
	

}
