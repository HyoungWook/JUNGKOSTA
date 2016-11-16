package jungkosta.auction.controller;

import java.sql.Timestamp;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jungkosta.auction.domain.AuctionVO;
import jungkosta.auction.service.AuctionService;

/**
 * Handles requests for the application home page.
 */

@Controller
public class AuctionRegisterController {

	@Inject
	private AuctionService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	@RequestMapping(value = "/auctionRegisterForm", method = RequestMethod.GET)
	public void auctionRegisterForm() {

	}

	//auctionRegister => auctionRegisterForm 변경
	@RequestMapping(value = "/auctionRegisterForm", method = RequestMethod.POST)
	public String auctionRegister(AuctionVO auction, HttpServletRequest request) throws Exception {
		
		
		//수정부분 feat : 현우
		String buy_time = request.getParameter("buy_time_temp");
		String auction_end_date = request.getParameter("auction_end_date_temp");
		
		buy_time += " 00:00:00.0";
		auction_end_date += " " + request.getParameter("time_sel") + ":00.0";
		
		auction.setBuy_time(Timestamp.valueOf(buy_time));
		auction.setAuction_end_date(Timestamp.valueOf(auction_end_date));
		//수정부분 feat : 현우
		
		service.register(auction);
		return "redirect:/home";
	}

}