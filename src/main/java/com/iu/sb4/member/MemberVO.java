package com.iu.sb4.member;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {
	@NotEmpty
	private String id;
	@NotEmpty
	@Length(max = 12,min = 6)
	private String pw;
	
	private String pw2;
	@NotEmpty
	@Size(min = 2)
	private String name;
	@Range(min =1 , max = 200)
	private int age;
	@Email
	@NotEmpty
	private String email;
	private List<MemberFile> memberFiles;
	private List<MemberRoleVO> memberRoleVOs;
}
