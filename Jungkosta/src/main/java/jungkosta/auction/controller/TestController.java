package jungkosta.auction.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */

@Controller
public class TestController {
   
   private static final Logger logger = LoggerFactory.getLogger(TestController.class);
   
   /**
    * Simply selects the home view to render by returning its name.
    */
   @RequestMapping("/index")
   public String home() {
     
      return "index";
   }
   
}