<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%
    String userName = (String) session.getAttribute("userName");
    if (userName != null) {
		RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");
		rd.forward(request, response);
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Join</title>
</head>
<body>
	<header>
		<div class="bg">
<h2>サインアップする</h2></div>
	</header>

	<div class="main">
		<form action="/WebChat/SignUpServlet" method="POST">
			<table class="loginWindow">

				<tr>
					<td>Email</td>
					<td><input type="email" name="email" placeholder="メールアドレス" class="input"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" placeholder="名前" class="input"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="password" placeholder="パスワード" class="input"></td>
				</tr>
				<tr>
					<td colspan="2" class="inputButton"><input type="submit" value="実行する"></td>
				</tr>
				<tr>
					<td colspan="2" class="back"> <a href="/WebChat/Index.jsp">Back</a></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>