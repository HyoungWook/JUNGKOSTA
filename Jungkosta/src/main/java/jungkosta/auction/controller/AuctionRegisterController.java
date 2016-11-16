package jungkosta.auction.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
   @RequestMapping(value="/auctionRegisterForm",method = RequestMethod.GET)
   public String auctionRegisterForm() {
     
      return "auctionRegisterForm";
   }
   
   @RequestMapping(value="/auctionRegister",method=RequestMethod.POST)
   public String auctionRegister(AuctionVO auction)throws Exception{
	   service.register(auction);
	   return "main/home";
   }
   
}