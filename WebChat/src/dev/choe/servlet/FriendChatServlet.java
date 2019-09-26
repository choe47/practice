package dev.choe.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.choe.MakeCode;
import dev.choe.dao.ConnectDBMS;
import dev.choe.vo.SmallchatVo;

/**
 * Servlet implementation class FriendChatServlet
 */
@WebServlet("/FriendChatServlet")
public class FriendChatServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	MakeCode code = new MakeCode();
	HttpSession session = request.getSession();
	request.setCharacterEncoding("UTF-8");
	// use request roomCode
	int userId = (int) session.getAttribute("userId");
	int friendId = Integer.parseInt(request.getParameter("friendId"));
	String roomName = "個人チャット";
	String roomCode = "";
	int roomStatus = 1;
	List<SmallchatVo> sdList;
	sdList = dbms.getSmallchatDao();

	for (SmallchatVo sdRoom : sdList) {
	    if ((sdRoom.getUserAId() == userId && sdRoom.getUserBId() == friendId)
		    || (sdRoom.getUserAId() == friendId && sdRoom.getUserBId() == userId)) {
		roomCode = sdRoom.getPrivateRoomCode();
		request.setAttribute("roomCode", roomCode);
		RequestDispatcher rd = request.getRequestDispatcher("/EnterRoomServlet");
		rd.forward(request, response);
		return;
	    }
	}
	roomCode = code.makeCode();
	while (code.checkCode(roomCode) == false) {
	    roomCode = code.makeCode();
	}
	dbms.putChatRoom(roomName, roomCode, roomStatus);
	dbms.putSmallChat(userId, friendId, roomCode);

	//join
	int roomId = dbms.getRoomIdByRoomCode(roomCode);
	request.setAttribute("roomCode", roomCode);
	dbms.putJoin(roomId, userId);
	dbms.putJoin(roomId, friendId);

	RequestDispatcher rd = request.getRequestDispatcher("/EnterRoomServlet");
	rd.forward(request, response);
	return;
    }
}