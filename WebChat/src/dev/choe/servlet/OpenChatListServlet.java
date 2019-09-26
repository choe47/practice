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

import dev.choe.dao.ConnectDBMS;
import dev.choe.vo.ChatroomVo;

/**
 * Servlet implementation class OpenChatListServlet
 */
@WebServlet("/OpenChatListServlet")
public class OpenChatListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ConnectDBMS dbms = new ConnectDBMS();
	request.setCharacterEncoding("UTF-8");

	List<String> roomName = new ArrayList<String>();
	List<String> roomCode = new ArrayList<String>();
	int roomStatus = 3;

	// 맵이나 셋으로 받는것도 괜찮을 수 있다
	List<ChatroomVo> roomList = new ArrayList<ChatroomVo>();
	roomList = dbms.getChatroomDao();
	for (ChatroomVo room : roomList) {
		if (room.getChatroomStatus() == roomStatus) {
		    roomName.add(room.getChatroomName());
		    roomCode.add(room.getChatroomCode());
		}
	    }

	request.setAttribute("roomName", roomName);
	request.setAttribute("roomCode", roomCode);

	RequestDispatcher rd = request.getRequestDispatcher("/OpenChat.jsp");
	rd.forward(request, response);
	return;
    }
}
