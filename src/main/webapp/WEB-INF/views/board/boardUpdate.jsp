<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../templates/bootStrap.jsp"></c:import>
<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
<c:import url="../templates/header.jsp"></c:import>

<div class="container">
	<h1>${board}Update</h1>

	<form action="./${board}Update" method="post" enctype="multipart/form-data">
	<input type="hidden" id="num"  name="num" value="${dto.num}">
    <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title" value="${dto.title}">
    </div>
    <div class="form-group">
      <label for="writer">작성자:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${dto.writer}" readonly="readonly">
    </div>
   <div class="form-group">
      <label for="contents">내용</label>
      <textarea class="form-control" rows="5" id="contents" name="contents">${dto.contents}</textarea>
    </div>
    
    
    <button type="submit" class="btn btn-default">수정</button>
  </form>
</div>
<script type="text/javascript">
	$("#contents").summernote({
		height:300
		});
</script>
</body>
</html>