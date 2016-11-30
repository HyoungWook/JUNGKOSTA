package jungkosta.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuctionController {

	@RequestMapping(value = "/auctionList", method = RequestMethod.GET)
	public void auctionList_GET(Model model) throws Exception {
	
	}

}
