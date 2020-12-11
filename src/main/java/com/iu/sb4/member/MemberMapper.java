package com.iu.sb4.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public int setInsert(MemberVO memberVO)throws Exception;
	
	public int setFileInsert(MemberFile memberFile)throws Exception;
	
	public MemberVO getIdCheck(MemberVO memberVO)throws Exception;
	
	public MemberVO getMemberLogin(MemberVO memberVO)throws Exception;
	
	public MemberVO getOne(MemberVO memberVO) throws Exception;
}
