package dev.choe.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.choe.dao.ConnectDBMS;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/WriteServlet")
public class WriteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	request.setCharacterEncoding("UTF-8");

	String message = "";
	message = request.getParameter("message");
	String roomCode = "";
	roomCode = request.getParameter("roomCode");
	String roomName = "";
	roomName = request.getParameter("roomName");
	SimpleDateFormat timeData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date time = new Date();
	String messageTime = timeData.format(time);

	request.setAttribute("roomCode", roomCode);

	String banText = "\\ / : * ? \" < > |";
	String[] banTexts = banText.split("\\s");
	for (String bantext : banTexts) {
	    if (message.contains(bantext)) {
		message = "使用できない文字が含まれています";
	    }
	}

	HttpSession session = request.getSession();
	if (roomName == null || roomName.equals("")) {
	    RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
	    rd.forward(request, response);
	    return;
	}
	if (message == null || message.equals("")) {
	    RequestDispatcher rd = request.getRequestDispatcher("/EnterRoomServlet");
	    rd.forward(request, response);
	    return;
	}

	int roomId = dbms.getRoomIdByRoomCode(roomCode);
	String userName = (String) session.getAttribute("userName");
	dbms.putMessage(message, roomId, userName, messageTime);

	RequestDispatcher rd = request.getRequestDispatcher("/EnterRoomServlet");
	rd.forward(request, response);
    }
}