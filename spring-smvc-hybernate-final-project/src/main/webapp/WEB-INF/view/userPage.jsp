<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome ${user1.userDetail.firstName} ${user1.userDetail.lastName}</h1>
	
	<div>
	
		<form action="logoff" method="get">
		
			<input type = "submit" value = "log-off" />
			
		</form>
		
		<form action="updateUser" method="post">
		
			<input type = "hidden" name = "userId" value = "${user1.id}">
		
			<input type = "submit" value = "change password" />
			
		</form>
		
	</div>
	
</body>
</html>