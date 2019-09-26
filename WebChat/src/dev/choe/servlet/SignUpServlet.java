package dev.choe.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.choe.dao.ConnectDBMS;
import dev.choe.vo.UserVo;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDBMS dbms = new ConnectDBMS();
	request.setCharacterEncoding("UTF-8");
	String pw = "";
	String email = "";
	String name = "";
	pw = request.getParameter("password");
	email = request.getParameter("email");
	name = request.getParameter("name");
	name = name.replaceAll("\\p{Z}", "_");

	String banText = "\\ / : * ? \" < > |";
	String[] banTexts = banText.split("\\s");
	for (String Text : banTexts) {
	    if (pw.contains(Text) || email.contains(Text) || name.contains(Text)) {
		// request.setAttribute("result", "wrong");
		RequestDispatcher rd = request.getRequestDispatcher("/SignUp.jsp");
		rd.forward(request, response);
		return;
	    }
	}

	if (pw.equals("") || email.equals("") || name.equals("")) {
	    RequestDispatcher rd = request.getRequestDispatcher("/SignUp.jsp");
	    rd.forward(request, response);
	    return;
	}

	List<UserVo> list;
	list = dbms.getUserDao();
	for (UserVo user : list) {
	    if (user.getUserEmail().equals(email) || user.getUserName().equals(name)) {
		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
		rd.forward(request, response);
		return;
	    }
	}
	dbms.putUser(email, name, pw);

	RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
	rd.forward(request, response);
	return;
    }
}
