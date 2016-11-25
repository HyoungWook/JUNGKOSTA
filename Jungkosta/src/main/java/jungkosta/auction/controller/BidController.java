package jungkosta.auction.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.domain.BiddingVO;
import jungkosta.auction.service.AuctionService;
import jungkosta.auction.service.BiddingService;
import jungkosta.commons.util.BidThread;

@Controller
public class BidController {

	@Inject
	private BiddingService bidService;

	@Inject
	private AuctionService auctionService;

	public BidController() {

		new BidThread().start();

	}

	@RequestMapping(value = "/bidRegisterForm/{sale_id}", method = RequestMethod.GET)
	public String biddingForm_GET(@PathVariable("sale_id") int sale_id, Model model) throws Exception {

		AuctionVO auction = auctionService.read(sale_id);
		model.addAttribute("auction", auction);

		return "bidRegisterForm";
	}

	@RequestMapping(value = "/bidRegisterForm", method = RequestMethod.POST)
	public String bidRegister(BiddingVO vo, HttpServletRequest request, Model model) throws Exception {

		AuctionVO auction = auctionService.read(Integer.parseInt(request.getParameter("sale_id")));

		int bidding_cost = Integer.parseInt(request.getParameter("bidding_cost"));

		bidService.registerBid(vo);

		auction.setItem_cost(bidding_cost);

		auctionService.updateDetail(auction);

		if (auction.getImmediate_bid_cost() == vo.getBidding_cost()) {

			return "biddingpageProc";
		} else {
			return "bidpageProc";
		}

	}

}
