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
import dev.choe.vo.SmallchatVo;
import dev.choe.vo.UserVo;

/**
 * Servlet implementation class DeleteFriendServlet
 */
@WebServlet("/DeleteFriendServlet")
public class DeleteFriendServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	HttpSession session = request.getSession();
	request.setCharacterEncoding("UTF-8");

	int friendId = Integer.parseInt(request.getParameter("friendId"));
	int userId = (int) session.getAttribute("userId");
	int roomId = -1;
	String roomCode = "";
	List<SmallchatVo> sdList;
	sdList = dbms.getSmallchatDao();
	for (SmallchatVo sdRoom : sdList) {
	    if ((sdRoom.getUserAId() == userId && sdRoom.getUserBId() == friendId)
		    || (sdRoom.getUserAId() == friendId && sdRoom.getUserBId() == userId)) {
		roomCode = sdRoom.getPrivateRoomCode();
	    }
	}
	roomId = dbms.getRoomIdByRoomCode(roomCode);
	List<UserVo> userList = new ArrayList<UserVo>();
	userList = dbms.getUserDao();
	for (UserVo data : userList) {
	    if (data.getUserId() == friendId) {
		dbms.deleteFriend(userId, friendId);
		dbms.deletePrivateRoom(roomCode);
		dbms.exitRoom(userId, roomId);
		RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
		rd.forward(request, response);
		return;
	    }
	}
	RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
	rd.forward(request, response);
	return;
    }
}
