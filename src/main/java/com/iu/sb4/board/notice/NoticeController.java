package com.iu.sb4.board.notice;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.board.qna.QnaVO;
import com.iu.sb4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@Value("${board.notice.filePath}")
	private String filePath;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "notice";
	}
	
	
	@GetMapping("noticeDelete")
	public ModelAndView setDelete(NoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		String message="삭제 실패!";
		int result=noticeService.setDelete(noticeVO);
		if(result>0) {
			message="삭제 성공!";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate2(NoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		String message="수정 실패!";
		int result=noticeService.setUpdate(noticeVO);
		if(result>0) {
			message="수정 성공!";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(NoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO=noticeService.getOne(noticeVO);
		mv.addObject("dto", boardVO);
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	
	
	@GetMapping("noticeFileDown")
	public ModelAndView getNoticeFileDown(FileVO fileVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		fileVO = noticeService.getFile(fileVO);
		mv.addObject("fileVO", fileVO);
		mv.addObject("filePath", filePath);
		mv.setViewName("fileDown");
		return mv;
	}
	
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(NoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeVO=(NoticeVO) noticeService.getOne(noticeVO);
		mv.addObject("dto", noticeVO);
		//mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BoardVO> boardVOs = noticeService.getList(pager);
		mv.addObject("list", boardVOs);
//		mv.addObject("board", "notice");
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public String setInsert(BoardVO boardVO)throws Exception{
		
		return "board/boardWrite";
	}
	
	@PostMapping("noticeWrite")
	public String setInsert(@Valid BoardVO boardVO,BindingResult bindingResult,MultipartFile[] files)throws Exception{
		System.out.println("notice Write");
		
		if(bindingResult.hasErrors()) {
			System.out.println("검증실패");
			
			return "board/boardWrite";
		}
		
		
		
		int result=noticeService.setInsert(boardVO,files);
		return "redirect:notice/noticeList";
	}
}
