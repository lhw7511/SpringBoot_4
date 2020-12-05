package com.iu.sb4.board.notice;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.sb4.board.BoardService;
import com.iu.sb4.board.BoardVO;
import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.util.FileManager;
import com.iu.sb4.util.FilePathGenerator;
import com.iu.sb4.util.Pager;



@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileManager fileManager;
	@Value("${board.notice.filePath}")
	private String filePath;
	@Override
	public int setInsert(BoardVO boardVO,MultipartFile[] files) throws Exception {
		
		int result=noticeMapper.setInsert(boardVO);
		 if(result>0) {
			 File file= filePathGenerator.getUseResourceLoader(filePath);
				for(int i=0 ;i<files.length;i++) {
					if(files[i].getSize()==0) {
						continue;
					}
					String fileName=fileManager.saveFileCopy(files[i], file);
					FileVO fileVO = new FileVO();
					fileVO.setFileName(fileName);
					fileVO.setOriName(files[i].getOriginalFilename());
					fileVO.setNum(boardVO.getNum());
					result=noticeMapper.setInsertFile(fileVO);
				} 
		 }
		
		return  result;
	}

	@Override
	public BoardVO getOne(BoardVO boardVO) throws Exception {
		return noticeMapper.getOne(boardVO);
	}

	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {	
		pager.makeRow();
		pager.setTotalCount(noticeMapper.getCount(pager));
		pager.makePage();
		return noticeMapper.getList(pager);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCount(Pager pager) throws Exception {
		return noticeMapper.getCount(pager);
	}
	
	
}
