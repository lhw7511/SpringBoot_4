package com.iu.sb4.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.sb4.board.notice.NoticeMapper;
import com.iu.sb4.board.notice.NoticeVO;
import com.iu.sb4.member.MemberRoleVO;
import com.iu.sb4.member.MemberVO;

@Component
public class NoticeAdminInterceptor implements HandlerInterceptor{
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check =false;
		int start=request.getRequestURI().lastIndexOf("/")+1;
		String uri=request.getRequestURI().substring(start);
		HttpSession session=request.getSession();
		MemberVO memberVO= (MemberVO) session.getAttribute("member");
		

		if(memberVO!=null) {
			
		
				for(MemberRoleVO roleVO:memberVO.getMemberRoleVOs()) {
					if(roleVO.getRole().equals("admin")) {
						if(uri.equals("noticeWrite")) {
							check=true;
							break;
						}else if(uri.equals("noticeUpdate")|| uri.equals("noticeDelete")){
										
							 long num=	Long.parseLong(request.getParameter("num"));
							 NoticeVO noticeVO = new NoticeVO();
							 noticeVO.setNum(num);
							 noticeVO=(NoticeVO) noticeMapper.getOne(noticeVO);
							 String writer=noticeVO.getWriter();
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
