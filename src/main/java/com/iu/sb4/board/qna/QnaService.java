package com.iu.sb4.board.qna;

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
public class QnaService implements BoardService{

	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileManager fileManager;
	@Value("${board.qna.filePath}")
	private String filePath;
	
	
	
	
	public int setReply(BoardVO boardVO)throws Exception {
		int result=qnaMapper.setReplyUpdate(boardVO);
		result=qnaMapper.setReply(boardVO);
		return result;
	}
	
	@Override
	public int setInsert(BoardVO boardVO, MultipartFile[] files) throws Exception {
		int result=qnaMapper.setInsert(boardVO);
		if(result>0) {
			result=qnaMapper.setInsertRefUpdate(boardVO);
		}
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
					result=qnaMapper.setInsertFile(fileVO);
				} 
		 }
		
		return  result;
	}
	

	@Override
	public BoardVO getOne(BoardVO boardVO) throws Exception {
		return qnaMapper.getOne(boardVO);
	}

	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(qnaMapper.getCount(pager));
		pager.makePage();
		return qnaMapper.getList(pager);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		List<FileVO> fileVOs = qnaMapper.getFileList(boardVO);
		boolean check=true;
		int result=0;
		for(int i=0;i<fileVOs.size();i++) {
			check=filePathGenerator.setDeleteFile(fileVOs.get(i).getFileName(), filePath);
		}
		if(check) {
			result=qnaMapper.setDelete(boardVO);
		}
		return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		return qnaMapper.setUpdate(boardVO);
	}

	@Override
	public long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
