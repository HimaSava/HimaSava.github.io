<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>

</style>
<title>Bank</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="CSS/Login.css">
	
  	
</head>
<body>

	<%@ include file="Nav_bar.jsp"%>

	<div class="login-page">
	  <div class="form">
    		<form class="register-form">
      			<input type="text" placeholder="name"/>
      			<input type="password" placeholder="password"/>
      			<input type="text" placeholder="email address"/>
		        <button>create</button>
      			<p class="message">Already registered? <a href="Login.jsp">Sign In</a></p>
    		</form>
  		</div>
	</div>
</body>