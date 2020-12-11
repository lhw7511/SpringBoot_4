package com.iu.sb4.board.qna;

import java.util.List;

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
import com.iu.sb4.board.notice.NoticeVO;
import com.iu.sb4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	@Value("${board.qna.filePath}")
	private String filePath;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("qnaFileDown")
	public ModelAndView getNoticeFileDown(FileVO fileVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		fileVO = qnaService.getFile(fileVO);
		mv.addObject("fileVO", fileVO);
		mv.addObject("filePath", filePath);
		mv.setViewName("fileDown");
		return mv;
	}
	
	@GetMapping("qnaReply")
	public String setReply(long num)throws Exception{
		return "qna/qnaReply";
	}
	@PostMapping("qnaReply")
	public ModelAndView setReply(QnaVO qnaVO) throws Exception{
		System.out.println(qnaVO.getNum());
		ModelAndView mv = new ModelAndView();
		String message="작성 실패!";
		int result=qnaService.setReply(qnaVO);
		if(result>0) {
			message="작성 성공!";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView setUpdate2(QnaVO qnaVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		String message="수정 실패!";
		int result=qnaService.setUpdate(qnaVO);
		if(result>0) {
			message="수정 성공!";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(QnaVO qnaVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO=qnaService.getOne(qnaVO);
		mv.addObject("dto", boardVO);
		//mv.addObject("board", "qna");
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@GetMapping("qnaDelete")
	public ModelAndView setDelete(QnaVO qnaVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		String message="삭제 실패!";
		int result=qnaService.setDelete(qnaVO);
		if(result>0) {
			message="삭제 성공!";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(QnaVO qnaVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		qnaVO=(QnaVO) qnaService.getOne(qnaVO);
		mv.addObject("dto", qnaVO);
		//mv.addObject("board", "qna");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	@GetMapping("qnaList")
	public ModelAndView  getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardVO> boardVOs=qnaService.getList(pager);
		mv.addObject("list", boardVOs);
		//mv.addObject("board", "qna");
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		//mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(@Valid BoardVO boardVO,BindingResult bindingResult, MultipartFile[] files)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			System.out.println("검증실패");
			mv.setViewName("board/boardWrite");
			return mv;
			
		}
		String message="작성 실패!";
		int result=qnaService.setInsert(boardVO,files);
		if(result>0) {
			message="작성 성공!";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		return mv;
	}
	
}
