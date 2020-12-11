package com.iu.sb4.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberPage")
	public ModelAndView  getOne(MemberVO memberVO,HttpSession session)throws Exception{
		memberVO=(MemberVO) session.getAttribute("member");
		memberVO=memberService.getOne(memberVO);
		
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("vo", memberVO);
		 mv.setViewName("member/memberPage");
		 return mv;
	}
	
	@GetMapping("memberLogout")
	public ModelAndView setMemberLogout(HttpSession session) {
		 session.invalidate();
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("msg", "로그아웃성공");
		 mv.addObject("path", "../");
		 mv.setViewName("common/result");
		 return mv;
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberVO memberVO,HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.getMemberLogin(memberVO);
		
		if(memberVO==null) {
			mv.addObject("msg", "로그인 실패");
			mv.addObject("path", "./memberLogin");
			 mv.setViewName("common/result");
		}else {
			
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}
		return mv;
	}
	@GetMapping("memberLogin")
	public void getMemberLogin() {
		
	}
	@GetMapping("memberJoin")
	public void setInsert(MemberVO memberVO) {
		
	}
	
	@PostMapping("memberJoin")
	public ModelAndView setInsert(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile[] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		if(memberService.getMemberError(memberVO, bindingResult)) {
			System.out.println("검증실패");
			mv.setViewName("member/memberJoin");
			return mv;
		}
		
		
		String message="가입 실패!";
		int result= memberService.setInsert(memberVO,files);
		if(result>0) {
			message="가입 성공!";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		return mv;
	}
	
	@PostMapping("memberIdCheck")
	public ModelAndView getIdCheck(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO=memberService.getIdCheck(memberVO);
		int result=0;
		if(memberVO==null) {
			result=1;
		}
		mv.addObject("msg",result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
}
