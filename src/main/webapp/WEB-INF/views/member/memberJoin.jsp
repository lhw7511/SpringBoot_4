<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../templates/bootStrap.jsp"></c:import>
<style type="text/css">
		.error{
			color:red;
		}
	</style>
</head>
<body>
<c:import url="../templates/header.jsp"></c:import>
<div class="container">
	<h3>Member Join Page</h3>
	<form:form modelAttribute="memberVO" enctype="multipart/form-data">
				 <div class="form-group">
      <label for="id">ID:</label>
      <form:input path="id" class="form-control"/>
      <form:errors path="id" cssClass="error"></form:errors>
    </div>
    
    
    <div class="form-group">
      <label for="pw">Password:</label>
        <form:password  path="pw" class="form-control"/>
      <form:errors path="pw"  cssClass="error"></form:errors>
     
    </div>
    
    <div class="form-group">
      <label for="pw2">Password Check:</label>
        <form:password  path="pw2" class="form-control"/>
      <form:errors path="pw2"  cssClass="error"></form:errors>
     
    </div>
    
  	
     <div class="form-group">
      <label for="name">NAME:</label>
        <form:input path="name" class="form-control"/>
      <form:errors path="name"  cssClass="error"></form:errors>
     
    </div>
      
     <div class="form-group">
      <label for="age">AGE:</label>
        <form:input path="age" class="form-control"/>
      <form:errors path="age"  cssClass="error"></form:errors>
    
   
    </div>
     <div class="form-group">
      <label for="email">EMAIL:</label>
       <form:input path="email" class="form-control"/>
      <form:errors path="email"  cssClass="error"></form:errors>

    </div>
    
    
    
      <div class="form-group">
      <label for="photo">Photo:</label>
      	<input type="file" class="form-control "  name="files">
       <input type="file" class="form-control "  name="files">
    </div>
     
        <button type="submit" class="btn btn-default" id="btn">Submit</button>
			
	</form:form>
	
	
   	
	</div>
	
	<script type="text/javascript">
	/*
		var idCheck=false;
		var pwCheck=false;
		var nameCheck=false;
		var emailCheck=false;
		
	  $("#name").blur(function(){
		  nameCheck=false;
		 	if($(this).val().length==0){
		 		 $("#nameCheck").text("이름을 입력해주세요");
				  $("#nameCheck").css("color","red");
		 	}else{
		 		 $("#nameCheck").text("");
		 		 nameCheck=true;
		 	}
	  });
	  $("#email").blur(function(){
		  emailCheck=false;
		 	if($(this).val().length==0){
		 		 $("#emailCheck").text("이메일을 입력해주세요");
				  $("#emailCheck").css("color","red");
		 	}else{
		 		 $("#emailCheck").text("");
		 		emailCheck=true;
		 	}
	  });	
	  $("#btn").click(function(){
		
		if(idCheck&&pwCheck&&nameCheck&&emailCheck){
			$("#frm").submit();
		}
		
		
		 
	  });
	
	  $("#id").blur(function(){
		  idCheck=false;
		   var id=$(this).val();
		  if(id.length==0){
			  $("#idResult").text("id를입력해주세요");
			  $("#idResult").css("color","red");
		  }else{
			  $.post("./memberIdCheck",{id: $(this).val()},function(data){
					
					data=data.trim();
					
					
						if(data==1){
							  $("#idResult").text("사용가능한 아이디입니다");
							  $("#idResult").css("color","blue");
							  idCheck=true;
						  }else{
							  $("#idResult").text("중복된 아이디입니다");
							  $("#idResult").css("color","red");
							 
						  }
					
					
					  
				 }); 
		  }
		
	  });
	  
	  $("#pw2").blur(function(){
		   var pw =$("#pw").val();
		   var pw2=$(this).val();
		   pwCheck=false;
		   if(pw2.length==0){
			   $("#pwCheck").text("비밀번호를 입력해주세요");
			   $("#pwCheck").css("color","red");
		   }else{
			   if(pw==pw2){
				   $("#pwCheck").text("비밀번호가 일치합니다");
				   $("#pwCheck").css("color","blue");
				   pwCheck=true;
			   }else{
				   $("#pwCheck").text("비밀번호가 일치하지않습니다");
				   $("#pwCheck").css("color","red");
			   }
		   }
		   
		   
	  })
	  */
	</script>
</body>
</html>