package com.iu.sb4.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAOP {

//	@Before("execution(* com.iu.sb4.board.notice.*Service.get*(..))")
//	public void noticeBefore()throws Exception{
//		System.out.println("Point cut 실행 전--------------------------------");
//	}
//	@After("execution(* com.iu.sb4.board.notice.*Service.get*(..))")
//	public void noticeAfter()throws Exception{
//		System.out.println("Point cut 실행후");
//	}
//	
//	@Around("execution(* com.iu.sb4.board.notice.*Service.set*(..))")
//	public Object noticeAround(ProceedingJoinPoint join)throws Exception{
//		System.out.println("Notice Around Before");
//		
//		
//		Object obj = null;
//	      
//	      try {
//	    	  Object [] ar =join.getArgs();
//	    	  
//	         obj = join.proceed();
//	      } catch (Throwable e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      }
//	      System.out.println("Notice Around After");
//		return obj;
//	}
}
