<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="dev.choe.vo.MessageVo"%>
<%@ page import="java.util.List"%>
<%
    String userName = (String) session.getAttribute("userName");
    String roomName = (String) request.getAttribute("roomName");
    String roomCode = (String) request.getAttribute("roomCode");
    if (userName == null) {
		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
		rd.forward(request, response);
    }
    if (roomCode == null) {
		RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");
		rd.forward(request, response);
    }
%>
<%
    List<MessageVo> messages = (List<MessageVo>) request.getAttribute("messages");
    if (messages == null) {
		RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
		rd.forward(request, response);
    }
    List<String> userList = (List<String>) request.getAttribute("userList");
    if (userList == null) {
		RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
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
	<table class="chatInfo">
		<tr>
			<td>「チャット名」</td>
			<td><%=roomName%></td>
		</tr>
		<tr>
			<td>「ルームコード」</td>
			<td><%=roomCode%></td>
		</tr>
	</table>
	<table class="chatInfo">
		<tr>
			<td>「参加ユーザー」</td>
		</tr>
		<tr>
			<td>
				<%
				    for (String userlist : userList) {
										out.println(userlist);
								    }
				%>
			</td>
		</tr>

	</table>


	<form action="/WebChat/WriteServlet" method="POST">
		<input type="text" name="message" placeholder="新しいメッセージ" class="inputText"> <input
			type="hidden" value="<%=roomName%>" name="roomName"> <input
			type="hidden" value="<%=roomCode%>" name="roomCode"> <input
			type="submit" value="送信">
	</form>
	<br>
	<div class="chatWindow">
		<table class="chatTable">
			<%
			    for (MessageVo list : messages) {
			%>
			<tr>
				<td class="messageUser"><%=list.getMessageUser()%></td>
				<td class="messageTime"><%=list.getMessageTime()%></td>
			</tr>
			<tr>
				<td colspan="2" class="message"><%=list.getMessageText()%></td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
			<%
			    ;
			    }
			%>
		</table>
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


</body>
</html>