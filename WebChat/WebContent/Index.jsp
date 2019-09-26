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
<title>WCS</title>
</head>
<body>

	<header>
	<h1>ChatChatに参加！！</h1>
	<p class="subtitle">ChatChatは、世界中で使用されるグループチャット専門サービスです。今すぐチャットに参加してみませんか？仕事の効率を上げる新しいアプリです。</p>

	</header>
	<div class="main">
		<form action="/WebChat/LoginServlet" method="POST">
			<table class="loginWindow">

				<tr>
					<td>Email</td>
					<td><input type="email" name="email" class="input" placeholder="メールアドレス" ></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="password" class="input" placeholder="パスワード"></td>
				</tr>
				<tr>
					<td colspan="2" class="inputButton"><input type="submit"
						value="チャットを始める"></td>
				</tr>
				<tr>
					<td colspan="2" class="signupButton"><a
						href="/WebChat/SignUp.jsp">サインアップはここから</a></td>
				</tr>
			</table>
		</form>


		<br>

	</div>
</body>
</html>