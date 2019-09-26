package dev.choe.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.choe.dao.ConnectDBMS;
import dev.choe.vo.FriendVo;

/**
 * Servlet implementation class AddFriendServlet
 */
@WebServlet("/AddFriendServlet")
public class AddFriendServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	HttpSession session = request.getSession();
	request.setCharacterEncoding("UTF-8");

	String friendIdString = "";
	int friendId = -1;
	int userId = -1;
	friendIdString = request.getParameter("friendId");
	friendId = Integer.parseInt(friendIdString);
	userId = (int) session.getAttribute("userId");
	List<FriendVo> friendList = new ArrayList<FriendVo>();
	friendList = dbms.getFriendList();
	// check duplicate
	for (FriendVo list : friendList) {
	    if (list.getFriendId() == friendId && list.getUserId() == userId) {
		// message
		RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
		rd.forward(request, response);
		return;
	    }
	}
	// add friend
	dbms.putFriend(userId, friendId);
	RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
	rd.forward(request, response);
    }
}
