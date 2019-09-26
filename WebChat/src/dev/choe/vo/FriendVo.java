package dev.choe.vo;

public class FriendVo {
    private int userId;
    private int friendId;

    public void setUserId(int id) {
	userId = id;
    }

    public int getUserId() {
	return userId;
    }

    public void setFriendId(int id) {
	friendId = id;
    }

    public int getFriendId() {
	return friendId;
    }
}
