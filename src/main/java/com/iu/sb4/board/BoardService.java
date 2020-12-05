package com.iu.sb4.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iu.sb4.util.Pager;

public interface BoardService {

	public int setInsert(BoardVO boardVO,MultipartFile[] files)throws Exception;
	
	public BoardVO getOne(BoardVO boardVO)throws Exception;
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public int setDelete(BoardVO boardVO)throws Exception;
	
	public int setUpdate(BoardVO boardVO)throws Exception;
	
	public long getCount(Pager pager)throws Exception;
}
