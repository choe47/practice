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
		<h2 class="menuTitle">チャットを探す</h2>
		<form action="/WebChat/EnterRoomServlet" method="POST">
			<table class="List">
				<tr>
					<td>ルームコード</td>
				</tr>
				<tr>
					<td><input type="text" name="roomCode" placeholder="ルームコード"
						class="input"></td>
				</tr>
				<tr>
					<td><input type="submit" value="送信"></td>
				</tr>
			</table>
		</form>
		<br> <br>
		<h2 class="menuTitle">新しいチャットを始める</h2>
		<form action="/WebChat/MakeChatServlet" method="POST">
			<table class="List">
				<tr>
					<td>グループ名</td>
				</tr>
				<tr>
					<td><input type="text" name="roomName" placeholder="グループ名"
						class="input"></td>
				</tr>
				<tr>
					<td><input type="submit" value="送信"></td>
				</tr>
			</table>
		</form>
		<br> <br>
		<h2 class="menuTitle">チャットリスト</h2>
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
				<td>
					<form action="/WebChat/EnterRoomServlet" method="POST">
						<input type="hidden" value="<%=roomCode.get(i)%>" name="roomCode">
						<input type="hidden" value="<%=roomName.get(i)%>" name="roomName">
						<input type="submit" value="入場">
					</form>
				</td>
				<td>

					<form action="/WebChat/ExitRoomServlet" method="POST">
						<input type="hidden" value="<%=roomCode.get(i)%>" name="roomCode">
						<input type="submit" id="negativeSubmit" value="チャットから出る">
					</form>

				</td>
			</tr>

		</table>
		<br>
		<%
		    ;
		    }
		%>

	</div>
</body>
</html>