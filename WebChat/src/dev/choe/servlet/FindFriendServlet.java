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
import dev.choe.vo.UserVo;

@WebServlet("/FindFriendServlet")
public class FindFriendServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	request.setCharacterEncoding("UTF-8");
	HttpSession session = request.getSession();

	String userEmail = (String) session.getAttribute("userMail");
	String friendEmail = request.getParameter("friendEmail");
	String friendName = "";
	int friendId = -1;
	/**
	 * check name
	 */
	if (friendEmail.equals(null)||friendEmail.equals("")) {
	    RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
	    rd.forward(request, response);
	}
	String banText = "\\ / : * ? \" < > |";
	String[] banTexts = banText.split("\\s");
	for (String bantext : banTexts) {
	    if (friendEmail.contains(bantext)) {
		RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
		rd.forward(request, response);
		return;
	    }
	}
	/**
	 * check user selfjoin
	 */
	if (userEmail.equals(friendEmail)) {
	    RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
		rd.forward(request, response);
		return;
	}

	List<UserVo> userList = new ArrayList<UserVo>();
	userList = dbms.getUserDao();
	for (UserVo data : userList) {
	    if (data.getUserEmail().equals(friendEmail)) {
		friendName = data.getUserName();
		friendId = data.getUserId();
		request.setAttribute("friendName", friendName);
		request.setAttribute("friendId", friendId);
		request.setAttribute("friendEmail", friendEmail);
		RequestDispatcher rd = request.getRequestDispatcher("/FriendSearchResult.jsp");
		rd.forward(request, response);
		return;
	    }
	}
	RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
	rd.forward(request, response);
	return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	request.setCharacterEncoding("UTF-8");
	HttpSession session = request.getSession();

	String userEmail = (String) session.getAttribute("userMail");
	String friendEmail = request.getParameter("friendEmail");
	String friendName = "";
	int friendId = -1;
	/**
	 * check same user
	 */
	if (userEmail.equals(friendEmail)) {
	    RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
		rd.forward(request, response);
		return;
	}

	List<UserVo> userList = new ArrayList<UserVo>();
	userList = dbms.getUserDao();
	for (UserVo data : userList) {
	    if (data.getUserEmail().equals(friendEmail)) {
		friendName = data.getUserName();
		friendId = data.getUserId();
		request.setAttribute("friendName", friendName);
		request.setAttribute("friendId", friendId);
		request.setAttribute("friendEmail", friendEmail);
		RequestDispatcher rd = request.getRequestDispatcher("/FriendSearchResult.jsp");
		rd.forward(request, response);
		return;
	    }
	}
	RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
	rd.forward(request, response);
	return;
    }
}