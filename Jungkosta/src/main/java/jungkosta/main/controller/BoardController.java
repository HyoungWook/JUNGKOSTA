package jungkosta.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jungkosta.commons.util.Path;
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
		
		List<BoardVO> list = null;
		
		Integer value = service.boardCount();
		
		int totalCount = 0;
		int totalPageCount = 0;
		int startPage = 0;
		int endPage = 0;
		int startRow = 0;
		
		if(value == null){
			totalCount = 0;
		}else{
			totalCount = value;
		}
		totalPageCount = totalCount/PAGE_SIZE;
		
		if(totalCount % PAGE_SIZE > 0){
			totalPageCount++;
		}
		
		startPage = bno-(bno-1)%5;
		endPage = startPage+4;
		
		if(endPage > totalPageCount)
			endPage = totalPageCount;
		
		startRow = (bno-1)*PAGE_SIZE;
		
		list = service.boardList(startRow);
		
		Listmodel listModel =  new Listmodel(list, bno, totalPageCount, startPage, endPage);
		
		model.addAttribute("list", list);
		model.addAttribute("listModel", listModel);
		
		return "boardList";
	}
}
