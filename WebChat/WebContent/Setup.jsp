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
		<h2 class="menuTitle">設定</h2>



		<a href="/WebChat/LogoutServlet">ログアウト</a><br> <br> <a
			href="/WebChat/Withdrawal.jsp">IDを削除する</a><br>

	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>