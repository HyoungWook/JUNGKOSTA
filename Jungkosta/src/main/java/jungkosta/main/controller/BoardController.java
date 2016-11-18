package jungkosta.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.main.domain.BoardVO;
import jungkosta.main.domain.Listmodel;
import jungkosta.main.service.BoardService;


@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	
	public static final int PAGE_SIZE = 10;
	
	@RequestMapping(value="boardWriteForm",method=RequestMethod.GET)
	public String boardWriteForm(){
		
		return "boardWriteForm";
	}
	
	@RequestMapping(value="boardWriteProc",method=RequestMethod.POST)
	public String boardWriteProc(BoardVO vo)throws Exception{
		
		service.boardInsert(vo);
		
		return "redirect:boardWriteForm";
		
	}
	
	@RequestMapping(value="boardList/{bno}",method=RequestMethod.GET)
	public String boardList(@PathVariable("bno") Integer bno, Model model)throws Exception{
		
		String url = "/boardList/"+bno;
		ArrayList<BoardVO> list = null;
		
		System.out.println(bno);
		
		return url;
	}
}
