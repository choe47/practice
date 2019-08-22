package choe.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ConnectDbms {
	public int getUserId(String mail, String number) {
		Connection con = null;
		int id = 0;
		String sql = "select * from bloguser where user_email = \"" + mail + "\" and user_password = \"" + number
				+ "\"";
		try {
			// Databaseに接続
			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/blog?user=root&password=melonjuice&serverTimezone=UTC");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				id = rs.getInt("user_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();

			return 0;

		} finally {
			try {
				// close処理
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return id;

	}

	public String getPasswordFromEmail(String mail) {
		Connection con = null;
		String password = null;
		String sql = "select * from bloguser where user_email = \"" + mail + "\"";
		try {
			// Databaseに接続
			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/blog?user=root&password=melonjuice&serverTimezone=UTC");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				password = rs.getString("user_password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			try {
				// close処理
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return password;
	}

	public void putPost(int idnum, String text) {
		Connection con = null;
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		String sql = "insert into blogpost(user_id, post_state, post_txt, post_like, post_date, blog_id)\r\n"
				+ "			value(\"" + idnum + "\", \"1\", \"" + text + "\", \"0\", \"" + today + "\", \"1\")";
		try {
			// Databaseに接続
			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/blog?user=root&password=melonjuice&serverTimezone=UTC");
			PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} finally {
			try {
				// close処理
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return;
	}

	public List<String> getPost(int id) {
		Connection con = null;
		String post = null;
		List<String> list = new ArrayList<String>();
		String sql = "select * from blogpost where user_id = \"" + id
				+ "\" and post_state = \"1\" order by post_txt desc";
		try {
			// Databaseに接続
			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/blog?user=root&password=melonjuice&serverTimezone=UTC");
			PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				post = rs.getString("post_txt");
				list.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				// close処理
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
