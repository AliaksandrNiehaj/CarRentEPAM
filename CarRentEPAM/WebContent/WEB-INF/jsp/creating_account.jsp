<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creating Account</title>
</head>
<body background='images/3.jpg'>

<h1>Account was created successfully</h1>

<form action="Controller" method="get">
	<input type="hidden" name="command" value="authorization">
	<input type="submit" value="Continue with authorization">
</form>

<form action="Controller" method="get">
	<input type="hidden" name="command" value="main_page">
	<input type="submit" value="Continue without authorization">
</form>

</body>
</html>