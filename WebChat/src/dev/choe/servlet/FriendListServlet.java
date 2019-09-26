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
import dev.choe.vo.UserVo;

/**
 * Servlet implementation class FriendListServlet
 */
@WebServlet("/FriendListServlet")
public class FriendListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	ConnectDBMS dbms = new ConnectDBMS();
	request.setCharacterEncoding("UTF-8");

	/**
	 *
	 * find friendId by userId; and print friend id with friend name; select by user
	 * table
	 */
	int userId = (int) session.getAttribute("userId");
	List<FriendVo> friendList;
	List<Integer> friendId = new ArrayList<Integer>();
	List<String> friendName = new ArrayList<String>();
	List<String> friendEmail = new ArrayList<String>();
	friendList = dbms.getFriendList();

	for (FriendVo list : friendList) {
	    if (list.getUserId() == userId) {
		friendId.add(list.getFriendId());
	    }
	}

	if (friendId.size() == 0) {
	    RequestDispatcher rd = request.getRequestDispatcher("/EmptyFriendMain.jsp");
	    rd.forward(request, response);
	    return;
	}

	List<UserVo> userList;
	userList = dbms.getUserDao();
	for (UserVo list : userList) {
	    for (int id : friendId) {
		if (list.getUserId() == id) {
		    friendName.add(list.getUserName());
		    friendEmail.add(list.getUserEmail());

		}
	    }
	}
	request.setAttribute("friendName", friendName);
	request.setAttribute("friendEmail", friendEmail);
	request.setAttribute("friendId", friendId);
	RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");
	rd.forward(request, response);
	return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	ConnectDBMS dbms = new ConnectDBMS();
	request.setCharacterEncoding("UTF-8");

	/**
	 *
	 * find friendId by userId; and print friend id with friend name; select by user
	 * table
	 */
	int userId = (int) session.getAttribute("userId");
	List<FriendVo> friendList;
	List<Integer> friendId = new ArrayList<Integer>();
	List<String> friendName = new ArrayList<String>();
	List<String> friendEmail = new ArrayList<String>();
	friendList = dbms.getFriendList();

	for (FriendVo list : friendList) {
	    if (list.getUserId() == userId) {
		friendId.add(list.getFriendId());
	    }
	}

	if (friendId.size() == 0) {
	    RequestDispatcher rd = request.getRequestDispatcher("/EmptyFriendMain.jsp");
	    rd.forward(request, response);
	    return;
	}

	List<UserVo> userList;
	userList = dbms.getUserDao();
	for (UserVo list : userList) {
	    for (int id : friendId) {
		if (list.getUserId() == id) {
		    friendName.add(list.getUserName());
		    friendEmail.add(list.getUserEmail());

		}
	    }
	}
	request.setAttribute("friendName", friendName);
	request.setAttribute("friendEmail", friendEmail);
	request.setAttribute("friendId", friendId);
	RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");
	rd.forward(request, response);
	return;
    }
}
