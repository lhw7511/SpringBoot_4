package com.iu.sb4.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.sb4.board.BoardVO;
import com.iu.sb4.util.Pager;

@SpringBootTest
class NoticeMapperTest {
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void getList() throws Exception{
		Pager pager = new Pager();
		
		pager.makeRow();
		pager.setTotalCount(noticeMapper.getCount(pager));
		System.out.println(pager.getTotalCount());
		List<BoardVO> boardVOs = noticeMapper.getList(pager);
	}
	
//	@Test
//	void setInsertTest() throws Exception {
//		for(int i=3;i<103;i++) {
//			NoticeVO noticeVO = new NoticeVO();
//			noticeVO.setTitle("title test"+i);
//			noticeVO.setWriter("writer test"+i);
//			noticeVO.setContents("contents test"+i);
//			
//			int result=noticeMapper.setInsert(noticeVO);
//			if(i%10==0) {
//				Thread.sleep(1000);
//			}
//		}
//		
//		
//	}
	
//	@Test
//	void setUpdateTest() throws Exception{
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setNum(3);
//		noticeVO.setTitle("title test2 update");
//		noticeVO.setContents("contents test2 update");
//		
//		int result=noticeMapper.setUpdate(noticeVO);
//		assertNotEquals(0, result);
//	}
	
//	@Test
//	void setDeleteTest() throws Exception{
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setNum(1);
//		int result = noticeMapper.setDelete(noticeVO);
//		assertNotEquals(0, result);
//	}
	
//	@Test
//	void getOneTest() throws Exception{
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setNum(2);
//		noticeVO= (NoticeVO) noticeMapper.getOne(noticeVO);
//		assertNotNull(noticeVO);
//		
//		
//	}
}
