<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="style.css">
<title>Join</title>
</head>
<body>
	<nav>
	 <ul><li><h1>Blog World</h1></li>
		<li><form action="/JspWebPractice/FormServlet" method="POST">
			<br> <input type="submit" value="Login">
		</form></li>
		<li><form action="/JspWebPractice/FormServlet" method="POST">
			<br> <input type="submit" value="Join">
		</form></li>
	</ul></nav>
	<header>
		<div class="bg">
		</div>
	</header>
	<div class="main">
	<h2>Join Us</h2>
		<form action="/BlogServiceDevProject/SignUpServlet" method="POST">
			Email : <input type="text" name="email"><br>
			Name : <input type="text" name="name"><br>
			PW : <input type="password" name="password"><br>
			<br> <input type="submit" value="送信">
		</form>
	</div>

	<footer>

	</footer>
</body>
</html>