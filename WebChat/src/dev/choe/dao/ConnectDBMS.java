package dev.choe.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.choe.vo.ChatroomVo;
import dev.choe.vo.FriendVo;
import dev.choe.vo.JoinVo;
import dev.choe.vo.MessageVo;
import dev.choe.vo.SmallchatVo;
import dev.choe.vo.UserVo;

public class ConnectDBMS {
    final String sqlUrl = "jdbc:mysql://localhost:3306/webchat?user=root&password=melonjuice&serverTimezone=UTC";

    public List<UserVo> getUserDao() throws IOException {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	}

	Connection con = null;
	String sql = "SELECT * FROM user_tb";
	List<UserVo> list = new ArrayList<UserVo>();
	try {
	    // Databaseに接続

	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得

	    // 検索された行数分ループ
	    while (rs.next()) {
		UserVo user = new UserVo();
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

    public void deleteUser(int id) {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	    return;
	}

	String sql = "delete from user_tb where user_id = \"" + id + "\"";
	Connection con = null;
	try {
	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ps.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	    return;
	} finally {
	    try {
		if (con != null) {
		    con.close();
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return;
    }

    public void deleteFriend(int userId, int friendId) {
	// throws ClassNotFoundException
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	    return; // 여기서 끝내는 편이 알기 쉬움
	}

	String sql = "delete from friend_tb where user_id =  \"" + userId + "\" and friend_id = \"" + friendId + "\"";
	Connection con = null;
	try {

	    // Databaseに接続
	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ps.executeUpdate();
	    // RETURN VALUE CHECK 처리 확인
	    // 통일성 가지기
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

    public void deletePrivateRoom(String roomCode) {
	// throws ClassNotFoundException
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	    return; // 여기서 끝내는 편이 알기 쉬움
	}

	String sql = "delete from smallchat_tb where privateroom_code = \"" + roomCode + "\"";
	Connection con = null;
	try {

	    // Databaseに接続
	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ps.executeUpdate();
	    // RETURN VALUE CHECK 처리 확인
	    // 통일성 가지기
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

    public void exitRoom(int userId, int roomId) {
	// throws ClassNotFoundException
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	    return; // 여기서 끝내는 편이 알기 쉬움
	}

	String sql = "delete from join_tb where user_id =  \"" + userId + "\" and room_id = \"" + roomId + "\"";
	Connection con = null;
	try {

	    // Databaseに接続
	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ps.executeUpdate();
	    // RETURN VALUE CHECK 처리 확인
	    // 통일성 가지기
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

    public List<MessageVo> getMessageDao() throws IOException {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	}

	Connection con = null;
	String sql = "SELECT * FROM message_tb";
	List<MessageVo> list = new ArrayList<MessageVo>();
	try {
	    // Databaseに接続
	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    // 検索された行数分ループ
	    while (rs.next()) {
		MessageVo message = new MessageVo();
		int messageId = rs.getInt("message_id");
		String messageText = rs.getString("message_password");
		String messageUser = rs.getString("message_name");
		int chatroomId = rs.getInt("chatroom_id");
		String messageTime = rs.getString("message_time");
		message.setMessageId(messageId);
		message.setMessageText(messageText);
		message.setMessageUser(messageUser);
		message.setChatroomId(chatroomId);
		message.setMessageTime(messageTime);
		list.add(message);
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

    public List<FriendVo> getFriendList() throws IOException {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	}
	Connection con = null;
	String sql = "SELECT * FROM friend_tb";
	List<FriendVo> list = new ArrayList<FriendVo>();
	try {
	    // Databaseに接続

	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得

	    // 検索された行数分ループ
	    while (rs.next()) {
		FriendVo fd = new FriendVo();
		int userId = rs.getInt("user_id");
		int friendId = rs.getInt("friend_id");
		fd.setUserId(userId);
		fd.setFriendId(friendId);

		list.add(fd);
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

    public List<JoinVo> getJoinList() throws IOException {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driv" + "er");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	}

	Connection con = null;
	String sql = "SELECT * FROM join_tb";
	List<JoinVo> list = new ArrayList<JoinVo>();
	try {
	    // Databaseに接続

	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得

	    // 検索された行数分ループ
	    while (rs.next()) {
		JoinVo jd = new JoinVo();
		int userId = rs.getInt("user_id");
		int roomId = rs.getInt("room_id");
		jd.setUserId(userId);
		jd.setRoomId(roomId);

		list.add(jd);
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

    public List<ChatroomVo> getChatroomDao() throws IOException {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	}

	Connection con = null;
	String sql = "SELECT * FROM chatroom_tb";
	List<ChatroomVo> list = new ArrayList<ChatroomVo>();
	try {
	    // Databaseに接続

	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得

	    // 検索された行数分ループ
	    while (rs.next()) {
		ChatroomVo chat = new ChatroomVo();
		int roomId = rs.getInt("chatroom_id");
		String roomName = rs.getString("chatroom_Name");
		String roomCode = rs.getString("chatroom_code");
		int roomStatus = rs.getInt("chatroom_st");
		chat.setChatroomId(roomId);
		chat.setChatroomName(roomName);
		chat.setChatroomCode(roomCode);
		chat.setChatroomStatus(roomStatus);
		list.add(chat);
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

    public List<SmallchatVo> getSmallchatDao() throws IOException {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	}

	Connection con = null;
	String sql = "SELECT * FROM smallchat_tb";
	List<SmallchatVo> list = new ArrayList<SmallchatVo>();
	try {
	    // Databaseに接続

	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得

	    // 検索された行数分ループ
	    while (rs.next()) {
		SmallchatVo sd = new SmallchatVo();
		int userAId = rs.getInt("user_a_id");
		int userBId = rs.getInt("user_b_id");
		String privateRoomCode = rs.getString("privateroom_code");
		sd.setUserAId(userAId);
		sd.setUserBId(userBId);
		sd.setPrivateRoomCode(privateRoomCode);

		list.add(sd);
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

    public void putUser(String email, String name, String pw) {
	// throws ClassNotFoundException
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    // TODO 自動生成された catch ブロック
	    e1.printStackTrace();
	    return;
	}
	// check log
	String sql = "insert into user_tb(user_name, user_email, user_password) " + "value(\"" + name + "\", \"" + email
		+ "\", \"" + pw + "\")";
	// "name" );
	Connection con = null;
	try {
	    // Databaseに接続
	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ps.executeUpdate();
	    // return check
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

    public void putJoin(int roomId, int userId) {
	// throws ClassNotFoundException
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    // TODO 自動生成された catch ブロック
	    e1.printStackTrace();
	    return;
	}
	// check log
	String sql = "insert into join_tb(room_id, user_id) " + "value(\"" + roomId + "\", \"" + userId + "\")";

	Connection con = null;
	try {
	    // Databaseに接続
	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ps.executeUpdate();
	    // return check
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

    public void putFriend(int userId, int friendId) {
	// throws ClassNotFoundException
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    // TODO 自動生成された catch ブロック
	    e1.printStackTrace();
	    return;
	}
	// check log
	String sql = "insert into friend_tb(user_id, friend_id) " + "value(\"" + userId + "\", \"" + friendId + "\")";

	Connection con = null;
	try {
	    // Databaseに接続
	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ps.executeUpdate();
	    // return check
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

    public void putChatRoom(String roomName, String roomCode, int roomStatus) {
	// throws ClassNotFoundException
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	    return;
	}

	String sql = "insert into chatroom_tb(chatroom_name, chatroom_code, chatroom_st) "
	+ "value(\"" + roomName + "\", \"" + roomCode + "\", \"" + roomStatus + "\")";
	Connection con = null;
	try {
	    // Databaseに接続
	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ps.executeUpdate();
	    // return check
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

    public void putSmallChat(int userId, int friendId, String roomcode) {
	// throws ClassNotFoundException
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	    return;
	}

	String sql = "insert into smallchat_tb(user_a_id, user_b_id, privateroom_code) " + "value(\"" + userId
		+ "\", \"" + friendId + "\", \"" + roomcode + "\")";
	Connection con = null;
	try {
	    // Databaseに接続
	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ps.executeUpdate();
	    // return check
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

    public void putMessage(String message, int roomId, String userName, String messageTime) {
	// throws ClassNotFoundException
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	    return;
	}

	String sql = "insert into message_tb(message_text, chatroom_id, message_user, message_time) " + "value(\""
		+ message + "\", \"" + roomId + "\",\"" + userName + "\",\"" + messageTime + "\")";
	Connection con = null;
	try {
	    // Databaseに接続
	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ps.executeUpdate();
	    // return check
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

    public int getRoomIdByRoomCode(String roomCode) throws IOException {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	}

	Connection con = null;
	int userId = -1;
	String sql = "SELECT chatroom_id FROM chatroom_tb where chatroom_code = \"" + roomCode + "\" ";
	try {
	    // Databaseに接続

	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得

	    // 検索された行数分ループ
	    rs.next();
	    userId = rs.getInt("chatroom_id");
	} catch (SQLException e) {
	    e.printStackTrace();
	    return -1;
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
	return userId;
    }

    public List<MessageVo> getMessageByRoomId(int RoomId) throws IOException {
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	    e1.printStackTrace();
	}

	Connection con = null;
	List<MessageVo> messages = new ArrayList<MessageVo>();
	String sql = "SELECT * FROM message_tb where chatroom_id = \"" + RoomId + "\" order by message_time desc";
	try {
	    // Databaseに接続

	    con = DriverManager.getConnection(sqlUrl);
	    PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
	    ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得

	    // 検索された行数分ループ
	    while (rs.next()) {
		MessageVo messageData = new MessageVo();
		int roomId = rs.getInt("chatroom_id");
		String message = rs.getString("message_text");
		String userName = rs.getString("message_user");
		String messageTime = rs.getString("message_time");

		messageData.setChatroomId(roomId);
		messageData.setMessageText(message);
		messageData.setMessageUser(userName);
		messageData.setMessageTime(messageTime);

		messages.add(messageData);
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
	return messages;
    }

    /*
     * public void putChatText(String chatroomId, String message) { // throws
     * ClassNotFoundException try { Class.forName("com.mysql.cj.jdbc.Driver"); }
     * catch (ClassNotFoundException e1) { e1.printStackTrace(); return; } String
     * time = null;
     *
     * if (getChatText(chatroomId) != null) { message = getChatText(chatroomId) +
     * ','+ message + time; } else { message = message + time; }
     *
     * String sql = "insert into chatroom(chatroom_id, chatroom_text) " + "value(\""
     * + chatroomId + "\", \"" + message + "\")"; // "name" ); Connection con =
     * null; try { // Databaseに接続 con = DriverManager.getConnection(
     * "jdbc:mysql://localhost:3306/webchat?user=root&password=melonjuice&serverTimezone=UTC"
     * ); PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
     * ps.executeUpdate(); // return check } catch (SQLException e) {
     * e.printStackTrace(); return; } finally { try { // close処理 if (con != null) {
     * con.close(); } } catch (SQLException e) { e.printStackTrace(); } } return; }
     *
     * public String getChatText(String chatroomId) { try {
     * Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException
     * e1) { // TODO 自動生成された catch ブロック e1.printStackTrace(); } Connection con =
     * null; String sql = "SELECT chatroom_text FROM chatroom where chatroom_id=\""
     * + chatroomId + "\""; String chatroomText = null; try { // Databaseに接続 con =
     * DriverManager.getConnection(
     * "jdbc:mysql://localhost:3306/webchat?user=root&password=melonjuice&serverTimezone=UTC"
     * ); PreparedStatement ps = con.prepareStatement(sql);// ステートメントオブジェクトを生成
     * ResultSet rs = ps.executeQuery();// クエリーを実行して結果セットを取得
     *
     * // 検索された行数分ループ rs.next(); chatroomText = rs.getString("chatroom_text"); }
     * catch ( SQLException e) { e.printStackTrace(); return null; } finally { try {
     * // close処理 if (con != null) { con.close(); } } catch (SQLException e) {
     * e.printStackTrace(); } } return chatroomText; }
     */
}
