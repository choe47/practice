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

import dev.choe.dao.ConnectDBMS;
import dev.choe.vo.UserVo;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	ConnectDBMS dbms = new ConnectDBMS();
	List<UserVo> list;
	request.setCharacterEncoding("UTF-8");

	String email = "";
	String pw = "";
	pw = request.getParameter("password");
	email = request.getParameter("email");
	//banText
	String banText = "\\ / : * ? \" < > |";
	String[] banTexts = banText.split("\\s");
	for (String Text : banTexts) {
	    if (pw.contains(Text) || email.contains(Text)) {
		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
		rd.forward(request, response);
		return;
	    }
	}

	if (email.equals("") || pw.equals("") || email == null || pw == null) {

	    RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
	    rd.forward(request, response);
	    return;
	}
	list = dbms.getUserDao();
	// getUserInfoByMail
	for (UserVo user : list) {
	    if (user.getUserEmail().equals(email) && user.getUserPassword().equals(pw)) {
		HttpSession session = request.getSession();
		String name = user.getUserName();
		int userId = user.getUserId();
		String mail = user.getUserEmail();

		session.setAttribute("userName", name);
		session.setAttribute("userId", userId);
		session.setAttribute("userMail", mail);

		RequestDispatcher rd = request.getRequestDispatcher("/FriendListServlet");
		rd.forward(request, response);
		return;
	    }
	}

	RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
	rd.forward(request, response);
	return;
    }
}
