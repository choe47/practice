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

/**
 * Servlet implementation class ChatListServlet
 */
@WebServlet("/ChatListServlet")
public class ChatListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	ConnectDBMS dbms = new ConnectDBMS();
	request.setCharacterEncoding("UTF-8");


	int userId = (int) session.getAttribute("userId");
	List<JoinVo> joinList;
	List<Integer> roomId = new ArrayList<Integer>();
	List<String> roomName = new ArrayList<String>();
	List<String> roomCode = new ArrayList<String>();
	joinList = dbms.getJoinList();
	for (JoinVo join : joinList) {
	    if (join.getUserId() == userId) {
		roomId.add(join.getRoomId());
	    }
	}
	// 맵이나 셋으로 받는것도 괜찮을 수 있다
	List<ChatroomVo> roomList = new ArrayList<ChatroomVo>();
	roomList = dbms.getChatroomDao();
	for (ChatroomVo room : roomList) {
	    for (int id : roomId) {
		if (room.getChatroomId() == id) {
		    roomName.add(room.getChatroomName());
		    roomCode.add(room.getChatroomCode());
		}
	    }
	}

	request.setAttribute("roomName", roomName);
	request.setAttribute("roomCode", roomCode);

	RequestDispatcher rd = request.getRequestDispatcher("/Chat.jsp");
	rd.forward(request, response);
	return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	ConnectDBMS dbms = new ConnectDBMS();
	request.setCharacterEncoding("UTF-8");


	int userId = (int) session.getAttribute("userId");
	List<JoinVo> joinList;
	List<Integer> roomId = new ArrayList<Integer>();
	List<String> roomName = new ArrayList<String>();
	List<String> roomCode = new ArrayList<String>();
	joinList = dbms.getJoinList();
	for (JoinVo join : joinList) {
	    if (join.getUserId() == userId) {
		roomId.add(join.getRoomId());
	    }
	}
	// 맵이나 셋으로 받는것도 괜찮을 수 있다
	List<ChatroomVo> roomList = new ArrayList<ChatroomVo>();
	roomList = dbms.getChatroomDao();
	for (ChatroomVo room : roomList) {
	    for (int id : roomId) {
		if (room.getChatroomId() == id) {
		    roomName.add(room.getChatroomName());
		    roomCode.add(room.getChatroomCode());
		}
	    }
	}

	request.setAttribute("roomName", roomName);
	request.setAttribute("roomCode", roomCode);

	RequestDispatcher rd = request.getRequestDispatcher("/Chat.jsp");
	rd.forward(request, response);
	return;
    }
}
