package dev.choe.vo;

public class SmallchatVo {
    private int userAId;
    private int userBId;
    private String privateRoomCode;

    public void setUserAId(int id) {
	userAId = id;
    }

    public int getUserAId() {
	return userAId;
    }

    public void setUserBId(int id) {
	userBId = id;
    }

    public int getUserBId() {
	return userBId;
    }

    public void setPrivateRoomCode(String code) {
	privateRoomCode = code;
    }

    public String getPrivateRoomCode() {
	return privateRoomCode;
    }
}
