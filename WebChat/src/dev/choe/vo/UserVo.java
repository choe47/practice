package dev.choe.vo;


public class UserVo {
    private int userId;
    private String userPassword;
    private String userName;
    private String userEmail;


    public void setUserId(int id) {
	userId = id;
    }

    public int getUserId() {
	return userId;
    }

    public void setUserPassword(String pw) {
	userPassword = pw;
    }

    public String getUserPassword() {
	return userPassword;
    }

    public void setUserName(String name) {
	userName = name;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserEmail(String mail) {
	userEmail = mail;
    }

    public String getUserEmail() {
	return userEmail;
    }



}
