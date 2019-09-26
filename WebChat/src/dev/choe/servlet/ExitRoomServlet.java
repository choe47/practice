package dev.choe.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.choe.dao.ConnectDBMS;

/**
 * Servlet implementation class ExitRoomServlet
 */
@WebServlet("/ExitRoomServlet")
public class ExitRoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	HttpSession session = request.getSession();
	request.setCharacterEncoding("UTF-8");
	int userId = (int) session.getAttribute("userId");
	int roomId = -1;
	String roomCode = "";
	roomCode = (String) request.getParameter("roomCode");
	roomId = dbms.getRoomIdByRoomCode(roomCode);
	dbms.exitRoom(userId, roomId);

	RequestDispatcher rd = request.getRequestDispatcher("/ChatListServlet");
	rd.forward(request, response);
	return;
    }
}