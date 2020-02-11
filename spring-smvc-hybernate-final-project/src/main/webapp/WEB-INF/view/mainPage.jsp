<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	

		<h1>Welcome to admin-page!!!</h1>
		

	
	<div>
	
		<table border="1">
		
				<tr>
					<th>id</th>
					<th>login</th>
					<th>password</th>
					<th>first name</th>
					<th>last name</th>
					<th>role</th>
					<th>action</th>
				</tr>
				
				<c:forEach var="user" items="${users}">
				
					<c:url var="deleteLink" value="/user/delete">
					
						<c:param name="userId" value="${user.id}" />
						
					</c:url>
					
					<tr>
						<td>${user.id}</td>
						<td>${user.login}</td>
						<td>${user.password}</td>
						<td>${user.userDetail.firstName}</td>
						<td>${user.userDetail.lastName}</td>
						<td>${user.userDetail.role}</td>
						<td><a href="${deleteLink}"><font color="red">delete</font></a></td>
					</tr>
					
				</c:forEach>
				
		</table>
		
	</div>
	
	<div>
	
		<form action="logoff" method="get">
		
			<input type = "submit" value = "log-off" />
			
		</form>
		
	</div>
	
	
</body>
</html>