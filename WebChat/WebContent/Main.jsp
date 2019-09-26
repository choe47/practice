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
    List<String> friendName = (List<String>) request.getAttribute("friendName");
    List<String> friendEmail = (List<String>) request.getAttribute("friendEmail");
    List<Integer> friendId = (List<Integer>) request.getAttribute("friendId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="/WebChat/FriendListServlet">Main</a></li>
				<li><a href="/WebChat/ChatListServlet">Chat</a></li>
				<li><a href="/WebChat/OpenChatListServlet">OpenChat</a></li>
				<li><a href="/WebChat/Setup.jsp">Setup</a></li>
			</ul>
		</nav>
	</header>
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
		<br> <br>
		<h2 class="menuTitle">友達リスト</h2>
		<%
		    for (int i = 0; i < friendName.size(); ++i) {
		%>
		<table class="List">
			<tr>
				<td>名前</td>
				<td><%=friendName.get(i)%></td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td><%=friendEmail.get(i)%></td>
			</tr>
			<tr>
				<td><form action="/WebChat/FriendChatServlet" method="POST">
						<input type="hidden" value="<%=friendId.get(i)%>" name="friendId">
						<input type="submit" value="チャット開始">
					</form></td>

				<td><form action="/WebChat/DeleteFriendServlet" method="POST">
						<input type="hidden" value="<%=friendId.get(i)%>" name="friendId">
						<input type="submit" id="negativeSubmit" value="友達削除">
					</form></td>
			</tr>
		</table>
		<%
		    ;
		    }
		%>
		<br>
	</div>
</body>
</html>