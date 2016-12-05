package jungkosta.main.controller;

import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.auction.domain.AuctionListVO;
import jungkosta.commons.util.Path;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.MainService;
import jungkosta.main.service.SignupService;
import jungkosta.trade.domain.PurchaseListVO;
import jungkosta.trade.domain.SaleVO;
import net.sf.json.JSONArray;

@Controller
public class MainController {
	
	@Inject
	private SignupService service;
	
	@Inject
	private MainService mainService;

	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = {RequestMethod.GET,RequestMethod.POST})
	public String home(Locale locale, Model model,HttpServletRequest request) {
		logger.info("메인 컨트롤러 실행 완료....", locale);
		
		HttpSession session = request.getSession();
		
		String hotItemJson = mainService.hotItem();
		
		model.addAttribute("hotItem",hotItemJson);
		
		if(session.getAttribute("email") != null){
			
			String email = (String)session.getAttribute("email");
			
			List<SaleVO> preferList = mainService.preferList(email);
			
			JSONArray jsonArray = JSONArray.fromObject(preferList);
			
			String json = jsonArray.toString();
			
			try {
				
				json = URLEncoder.encode(json, "utf-8");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			System.out.println(json);
			
			model.addAttribute("preferList",json);
			
		}
		
		return "main";
	}
	
	@ResponseBody
	@RequestMapping(value="/newItem",method=RequestMethod.GET)
	public ResponseEntity<String> newItem(){
		
		ResponseEntity<String> entity = null;
		
		String json = mainService.newItem();

		entity = new ResponseEntity<String>(json,HttpStatus.OK);
		
		return entity;
		
	}
	
	@RequestMapping(value="/mainSignupForm", method=RequestMethod.GET)
	public void go(){}
	
	@RequestMapping(value="/mainSignupForm2", method=RequestMethod.GET)
	public String mainSignupForm2(){ 
		
		return "/mainSignupForm2";
		
	}
	
	//회원가입 처리
	@RequestMapping(value="/mainSignupForm2", method=RequestMethod.POST)
	public String mainSignupProc(MemberVO vo, 
			@RequestParam("resident_id") String[] resi,
			@RequestParam("address") String[] adr,
			@RequestParam("interests") String[] inter,
			@RequestParam("password") String pass)throws Exception{
		
		vo.setResident_id(resi[0] + '-' + resi[1]);
		vo.setAddress(adr[0] + '/' + adr[1] + '/' + adr[2]);
		vo.setInterests_1(inter[0]);
		vo.setInterests_2(inter[1]);
		vo.setInterests_3(inter[2]);
		
		service.signupProc(vo, pass);
		return "redirect:/";
	}
	
	@RequestMapping(value="aucList", method=RequestMethod.GET)
	public void aucList(HttpServletRequest request, Model model){
		
		HttpSession session = request.getSession();
		
		List<AuctionListVO> list = mainService.auctionList(session);
		
		model.addAttribute("list",list);
		
	}
	
	
	@RequestMapping(value="/purchaseList", method=RequestMethod.GET)
	public void purchaseList(HttpServletRequest request, Model model){
				
	}
	
	@RequestMapping(value="paymentList", method=RequestMethod.GET)
	public void saleList(HttpServletRequest request, Model model){
		
		HttpSession session = request.getSession();
		
		List<PurchaseListVO> list = mainService.paymentList(session);
		
		model.addAttribute("list",list);
		
	}

	//2016/12/03 우성 추가
	@RequestMapping(value="/preferListProc",method=RequestMethod.GET)
	public String preferListProc(HttpServletRequest request){
		
		String prev_URL = request.getHeader("referer");
		String url = Path.getInstance().determine_url(prev_URL);
		
		
		if(url.equals("/") && url.equals("preferListProc")){
			return "redirect:/";
		}
		
		return "redirect:"+url;
	}
	
}

