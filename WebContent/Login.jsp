<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login Page</title>
	<link rel="stylesheet" type="text/css" href="CSS/Login.css">
</head>
<body>

	<%@ include file="Nav_bar.jsp"%>
	
	<div class="login-page">
  		<div class="form">
    		<form class="login-form" action="login" method="post">
      			<input type="text" name="id" placeholder="username"/>
      			<input type="password" name="password" placeholder="password"/>
      			<button type="submit">login</button>
      			<p class="message">Not registered? <a href="Registration.jsp">Create an account</a></p>
      			<p class="message">Forgot Password? <a href="ForgotPass.jsp">Change Password</a></p>
    		</form>
  		</div>
	</div>
</body>
</html>