package blog.dev.choe;

public class BlogUser {
    private int userId;
    private String userPassword;
    private String userName;
    private String userEmail;

    //
    void setUserId(int id) {
	userId = id;
    }

    int getUserId() {
	return userId;
    }

    //
    void setUserPassword(String pw) {
	userPassword = pw;
    }

    String getUserPassword() {
	return userPassword;
    }

    //
    void setUserName(String name) {
	userName = name;
    }

    String getUserName() {
	return userName;
    }

    //
    void setUserEmail(String mail) {
	userEmail = mail;
    }

    String getUserEmail() {
	return userEmail;
    }

}