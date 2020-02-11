<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="saveCustomer" modelAttribute="user" method="POST">

			<form:hidden path="id" />
			
			<form:hidden path="login" />
			
			Enter new password:
			<form:input path="password"/>
			
			<form:hidden path="userDetail.firstName" />
			
			<form:hidden path="userDetail.lastName" />
			
			<form:hidden path="userDetail.role" />
					
			<input type="submit" value="change" />
				
	</form:form>

</body>
</html>