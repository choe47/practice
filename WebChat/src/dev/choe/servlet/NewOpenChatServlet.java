package dev.choe.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.choe.MakeCode;
import dev.choe.dao.ConnectDBMS;

/**
 * Servlet implementation class NewOpenChatServlet
 */
@WebServlet("/NewOpenChatServlet")
public class NewOpenChatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	HttpSession session = request.getSession();
	MakeCode code = new MakeCode();
	request.setCharacterEncoding("UTF-8");
	String roomName = request.getParameter("roomName");
	/**
	 * check name
	 */
	if (roomName.equals(null) || roomName.equals("")) {
	    RequestDispatcher rd = request.getRequestDispatcher("/ChatListServlet");
	    rd.forward(request, response);
	}
	String banText = "\\ / : * ? \" < > |";
	String[] banTexts = banText.split("\\s");
	for (String bantext : banTexts) {
	    if (roomName.contains(bantext)) {
		RequestDispatcher rd = request.getRequestDispatcher("/OpenChatListServlet");
		rd.forward(request, response);
		return;
	    }
	}
	String roomCode = "";
	int roomStatus = 3;
	roomCode = code.makeCode();
	while (code.checkCode(roomCode) == false) {
	    roomCode = code.makeCode();
	}
	// HttpSession session = request.getSession();
	request.setAttribute("roomCode", roomCode);
	// roomcode
	dbms.putChatRoom(roomName, roomCode, roomStatus);
	int roomId = dbms.getRoomIdByRoomCode(roomCode);
	/**
	 * register user to room(use JoinDao)
	 */
	int userId = (int) session.getAttribute("userId");
	dbms.putJoin(roomId, userId);

	RequestDispatcher rd = request.getRequestDispatcher("/EnterRoomServlet");
	rd.forward(request, response);
    }
}