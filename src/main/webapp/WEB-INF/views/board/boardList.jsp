<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../templates/bootStrap.jsp"></c:import>
<script type="text/javascript">
//$(document).ready(function(){
	$(function(){
		$("#writebtn").click(function(){
			location.href="./${board}Write";
		});
		});

//});
</script>
<style type="text/css">
.c1{
 cursor: pointer;
}
</style>
</head>
<body>
<c:import url="../templates/header.jsp"></c:import>
<h1>${board}</h1>
<img alt="" src="../images/list1.gif">
<div class="container">
	
	
	<table class="table table-striped">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>내용</th>
        <th>등록일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="dto">
    	<tr>
        <td>${dto.num}</td>
        <td><a href="./${board}Select?num=${dto.num}">
        <c:catch>
    			<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
    			</c:catch>
        ${dto.title}</a></td>
        <td>${dto.writer}</td>
        <td>${dto.contents}</td>
        <td>${dto.regDate}</td>
        <td>${dto.hit}</td>
      </tr>
    	</c:forEach>   
    </tbody>
  </table>
  			<c:if test="${pager.startNum gt 1}">
    		<span class="c1" title="${pager.startNum-1}">[이전]</span>
    		</c:if>
 			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    				<span  class="c1" title="${i}" id="curPage${i}">${i}</span>
    		</c:forEach>
  			<c:if test="${pager.nextCheck}">
    			<span class="c1" title="${pager.lastNum+1}">[다음]</span>
    		</c:if>
</div>

<div class="container">
<form action="./${board}List" id="frm">
	<div class="input-group">
			<input type="hidden" name="curPage" id="curPage">
    		 <select id="kind" class="input-group-sm" name="kind">
   				 	<option value="tt" >Title</option>
    				<option value="wr">Writer</option>
   					 <option value="con">Contents</option>			
  			</select>
    		<input id="search" type="text" class="form-control" name="search" placeholder="검색">
    		</div>
    		<div class="input-group-btn">
      		<button class="btn btn-default" type="submit">
       		 <i class="glyphicon glyphicon-search"></i>
     		 </button>
 	 </div>
 	 </form>
 	 <button class="btn btn-info" id="writebtn">글쓰기</button>
</div>

<script type="text/javascript">
	$("#curPage"+${pager.curPage}).css("color","red");
	var kind ='${pager.kind}';
	var search='${pager.search}';
	if(kind==''){
		$("#kind").val("tt");
	}else{
		$("#kind").val(kind);
	}
	$("#search").val(search);
	
		$(".c1").click(function(){
			 var t=$(this).attr("title");
			$("#curPage").val(t);
			$("#frm").submit();
			});
</script>

</body>
</html>