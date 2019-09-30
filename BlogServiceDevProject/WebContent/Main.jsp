<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	  <link rel="stylesheet" type="text/css" href="style.css">
		<title>Blog Main</title>
	</head>
<body>
	<nav>
	 <ul><li><h1>Blog World</h1></li>
		<li><form action="/JspWebPractice/FormServlet" method="POST">
			<br> <input type="submit" value="Login">
		</form></li>
		<li><form action="/JspWebPractice/MainMenuServlet" method="POST">
			<br> <input type="submit" value="Join">
		</form></li>
	</ul></nav>
	<header>
		<div class="bg">
		</div>
	</header>
	<div class="main">
	<p><h1>main page</h1></p>
	blog post
	</div>
	<footer>

	</footer>
</body>
</html>