package jungkosta.auction.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.service.AuctionListServiceImpl;

@Controller
public class AuctionListController {
	
	@Inject
	private AuctionListServiceImpl service;

	@RequestMapping(value="/auctionList", method=RequestMethod.GET)
	public void auctionList_GET(Model model) throws Exception{
		
		List<AuctionVO> listAuction = service.auctionList();
		
		System.out.println(listAuction);
		
		model.addAttribute("listAuction", listAuction);
		
	}
	
}
