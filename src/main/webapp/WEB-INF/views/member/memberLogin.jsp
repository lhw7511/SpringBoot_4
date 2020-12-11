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

<div class="container">
	<h3>Member Login Page</h3>
	<form action="./memberLogin" method="post">
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter id" name="id" >
    </div>
    <div class="form-group">
      <label for="pw">Password:</label>
      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
    </div>
    <div class="checkbox">
      <label><input type="checkbox" name="remember" value="check"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
	</div>
</body>
</html>