<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code Wall</title>
<link type="text/css" rel="stylesheet" href="./css/style.css"/>
</head>
<body>
	<nav>
		<img src="../assets/logo.svg" alt="Code Wall"/>
		<ul>
			<li><a href="${ pageContext.request.contextPath }/login">Log In</a></li>
			<li><a href="${ pageContext.request.contextPath }/signup">Sign Up</a></li>
		</ul>
	</nav>
	<div class="welcome-back">WELCOME BACK</div>
	<div class=sub-text>Share something new that you have learned today with the Code Wall Community.</div>
	
	<div class="login-form">
		<div class="title">Log In</div>
		<form action="${ pageContext.request.contextPath }/login" method="post">
			<label class="label" for="email">Email</label>
			<input type="text" name="email" id="email">
			<label class="label" for="password">Password</label>
			<input type="password" name="password" id="password">
			<button class="button" type="submit">Log In</button>
			<a class="forgot-password" href="">Forgot Password</a>
		</form>
	</div>
</body>
</html>