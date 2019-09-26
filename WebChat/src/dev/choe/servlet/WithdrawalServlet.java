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

/**
 * Servlet implementation class WithdrawalServlet
 */
@WebServlet("/WithdrawalServlet")
public class WithdrawalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	HttpSession session = request.getSession();
	request.setCharacterEncoding("UTF-8");

	List<UserVo> udList = dbms.getUserDao();
	String inputEmail = request.getParameter("email");
	String inputPw = request.getParameter("password");
	/**
	 * check Email
	 */
	String banText = "\\ / : * ? \" < > |";
	String[] banTexts = banText.split("\\s");
	for (String bantext : banTexts) {
	    if (inputEmail.contains(bantext) || inputPw.contains(bantext)) {
		RequestDispatcher rd = request.getRequestDispatcher("/Withdrawal.jsp");
		rd.forward(request, response);
		return;
	    }
	}
	if (inputEmail.equals("") || inputPw.equals("") || inputEmail == null || inputPw == null) {
	    RequestDispatcher rd = request.getRequestDispatcher("/Withdrawal.jsp");
	    rd.forward(request, response);
	    return;
	}
	for (UserVo user : udList) {
	    if (user.getUserEmail().equals(inputEmail)
		    && user.getUserPassword().equals(inputPw)) {
		dbms.deleteUser(user.getUserId());
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
		rd.forward(request, response);
		return;
	    }
	}
	RequestDispatcher rd = request.getRequestDispatcher("/Withdrawal.jsp");
	rd.forward(request, response);
	return;
    }
}