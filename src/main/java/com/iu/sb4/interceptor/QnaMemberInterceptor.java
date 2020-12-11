package com.iu.sb4.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.sb4.board.qna.QnaMapper;
import com.iu.sb4.board.qna.QnaVO;
import com.iu.sb4.member.MemberRoleVO;
import com.iu.sb4.member.MemberVO;

@Component
public class QnaMemberInterceptor implements HandlerInterceptor{
	
	@Autowired
	private QnaMapper qnaMapper;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean check=false;
		HttpSession session=request.getSession();
		MemberVO memberVO= (MemberVO) session.getAttribute("member");
		int start=request.getRequestURI().lastIndexOf("/")+1;
		String uri=request.getRequestURI().substring(start);
		
		
		if(memberVO!=null) {
			for(MemberRoleVO roleVO:memberVO.getMemberRoleVOs()) {
				if(roleVO.getRole().equals("member")) {
					if(uri.equals("qnaSelect")||uri.equals("qnaReply")) {
						check=true;
						break;
					}else if(uri.equals("qnaUpdate")||uri.equals("qnaDelete")) {
						 long num=	Long.parseLong(request.getParameter("num"));
						 QnaVO qnaVO= new QnaVO();
						 qnaVO.setNum(num);
						 qnaVO=(QnaVO) qnaMapper.getOne(qnaVO);
						 String writer=qnaVO.getWriter();
						 String id=memberVO.getId();
						 if(writer.equals(id)) {
							 check=true;
							 break;
						 }
					}
				}
				
			}
		}
		
		if(!check) {
			request.setAttribute("msg", "권한이 없습니다");
			request.setAttribute("path", "../");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		
		return check;
	}
}
