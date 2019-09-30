package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DbTest
 */
@WebServlet("/DbTest")
public class DbTest extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO 自動生成された catch ブロック
		e1.printStackTrace();
	}


	Connection con = null;
	try {
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?user=root&password=melonjuice&serverTimezone=UTC");
	    var out = response.getWriter();
	    if (con != null) {

		out.println("<html><head><title>OK</title></head><body>OK</body></html>");

	    } else {
		out.println("<html><head><title>NG</title></head><body>NG</body></html>");
	    }
	}
	catch (SQLException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO 自動生成された catch ブロック
	    e.printStackTrace();
	}
	finally {
	    System.out.println("test");
	}

    }
}
