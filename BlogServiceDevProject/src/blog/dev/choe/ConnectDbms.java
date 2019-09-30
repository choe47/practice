package blog.dev.choe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectDbms {
    public List<BlogUser> getBlogUser()  {
	Connection con = null;
	String sql = "SELECT * FROM BLOGUSER";
	List<BlogUser> list = new ArrayList<BlogUser>();
	try {
	    // Databaseに接続

	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?user=root&password=melonjuice&serverTimezone=UTC");
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得

	    // 検索された行数分ループ
	    while (rs.next()) {
		BlogUser user = new BlogUser();
		int userId = rs.getInt("user_id");
		String userPassword = rs.getString("user_password");
		String userName = rs.getString("user_name");
		String userEmail = rs.getString("user_email");

		user.setUserId(userId);
		user.setUserPassword(userPassword);
		user.setUserName(userName);
		user.setUserEmail(userEmail);

		list.add(user);
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
    public void putUser(String email, String name, String pw)  {
   	String sql = "insert into bloguser(user_name, user_email, user_password) value(\"" + name + "\", \""+ email+ "\", \""+ pw + "\")";
   	Connection con = null;
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
/*
    public List<BlogPost> getBlogPost() {
	Connection con = null;
	String sql = "SELECT * FROM BLOGPOST";
	List<BlogPost> list = new ArrayList<BlogPost>();
	try {
	    // Databaseに接続
	    con = DriverManager
		    .getConnection("jdbc:mysql://localhost:3306/blog?user=root&password=melonjuice&serverTimezone=UTC");
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得

	    // 検索された行数分ループ
	    while (rs.next()) {
		BlogPost post = new BlogPost();
		int postId = rs.getInt("post_id");
		int userId = rs.getInt("user_id");
		int postState = rs.getInt("post_state");
		String postTxt = rs.getString("post_txt");
//시간포맷 확인		SimpleDateFormat postDate = rs.getDate("post_date");
		int blogId = rs.getInt("blog_id");
		post.setPostId(postId);
		post.setUserId(userId);
		post.setPostState(postState);
		post.setPostTxt(postTxt);
		//post.setPostDate(postDate);
		post.setBlogId(blogId);

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

    public List<Site> getSite() {
   	Connection con = null;
   	String sql = "SELECT * FROM SITE";
   	List<Site> list = new ArrayList<Site>();
   	try {
   	    // Databaseに接続
   	    con = DriverManager
   		    .getConnection("jdbc:mysql://localhost:3306/blog?user=root&password=melonjuice&serverTimezone=UTC");
   	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
   	    ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得

   	    // 検索された行数分ループ
   	    while (rs.next()) {
   		Site site = new Site();
   		int userId = rs.getInt("user_id");
   		int blogId = rs.getInt("blog_id");
   		site.setUserId(userId);
   		site.setBlogId(blogId);

   		list.add(site);
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
       */

}
