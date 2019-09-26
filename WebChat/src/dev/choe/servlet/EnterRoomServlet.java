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
import dev.choe.vo.ChatroomVo;
import dev.choe.vo.JoinVo;
import dev.choe.vo.MessageVo;
import dev.choe.vo.UserVo;

/**
 * Servlet implementation class EnterRoomServlet
 */
@WebServlet("/EnterRoomServlet")
public class EnterRoomServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	HttpSession session = request.getSession();
	request.setCharacterEncoding("UTF-8");
	// use request roomCode
	String roomCode = "";
	roomCode = request.getParameter("roomCode");
	if (roomCode == null || roomCode == "") {
	    roomCode = (String) request.getAttribute("roomCode");
	}
	int roomId = -1;
	String roomName = "";

	if (roomCode == null || roomCode.equals("")) {
	    RequestDispatcher rd = request.getRequestDispatcher("/ChatListServlet");
	    rd.forward(request, response);
	    return;
	}
	List<ChatroomVo> list;
	list = dbms.getChatroomDao();

	for (ChatroomVo room : list) {
	    if (room.getChatroomCode().equals(roomCode)) {
		roomId = room.getChatroomId();
		roomName = room.getChatroomName();
	    }
	}
	if (roomId == -1) {
	    RequestDispatcher rd = request.getRequestDispatcher("/ChatListServlet");
	    rd.forward(request, response);
	    return;
	}

	request.setAttribute("roomName", roomName);
	request.setAttribute("roomCode", roomCode);

	List<MessageVo> messages = dbms.getMessageByRoomId(roomId);
	request.setAttribute("messages", messages);

	/**
	 * register user to room(use JoinDao)
	 */
	int userId = (int) session.getAttribute("userId");
	List<JoinVo> joinList;
	joinList = dbms.getJoinList();
	/**
	 * enter to chatroom
	 */
	int checkNum = 0;
	for (JoinVo join : joinList) {
	    if (join.getRoomId() == roomId && join.getUserId() == userId) {
		checkNum = 1;
	    }
	}
	if (checkNum == 0) {
	    dbms.putJoin(roomId, userId);
	}

	/**
	 * check joined user
	 */
	List<String> joinedUserName = new ArrayList<String>();
	List<Integer> joinedUserId = new ArrayList<Integer>();
	List<UserVo> userList;
	userList = dbms.getUserDao();
	for (JoinVo join : joinList) {
	    if (join.getRoomId() == roomId) {
		joinedUserId.add(join.getUserId());
	    }
	}
	for (UserVo user : userList) {
	    for (int ul : joinedUserId) {
		if (user.getUserId() == ul) {
		    joinedUserName.add(user.getUserName());
		}
	    }
	}
	request.setAttribute("userList", joinedUserName);
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ChatRoom.jsp");
	rd.forward(request, response);
	return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	HttpSession session = request.getSession();
	request.setCharacterEncoding("UTF-8");
	// use request roomCode
	String roomCode = "";
	roomCode = request.getParameter("roomCode");
	if (roomCode == null || roomCode == "") {
	    roomCode = (String) request.getAttribute("roomCode");
	}
	int roomId = -1;
	String roomName = "";

	if (roomCode == null || roomCode.equals("")) {
	    RequestDispatcher rd = request.getRequestDispatcher("/ChatListServlet");
	    rd.forward(request, response);
	    return;
	}
	List<ChatroomVo> list;
	list = dbms.getChatroomDao();

	for (ChatroomVo room : list) {
	    if (room.getChatroomCode().equals(roomCode)) {
		roomId = room.getChatroomId();
		roomName = room.getChatroomName();
	    }
	}
	if (roomId == -1) {
	    RequestDispatcher rd = request.getRequestDispatcher("/ChatListServlet");
	    rd.forward(request, response);
	    return;
	}

	request.setAttribute("roomName", roomName);
	request.setAttribute("roomCode", roomCode);

	List<MessageVo> messages = dbms.getMessageByRoomId(roomId);
	request.setAttribute("messages", messages);

	/**
	 * register user to room(use JoinDao)
	 */
	int userId = (int) session.getAttribute("userId");
	List<JoinVo> joinList;
	joinList = dbms.getJoinList();
	/**
	 * enter to chatroom
	 */
	int checkNum = 0;
	for (JoinVo join : joinList) {
	    if (join.getRoomId() == roomId && join.getUserId() == userId) {
		checkNum = 1;
	    }
	}
	if (checkNum == 0) {
	    dbms.putJoin(roomId, userId);
	}

	/**
	 * check joined user
	 */
	List<String> joinedUserName = new ArrayList<String>();
	List<Integer> joinedUserId = new ArrayList<Integer>();
	List<UserVo> userList;
	userList = dbms.getUserDao();
	for (JoinVo join : joinList) {
	    if (join.getRoomId() == roomId) {
		joinedUserId.add(join.getUserId());
	    }
	}
	for (UserVo user : userList) {
	    for (int ul : joinedUserId) {
		if (user.getUserId() == ul) {
		    joinedUserName.add(user.getUserName());
		}
	    }
	}
	request.setAttribute("userList", joinedUserName);
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ChatRoom.jsp");
	rd.forward(request, response);
	return;
    }
}