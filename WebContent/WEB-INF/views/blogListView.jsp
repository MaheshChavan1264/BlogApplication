<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code Wall</title>
<link type="text/css" rel="stylesheet" href="./css/blog.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
</head>
<body>
	<nav>
		<img src="./assets/logo.svg" alt="logo"/>
		<ul>
			<li><a href="${pageContext.request.contextPath }/myblogs">My Blogs</a></li>
			<li><a href="${pageContext.request.contextPath }/all blogs">All Blogs</a></li>
			<li><a href="${pageContext.request.contextPath }/login">Log In</a></li>
			<li><a href="${pageContext.request.contextPath }/signup">Sign Up</a></li>
		</ul>
	</nav>
	
	<form action="${pageContext.request.contextPath }/new" method="post">
		<input id="title" name="title" placeholder="Title" type="text" />
		<textarea id="msg" name="message" placeholder="Description"></textarea>
		<button id="post" type="submit">POST</button>
		
	</form>
</body>
</html>