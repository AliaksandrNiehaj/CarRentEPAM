<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registration page</title>
</head>
<body background='images/1.jpg'>
<h2>Registration</h2>

<form action="Controller" method="get">
	
	<input type="text" name="username" value="" placeholder="name">
	<br>
	<input type="text" name="usersurname" value="" placeholder="surname">
	<br>
	<br>
	
	<input type="text" name="useremail" value="" placeholder="e-mail">
	<br>
	<input type="text" name="userphone" value="" placeholder="phone">
	<br>
	<br>
	
	<input type="radio" name="userstatus" value="renter">Renter<br>
	<input type="radio" name="userstatus" value="landlord">Landlord<br>
	<input type="radio" name="userstatus" value="administrator">Administrator<br>
	<br>
	
	<input type="text" name="userlogin" value="" placeholder="login">
	<br>
	<input type="password" name="userpassword" value="" placeholder="password">
	<br>
	<input type="password" name="userconfirmpassword" value="" placeholder="confirm password">
	<br>
	<br>
	
	<input type="hidden" name="command" value="create_account">
	<input type="submit" value="Submit registration info">
	<br>
</form>

<form action="Controller" method="get">
	<input type="hidden" name="command" value="authorization">
	<input type="submit" value="Sorry, I already have a profile">
</form>

</body>
</html>