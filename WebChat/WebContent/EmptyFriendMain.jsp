<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%
    String userName = (String) session.getAttribute("userName");
    if (userName == null) {
		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
		rd.forward(request, response);
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="/WebChat/FriendListServlet">Main</a></li>
			<li><a href="/WebChat/ChatListServlet">Chat</a></li>
			<li><a href="/WebChat/OpenChatListServlet">OpenChat</a></li>
			<li><a href="/WebChat/Setup.jsp">Setup</a></li>
		</ul>
	</nav>


	<header> </header>
	<div class="main">

		<h2 class="menuTitle">友達をさがす</h2>
		<form action="/WebChat/FindFriendServlet" method="POST">
			<table class="List">
				<tr>
					<td>友達のメールアドレス <input type="email" name=friendEmail placeholder="メールアドレス"
						class="input">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="送信"></td>
				</tr>
			</table>
		</form>
		<br>
		<h2 class="menuTitle">友達リスト</h2>

		<table class="List">
		<tr><td>
		新しい友達を探そう
		</td></tr>
		</table>
		<br>
	</div>
</body>
</html>