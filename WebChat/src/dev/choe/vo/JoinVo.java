package dev.choe.vo;

public class JoinVo {
    private int userId;
    private int roomId;

    public void setUserId(int id) {
	userId = id;
    }

    public int getUserId() {
	return userId;
    }

    public void setRoomId(int id) {
	roomId = id;
    }

    public int getRoomId() {
	return roomId;
    }
}
