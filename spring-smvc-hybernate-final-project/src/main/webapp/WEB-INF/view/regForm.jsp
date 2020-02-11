<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
.error {
	color: red
}
</style>
</head>
<body>

	<form:form action="processForm" modelAttribute="user">
	
			Login: 
			<form:input placeholder="password" path="login" />
			 
			<form:errors path = "login" cssClass="error"/>
			
			<br/><br/>
	
			Password: 
			<form:input placeholder="password" path="password" />
		
			<br/><br/>
			
			First Name: 
			<form:input placeholder="firstname" path="userDetail.firstName" />
			
			Last Name:
			<form:input placeholder="lastname" path="userDetail.lastName" />
		
			<br/><br/>
			
			<form:hidden path = "userDetail.role" value = "user" />
	
			<input type="submit" value="Submit" />
	
	</form:form> <br/>

	

</body>
</html>