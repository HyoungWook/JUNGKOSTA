package jungkosta.auction.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.CategoryVO;
import jungkosta.auction.service.AuctionService;

@Controller
public class AuctionDetailController {

	@Inject
	private AuctionService service;

	@RequestMapping(value = "/auctionDetail", method = RequestMethod.GET)
	public void auctionDetail(@RequestParam("sale_id") int sale_id, Model model) throws Exception {

		AuctionVO auction = service.read(sale_id);
		
		CategoryVO category = service.selectCategory(auction.getSubca_id());

		model.addAttribute("auction", auction);
		model.addAttribute("category", category);

	}

}
