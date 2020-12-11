package com.iu.sb4.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iu.sb4.board.notice.NoticeService;
import com.iu.sb4.util.Pager;

@RestController
@RequestMapping("/board/**")
public class BoardController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("boardSelect")
	@ResponseBody
	public BoardVO boardSelect(BoardVO boardVO)throws Exception{
		boardVO=noticeService.getOne(boardVO);
//		String result="{";
//		result=result+"\"num\":"+boardVO.getNum()+",";
//		result=result+"\"title\":\""+boardVO.getTitle()+"\",";
//		result=result+"\"writer\":\""+boardVO.getWriter()+"\",";
//		result=result+"\"contents\":\""+boardVO.getContents()+"\"}";
//		
//		System.out.println(result);
		return boardVO;
	}
	
	@GetMapping("boardList")
	@ResponseBody
	public List<BoardVO> boardList(Pager pager) throws Exception{
		 List<BoardVO> boardVOs = noticeService.getList(pager);
		 return boardVOs;
	}
}
