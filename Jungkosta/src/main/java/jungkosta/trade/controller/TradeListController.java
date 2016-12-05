package jungkosta.trade.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.trade.domain.SaleVO;
import jungkosta.trade.service.SaleService;
import jungkosta.trade.service.TradeService;

@Controller
public class TradeListController {

	@Inject
	private SaleService service_tw;
	
	@Inject
	private TradeService service;
	

	//카테고리별 목록_ysi
	@RequestMapping(value = "/tradeList", method=RequestMethod.GET)
	public void tradelistSub(Model model, @RequestParam("subca_id") Integer subca_id, String sort) throws Exception{
		System.out.println("1");
		List<SaleVO> salevo = service.listSale(subca_id, sort);
		for(int i = 0 ; i < salevo.size();i++){
			System.out.println(salevo.get(i).toString());
		}
		System.out.println(salevo);
		model.addAttribute("list", salevo);
		System.out.println("2");
		
		
	}
	
	//tradeList 정렬_ysi
	@ResponseBody
	@RequestMapping(value= "/listSale/{subca_id}/{sort}")
	public List<SaleVO> sortAjax( 
			@PathVariable("sort") String sort, 
			@PathVariable("subca_id") Integer subca_id) throws Exception {
		
		return service.listSale(subca_id, sort);
	}
	
	@RequestMapping(value = "/item_pic/{sale_id}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> item_picList(@PathVariable("sale_id") int sale_id) throws Exception {
		ResponseEntity<List<String>> entity = null;

		try {

			List<String> item_list = service_tw.getThunbnail(sale_id);
			entity = new ResponseEntity<List<String>>(item_list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
}
