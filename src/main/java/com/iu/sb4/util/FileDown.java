package com.iu.sb4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.sb4.board.file.FileVO;

@Component("fileDown")
public class FileDown extends AbstractView{
	
	@Autowired
    private ResourceLoader resourceLoader;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//1. 파일이  저장된  경로 설정
		String path = "classpath:/static/";
		path = path + (String)model.get("filePath");
		//2. 저장된 경로와 저장된 파일명 합치기
		FileVO fileVO =(FileVO)model.get("fileVO");
		path = path+"/"+fileVO.getFileName();
		
		//3. 위의 정보를 담는 파일 객체 생성
				File file = resourceLoader.getResource(path).getFile();
				
				//한글 처리
				response.setCharacterEncoding("UTF-8");
				
				//총 파일의 크기
				response.setContentLengthLong(file.length());
				
				//다운로드시 파일 이름을 인코딩 처리
				String fileName = URLEncoder.encode(fileVO.getOriName(), "UTF-8");
				
				//header 설정
				response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"" );
				response.setHeader("Content-Transfer-Encoding", "binary");
				
				//HDD에서 파일을 읽고
				FileInputStream fi = new FileInputStream(file);
				//Client로 전송 준비
				OutputStream os = response.getOutputStream();
				
				//전송
				FileCopyUtils.copy(fi, os);
				
				os.close();
				fi.close();
		
	}

}
