package com.iu.sb4.member;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.iu.sb4.board.file.FileVO;
import com.iu.sb4.util.FileManager;
import com.iu.sb4.util.FilePathGenerator;

@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FilePathGenerator filePathGenerator;
	@Autowired
	private FileManager fileManager;
	@Value("${member.memberJoin.filePath}")
	private String filePath;
	
	public boolean getMemberError(MemberVO memberVO,BindingResult bindingResult)throws Exception{
		boolean result =false;
		//result :false면 성공 true면 검증 실패
		//기본 어노테이션 검증결과
		
		if(bindingResult.hasErrors()) {
			result=true;
		}
		
		//pw가 같은지 검증
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			//bindingResult.rejectValue("멤버변수명", "프로퍼티파일 키값");
			bindingResult.rejectValue("pw2", "memberVO.password.notEqual");
			result=true;
		}
		
		if(memberMapper.getIdCheck(memberVO)!=null) {
			bindingResult.rejectValue("id", "memberVO.id.exist");
			result=true;
		}
		
		return result;
	}
	
	public MemberVO getOne(MemberVO memberVO) throws Exception{
		return memberMapper.getOne(memberVO);
	}
	
	public int setInsert(MemberVO memberVO,MultipartFile[] files)throws Exception{
		int result= memberMapper.setInsert(memberVO);
		if(result>0) {
			 File file= filePathGenerator.getUseResourceLoader(filePath);
				for(int i=0 ;i<files.length;i++) {
					if(files[i].getSize()==0) {
						continue;
					}
					String fileName=fileManager.saveFileCopy(files[i], file);
					MemberFile memberFile = new MemberFile();
					memberFile.setFileName(fileName);
					memberFile.setOriName(files[i].getOriginalFilename());
					memberFile.setId(memberVO.getId());
				
					result=memberMapper.setFileInsert(memberFile);
				} 
			
			
		}
		return result;
	}
	
	public MemberVO getIdCheck(MemberVO memberVO)throws Exception{
		return memberMapper.getIdCheck(memberVO);
	}
	
	public MemberVO getMemberLogin(MemberVO memberVO)throws Exception{
		return memberMapper.getMemberLogin(memberVO);
	}
}
