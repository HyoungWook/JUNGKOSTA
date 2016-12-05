package jungkosta.main.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jungkosta.main.domain.MessageVO;
import jungkosta.main.service.MessageService;

@Controller
public class MessageController {
	
	
	@Inject
	private MessageService service;
	
	@RequestMapping(value="/messageSendForm",method=RequestMethod.GET)
	public void messageSendForm(){
		
	}
	
	@RequestMapping(value="/messageSendProc",method=RequestMethod.POST)
	public String messageSendProc(HttpServletRequest request,MessageVO vo){
		
		service.insertMessage(vo);
		
		return "redirect:messageSendForm";
		
	}
	
	@RequestMapping(value="/messageReceiveForm",method=RequestMethod.GET)
	public void messageReceiveForm(Model model, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		String email = (String)session.getAttribute("email");
		if (email != null) {
			List<MessageVO> list = service.messageList(email);

			if (list != null)
				model.addAttribute("list", list);
		}
	}
	
	@RequestMapping(value="/messageDetailForm/{mid}",method=RequestMethod.GET)
	public String messageDetailForm(@PathVariable("mid") Integer mid,Model model){
		
		MessageVO vo = service.selectMessage(mid);
		
		if(vo != null){
			model.addAttribute("message",vo);
		}
		
		return "messageDetailForm";
	}
	
	@ResponseBody
	@RequestMapping(value="/messageCheck",method=RequestMethod.POST)
	public ResponseEntity<Integer> messageCheck(HttpServletRequest request){
		
		
		String email = (String)request.getAttribute("email");
		
		ResponseEntity<Integer> entity=null;
		
		if(email != null)
		{
			entity = new ResponseEntity<Integer>(service.messageCheck(email),HttpStatus.OK);
		}
		else{
			entity = new ResponseEntity<Integer>(0,HttpStatus.OK);
		}
		
		return entity;
	}
}
