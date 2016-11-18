package jungkosta.auction.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.auction.service.AuctionListService;

@Controller
public class AuctionController {

	@Inject
	private AuctionListService listService;

	@RequestMapping(value = "/auctionList", method = RequestMethod.GET)
	public void auctionList_GET(Model model) throws Exception {
	}

}
