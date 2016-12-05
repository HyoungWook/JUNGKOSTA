package jungkosta.main.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.main.domain.BlackListVO;
import jungkosta.main.domain.MessageVO;
import jungkosta.main.service.ManagerService;

@Controller
public class ManagerController {

	
	@Inject
	private ManagerService service;
	
	@RequestMapping(value="/customSearchForm",method=RequestMethod.GET)
	public void customSearchForm(){
		
	}
	
	@ResponseBody
	@RequestMapping(value="/customSearchProc",method=RequestMethod.POST)
	public ResponseEntity<String> customSearch(@RequestParam("name") String name,HttpServletResponse response){
		
		response.setContentType("text/html; charset=utf-8");
		
		ResponseEntity<String> entity = null;
		
		String json = service.customSearch(name);
		
		if(json != null){
			System.out.println(json);
			entity = new ResponseEntity<String>(json,HttpStatus.OK);
			
		}else
			entity = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		
		return entity;
	}
	
	@RequestMapping(value="/blackListForm",method=RequestMethod.GET)
	public void blackListForm(){
		
	}
	
	@ResponseBody
	@RequestMapping(value="/blackListProc",method=RequestMethod.POST)
	public ResponseEntity<String> blackListProc(@RequestParam("admin") String admin,
												@RequestParam("id") String id,
												@RequestParam("reason") String reason){
		
		ResponseEntity<String> entity = null;
		
		
		BlackListVO vo = new BlackListVO();
		
		vo.setEmail(id);
		vo.setReason(reason);
		
		String result = service.insertBlackList(vo, admin);
		
		entity = new ResponseEntity<String>(result,HttpStatus.OK);
		
		return entity;
		
	}
	
	@RequestMapping(value="/warningForm",method=RequestMethod.GET)
	public void warningForm(@RequestParam("id") String id, Model model){
		
		model.addAttribute("member",service.emailSearch(id));
		
	}
	
	@ResponseBody
	@RequestMapping(value="/warningProc",method=RequestMethod.POST)
	public ResponseEntity<String> warningProc(@RequestParam("title") String title, @RequestParam("sender") String sender,
											  @RequestParam("receiver") String receiver, @RequestParam("content") String content,
											  @RequestParam("warning_num") String warning_num)
	{
		ResponseEntity<String> entity = null;
		MessageVO vo = new MessageVO();
		
		vo.setContent(content);
		vo.setMessage_isread("N");
		vo.setReceiver(receiver);
		vo.setSender(sender);
		vo.setTitle(title);
		
		String result = service.editWarningNum(vo, warning_num);
		
		entity = new ResponseEntity<String>(result,HttpStatus.OK);
		
		return entity;
	}
}
