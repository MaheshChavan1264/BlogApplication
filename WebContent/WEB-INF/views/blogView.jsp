<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div class="body-div1">
		<div>Your Blog Posts</div>
		<a href="${pageContext.request.contextPath }/new"><button class="button" id="addblog"><i class="fas fa-plus-circle"></i>Add New Post</button></a>
	</div>
	
	<div class="body-div2">
		<c:forEach var="blog" items="${listBlog}">
    		<div class="article-card">
        	    <img src="./assets/java card image.svg" alt="">
            <div class="card-text">
                <h1 id="blog-title"><c:out value="${blog.getBlogTitle()}" /></h1>
                <p id="blog-description"><c:out value="${blog.getBlogDescription()}" /></p>
                <p>Posted on <b><c:out value="${blog.getDate()}" /></b> </p>
            </div>
            <div class="card-buttons">
                <button type="button" id="edit" value="edit">EDIT</button> <span>|</span><button id="delete" value="delete">DELETE</button>
            </div>
        </div>
        </c:forEach> 
	</div>
	<div class="body-div3">
		<h1>${ message }</h1>
	</div>
</body>
</html>