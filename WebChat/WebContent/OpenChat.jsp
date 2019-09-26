<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="java.util.List"%>
<%
    String userName = (String) session.getAttribute("userName");
    if (userName == null) {
		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
		rd.forward(request, response);
    }
    List<String> roomCode = (List<String>) request.getAttribute("roomCode");
    List<String> roomName = (List<String>) request.getAttribute("roomName");
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
		<h2 class="menuTitle">新しいオープンチャットを始める</h2>
		<form action="/WebChat/NewOpenChatServlet" method="POST">
			<table class="List">
				<tr>
					<td>オープンチャット名</td>
				</tr>
				<tr>
					<td><input type="text" name="roomName" placeholder="オープンチャット名"
						class="input"> <input type="submit" value="作成"></td>
				</tr>
			</table>
		</form>
		<br> <br> <br> <br>
		<h2 class="menuTitle">オープンチャットリスト</h2>
		<%
		    for (int i = 0; i < roomCode.size(); ++i) {
		%>
		<table class="List">
			<tr>
				<td>ルームコード</td>
				<td><%=roomCode.get(i)%></td>
			</tr>
			<tr>
				<td>グループ名</td>
				<td><%=roomName.get(i)%></td>
			</tr>
			<tr>
				<td colspan="2">
					<form action="/WebChat/EnterRoomServlet" method="POST">
						<input type="hidden" value="<%=roomCode.get(i)%>" name="roomCode">
						<input type="hidden" value="<%=roomName.get(i)%>" name="roomName">
						<input type="submit" value="入場">
					</form>
				</td>
			</tr>

		</table>
		<br> <br>
		<%
		    ;
		    }
		%>
		<br> <br> <br> <br> <br> <br>
	</div>
</body>
</html>