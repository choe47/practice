package dev.choe.vo;

public class MessageVo {
    private int messageId;
    private String messageText;
    private String messageUser;
    private int chatroomId;
    private String messageTime;

    public int getMessageId() {
	return messageId;
    }
    public void setMessageId(int id) {
	messageId = id;
    }

    public String getMessageText() {
	return messageText;
    }
    public void setMessageText(String text) {
	messageText = text;
    }

    public String getMessageUser() {
	return messageUser;
    }
    public void setMessageUser(String user) {
	messageUser = user;
    }

    public int getChatroomId() {
	return chatroomId;
    }
    public void setChatroomId(int id) {
	chatroomId = id;
    }

    public String getMessageTime() {
	return messageTime;
    }
    public void setMessageTime(String time) {
	messageTime = time;
    }

}
