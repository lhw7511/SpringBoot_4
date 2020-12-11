package com.iu.sb4.schedule;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.notice.NoticeMapper;
import com.iu.sb4.board.notice.NoticeService;
import com.iu.sb4.util.Pager;

@Component
public class CustomSchedule {
	
	@Autowired
	 private NoticeService noticeService;
	   //@Scheduled(fixedRate = 1000, initialDelay = 2000)
	   //@Scheduled(fixedRateString = "1000", initialDelayString = "2000")
//	   public void fixedRateTest() throws Exception{
//	      
//	      System.out.println("----------Fix Rate Test----------");
//	   }
//	   @Scheduled(fixedDelay = 1000, initialDelay = 2000)
//	   public void fixedDelayTest() throws Exception{
//	      
//	      System.out.println("--------Fixed Delay Test------");
//	   }
	   
//		@Scheduled(cron = " 10 * * * * * ")
//	   public void cronTest()throws Exception{
//			Pager pager = new Pager();
//			List<BoardVO> boardVOs = noticeService.getList(pager);
//			
//			for(int i=0;i<boardVOs.size();i++) {
//				System.out.println(boardVOs.get(i).getTitle());
//			}
//	   }
	}