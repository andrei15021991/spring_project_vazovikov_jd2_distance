<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action="mainPage" modelAttribute="user">
	
			Login: 
			<form:input placeholder="login"  path="login" />
		
			<br><br>
	
			Password: 
			<form:input placeholder="password" path="password" />
	
			<input type="submit" value="Submit" />
	
	</form:form> <br/>
	
	<form action="goToReg" method = "post">
	
		<input type = "submit" value = "registration" />
	
	</form> <br/>
	
	<div>
		<font color="red">
			<c:if test="${errorMessage != null}">
				<c:out value="${errorMessage}"/>		
			</c:if>
		</font>
	</div>
	

</body>
</html>