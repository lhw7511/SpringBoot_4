<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../templates/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../templates/header.jsp"></c:import>

<h1>${board} Select Page</h1>

<p>글번호 : ${dto.num}</p>
<p>제목 : ${dto.title}</p>
<p>작성자: ${dto.writer}</p>
<p>내용 : ${dto.contents}</p>
<p>등록일 : ${dto.regDate}</p>
<p>조회수 : ${dto.hit}</p>

<c:forEach items="${dto.fileVOs}" var="vo">
<img alt="" src="../upload/${board}/${vo.fileName}">
<p><a href="./noticeFileDown?fnum=${vo.fnum}">${vo.oriName}</a> </p>
</c:forEach>


<button class="btn btn-info" id="up">수정</button>
<button class="btn btn-danger" id="del">삭제</button>
<c:if test="${board eq 'qna'}">
<button class="btn btn-default" id="reply">답변</button>
</c:if>

<script type="text/javascript">

$("#up").click(function(){
	location.href="./${board}Update?num=${dto.num}";
});

$("#del").click(function(){
	location.href="./${board}Delete?num=${dto.num}";
});

$("#reply").click(function(){
	location.href="./qnaReply?num=${dto.num}";
});
</script>
</body>
</html>