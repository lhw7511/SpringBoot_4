package com.iu.sb4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.sb4.interceptor.CustomInterceptor;
import com.iu.sb4.interceptor.NoticeAdminInterceptor;
import com.iu.sb4.interceptor.NoticeMemberAdminInterceptor;
import com.iu.sb4.interceptor.QnaMemberInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private CustomInterceptor customInterceptor;
	@Autowired
	private NoticeAdminInterceptor noticeAdminInterceptor;
	@Autowired
	private NoticeMemberAdminInterceptor noticeMemberAdminInterceptor;
	@Autowired
	private QnaMemberInterceptor qnaMemberInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		//적용 할  인터셉터 등록
//		
//		registry.addInterceptor(customInterceptor).
//		//인터셉터에서 사용할 url등록
//		addPathPatterns("/notice/**")
//		//.addPathPatterns(patterns)
//		
//		//인터셉터에서 제외할 url
//		.excludePathPatterns("/notice/noticeWrite");
		
		registry.addInterceptor(noticeAdminInterceptor)
		.addPathPatterns("/notice/noticeWrite")
		.addPathPatterns("/notice/noticeUpdate")
		.addPathPatterns("/notice/noticeDelete");
		
		registry.addInterceptor(noticeMemberAdminInterceptor)
		.addPathPatterns("/notice/noticeSelect");
		
		registry.addInterceptor(qnaMemberInterceptor)
		.addPathPatterns("/qna/**")
		.excludePathPatterns("/qna/qnaList")
		.excludePathPatterns("/qna/qnaFileDown")
		.excludePathPatterns("/qna/qnaWrite");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
