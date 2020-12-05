package com.iu.sb4.board.notice;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
//	@GetMapping("noticeFileDown")
//	public ModelAndView getNoticeFileDown(FileVO fileVO) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		return mv;
//	}
	
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(NoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeVO=(NoticeVO) noticeService.getOne(noticeVO);
		mv.addObject("dto", noticeVO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> boardVOs = noticeService.getList(pager);
		mv.addObject("list", boardVOs);
		mv.addObject("board", "notice");
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView  setInsert()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(NoticeVO noticeVO, MultipartFile[] files )throws Exception{
		
		
		ModelAndView mv = new ModelAndView();
		String message="작성 실패!";
		int result=noticeService.setInsert(noticeVO,files);
		if(result>0) {
			message="작성 성공!";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		return mv;
	}
}
