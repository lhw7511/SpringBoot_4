package com.iu.sb4.util;

import lombok.Data;

@Data
public class Pager {
	
	
	//mysql은 lastRow 필요없음
	private long startRow;
	private Integer curPage;
	private long perPage; //한페이지당 보여지는 개수
	private long totalCount;
	private long startNum;
	private long lastNum;
	private boolean nextCheck;
	private long perBlock;
	//검색 관련 변수
		private String kind;
		private String search;
	
	
	public Pager() {
		this.perPage=10;
		this.perBlock=5;
	}
	
	public void makeRow() {
		//startRow계산
		startRow=(this.getCurPage()-1)*this.getPerPage();
	}
	public void makePage() {
		//전체 페에지의 개수
		long totalPage=this.getTotalCount()/this.getPerPage();
		if(this.getTotalCount()%this.getPerPage()!=0) {
			totalPage++;
		}
		//전체 블럭의 개수
		long totalBlock=totalPage/5;
		if(totalPage%this.getPerBlock()!=0) {
			totalBlock++;
		}
		
		//현재페이지를 이용해서 현재블럭 번호를찾기
		long curBlock = this.getCurPage()/this.getPerBlock();
		if(this.getCurPage()%this.getPerBlock()!=0) {
			curBlock++;
			}
		
		//현재블럭번호로 시작번호 끝번호 계산
		 this.startNum=(curBlock-1)*this.getPerBlock()+1;
		 this.lastNum=curBlock*this.getPerBlock();
		
		
		//현재 블럭번호와 전체블럭 번호가 같은지 판단
		 this.nextCheck=true;
		if(curBlock == totalBlock) {
			nextCheck= !nextCheck;
			lastNum=totalPage;
		}
		
		
	}
	public long getTotalCount() {
		if(this.totalCount==0) {
			this.totalCount=1;
		}
		return totalCount;
	}
	
	public int getCurPage() {
		if(this.curPage==null) {
			this.curPage=1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		if(curPage==null) {
			curPage=1;
			
		}
		this.curPage=curPage;
	}
	
	public String getSearch() {
		if(search==null) {
			search="";
		}
		return search;
	}
	public String getKind() {
		if(kind==null) {
			kind="tt";
		}
		return kind;
	}
}
