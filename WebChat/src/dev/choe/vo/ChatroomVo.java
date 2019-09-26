package dev.choe.vo;

public class ChatroomVo {
    private int chatroomId;
    private String chatroomName;
    private String chatroomCode;
    private int chatroomStatus;

    public void setChatroomId(int id) {
	chatroomId = id;
    }

    public int getChatroomId() {
	return chatroomId;
    }

    public void setChatroomName(String name) {
	chatroomName = name;
    }

    public String getChatroomName() {
	return chatroomName;
    }

    public void setChatroomCode(String code) {
	chatroomCode = code;
    }

    public String getChatroomCode() {
	return chatroomCode;
    }

    public void setChatroomStatus(int status) {
	chatroomStatus = status;
    }
    public int getChatroomStatus() {
	return chatroomStatus;
    }

}
