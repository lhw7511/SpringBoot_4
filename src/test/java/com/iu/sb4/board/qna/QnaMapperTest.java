package com.iu.sb4.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaMapperTest {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@Test
	void setInsertTest() throws Exception {
		for(int i=2;i<101;i++) {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("qna title test"+i);
		qnaVO.setWriter("qna writer test"+i);
		qnaVO.setContents("qna contents test"+i);
		
		int result=qnaMapper.setInsert(qnaVO);
		if(i%10==0) {
			Thread.sleep(1000);
		}
	}
	}

}
