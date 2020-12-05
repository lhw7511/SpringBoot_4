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
	<h1>${board}Write</h1>

	<form action="./${board}Write" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    <div class="form-group">
      <label for="writer">작성자:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
    </div>
   <div class="form-group">
      <label for="contents">내용</label>
      <textarea class="form-control" rows="5" id="contents" name="contents"></textarea>
    </div>
    
    <div class="form-group">
      <label for="files">파일:</label>
      <input type="file" class="form-control"   name="files">
       <input type="file" class="form-control"   name="files">
    </div>
    <button type="submit" class="btn btn-default">작성</button>
  </form>
</div>
<script type="text/javascript">
	$("#contents").summernote({
		height:300
		});
</script>
</body>
</html>