<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign_in_Administrator</title>
</head>
<body background='images/3.jpg'>
	
	<%@ page import ="by.epam.carrent.domain.User" %>
	<% User user = (User)session.getAttribute("user"); %>
	
	Session id: <%= session.getId() %><br>
	
	<c:if test= "${user != null}">
	<%= user.getName() %> <%= user.getSurname() %>
	<h2>Hello <%= user.getRole() %></h2>	
	</c:if>
	
	<c:if test= "${user == null}">
		<c:redirect url="/authorization"/>
	</c:if>
	
	
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="sign_out">
		<input type="submit" value="Sign out">
	</form>
	
</body>
</html>