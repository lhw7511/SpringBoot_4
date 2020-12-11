<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../templates/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../templates/header.jsp"></c:import>
<p>${member.id}</p>
<p>${member.name}</p>
<c:forEach items="${member.memberRoleVOs}" var="dto">
<p>${dto.role}</p>
</c:forEach>
<div class="container">
		<table class="table">
		
			<tr>
				<th>ID</th> <td>${vo.id}</td>
			</tr>		
			<tr>
				<th>NAME</th> <td>${vo.name}</td>
			</tr>
			<tr>
				<th>AGE</th> <td>${vo.age}</td>
			</tr>	
			<tr>
				<th>Email</th> <td>${vo.email}</td>
			</tr>
		</table>
		
		<c:forEach items="${vo.memberFiles}" var="dto">
		 <div>
		 	<img  style="width: 100px; height: 100px;" alt="" src="../upload/member/${dto.fileName}">
		 </div>
		</c:forEach>
		</div>
</body>
</html>