<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link href="./css/index.css" rel="stylesheet">
<c:import url="./templates/bootStrap.jsp"></c:import>
</head>
<body>
	<c:import url="./templates/header.jsp"></c:import>
	<p>Index Page</p>
	
		<c:if test="${not empty member}">
			<h1><spring:message code="member.login.message" arguments="${member.id}"></spring:message> </h1>
			<h1><spring:message code="member.login.message2" arguments="${member.id},${member.name}" argumentSeparator=","></spring:message> </h1>
		</c:if>


	<h1>
		Message :
		<spring:message code="hello"></spring:message>
	</h1>
	
	<h1>
		Name :
		<spring:message code="name" var="n"></spring:message>
	</h1>
	
	<h1>
		Default :
		<spring:message code="use" text="Default message"></spring:message>
	</h1>
	
	<h3>var : ${n}</h3>
	<img alt="" src="./images/list1.gif">
	
	<a href="./rest/member/iu/1">Click</a>
	
	<button class="btn btn-danger" id="btn">Click me</button>
	<button class="btn btn-info" id="btn2">Click me</button>
	
	<div>
		
	</div>
	<script type="text/javascript">
		$("#btn").click(function(){
			$.ajax({
					type :"GET",
					url :"board/boardSelect",
					data:{
							num:2
						},
					success:function(data){
							alert(data);	
						}						
				});

			});

		$("#btn2").click(function(){
			$.ajax({
					type :"GET",
					url :"board/boardList",
					data:{
							curPage:1
						},
					success:function(data){
							for(var i=0;i<data.length;i++){
									console.log(i+1+"번째")	
									console.log(data[i].num);
									console.log(data[i].title);	
									console.log(data[i].writer);	
									console.log(data[i].contents);
											
								}
						}						
				});

			});
           
/*
        $("#btn").click(function(){
             $.get("https://api.manana.kr/exchange.json",function(data){

                   for(var i=0;i<data.length;i++){
							console.log(data[i].kr);
                       }
                 	
                 });
            });    				
*/
	</script>
</body>
</html>