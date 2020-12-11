package com.iu.sb4.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.sb4.member.MemberRoleVO;
import com.iu.sb4.member.MemberVO;

@Component
public class NoticeMemberAdminInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO memberVO=(MemberVO) session.getAttribute("member");
		
		boolean check =false;
		if(memberVO!=null) {
			for(MemberRoleVO roleVO:memberVO.getMemberRoleVOs()) {
				if(roleVO.getRole().equals("member")) {
					check=true;
					break;
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
