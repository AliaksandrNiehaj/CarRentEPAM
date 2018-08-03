<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Authorization page</title>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="bundles.locale" var="loc"/>
<fmt:message bundle="${loc}" key="locale.authorization.login.text" var="login"/>
<fmt:message bundle="${loc}" key="locale.authorization.password.text" var="password"/>

</head>
<body background='images/1.jpg'>

<h1>Authorization</h1>

<form action="Controller" method="get">
	<input type="hidden" name="command" value="localization">
	<input type="hidden" name="local" value="en">
	<input type="submit" value="en">
</form>

<form action="Controller" method="get">
	<input type="hidden" name="command" value="localization">
	<input type="hidden" name="local" value="ru">
	<input type="submit" value="ru">
</form>





<form action="Controller" method="get">
	<c:out value="${login}"/>
	<input type="text" name="nickname" value="" placeholder="nickname">
	<br>
	<c:out value="${password}"/>
	<input type="password" name="password" value="" placeholder="password">
	<br>
	<input type="hidden" name="command" value="sign_in">
	<input type="submit" value="Sign in">
	<br>
	<br>
</form>

<form action="Controller" method="get">
	<input type="hidden" name="command" value="registration">
	<input type="submit" value="Create account">
	<br>
</form>

</body>

</html>