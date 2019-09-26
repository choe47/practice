<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%
    String userName = (String) session.getAttribute("userName");
    if (userName == null) {
		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
		rd.forward(request, response);
    }

    String friendName = (String) request.getAttribute("friendName");
    int friendId = (int) request.getAttribute("friendId");
    String friendEmail = (String) request.getAttribute("friendEmail");
    if (friendName == null || friendId == -1 || friendEmail == null) {
		RequestDispatcher rd = request.getRequestDispatcher("/FindFriend.jsp");
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
	<h2>検索結果</h2>
		<table class="List">
			<tr>
				<td>「名前」 <%=friendName%></td>
			</tr>
			<tr>
				<td>「メールアドレス」 <%=friendEmail%></td>
			</tr>
			<tr>
				<td>
					<form action="/WebChat/AddFriendServlet" method="POST">
						<input type="hidden" value="<%=friendId%>" name=friendId>
					 <input type="submit" value="友達追加">
					</form>
				</td>
			</tr>
		</table>
		<br>
	</div>
</body>
</html>