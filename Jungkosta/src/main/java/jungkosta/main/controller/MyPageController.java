package jungkosta.main.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.main.domain.AucAndSaleVO;
import jungkosta.main.domain.AucPurVO;
import jungkosta.main.domain.MemberVO;
import jungkosta.main.service.MyPageService;
import jungkosta.main.service.SignupService;

@Controller
public class MyPageController {

	@Inject
	private MyPageService service;

	@Inject
	private SignupService memberService;

	@RequestMapping("/sale_info")
	public void sale_info() throws Exception {

	}

	@ResponseBody
	@RequestMapping("/getAucSale")
	public ResponseEntity<List<AucAndSaleVO>> getAucSale(HttpServletRequest request) throws Exception {
		ResponseEntity<List<AucAndSaleVO>> entity = null;

		try {

			String email = (String) request.getSession().getAttribute("email");
			List<AucAndSaleVO> list = service.readMyAucSale(email);
			
			for(AucAndSaleVO vo : list){
				int cost = service.bestBiddingCost(vo.getAuction_id());
				vo.setBidding_cost(cost);
				System.out.println(vo);
			}
			
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping("/purchase_info")
	public void purchase_info(HttpServletRequest request, Model model) throws Exception {

		String email = (String) request.getSession().getAttribute("email");

		MemberVO member = memberService.selectMemberService(email);

		model.addAttribute("member", member);

	}

	@ResponseBody
	@RequestMapping("/getAucPurList")
	public ResponseEntity<List<AucPurVO>> getAucPurList(HttpServletRequest request) throws Exception {
		ResponseEntity<List<AucPurVO>> entity = null;

		try {

			String email = (String) request.getSession().getAttribute("email");

			List<AucPurVO> list = service.readMyAucPur(email);

			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}
