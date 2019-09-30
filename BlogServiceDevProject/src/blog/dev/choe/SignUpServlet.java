package blog.dev.choe;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	ConnectDbms dbms = new ConnectDbms();
	request.setCharacterEncoding("UTF-8");
	String pw = request.getParameter("password");
	String email = request.getParameter("email");
	String name = request.getParameter("name");

	if (pw == null || email == null || name == null) {
	    RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");
	    rd.forward(request, response);
	}

	List<BlogUser> list;
	list = dbms.getBlogUser();
	for (BlogUser user : list) {
	if (user.getUserEmail().equals(email) || user.getUserName().equals(name)) {
	    RequestDispatcher rd = request.getRequestDispatcher("/Join.jsp");
	    rd.forward(request, response);

	}
	}

	dbms.putUser(email, name, pw);
	RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");
	rd.forward(request, response);
    }
}