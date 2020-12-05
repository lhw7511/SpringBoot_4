package com.iu.sb4.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.sb4.board.BoardMapper;
import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;

@Mapper
public interface QnaMapper extends BoardMapper{

	public int setInsertRefUpdate(BoardVO boardVO) throws Exception;
	
	public List<FileVO> getFileList(BoardVO boardVO)throws Exception;
	
	public int setReplyUpdate(BoardVO boardVO)throws Exception;
	
	public int setReply(BoardVO boardVO) throws Exception;
}
