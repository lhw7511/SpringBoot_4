<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="./${board}Write" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    <div class="form-group">
      <label for="writer">작성자:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${member.id}" readonly="readonly">
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