package dev.choe;

import java.io.IOException;
import java.util.List;

import dev.choe.dao.ConnectDBMS;
import dev.choe.vo.ChatroomVo;

public class MakeCode {
    public String makeCode() {
	String roomCode = "";
	for (int i = 0; i < 8; i++) {
	    int rndVal = (int) (Math.random() * 62);
	    if (rndVal < 10) {
		roomCode += rndVal;
	    } else if (rndVal > 35) {
		roomCode += (char) (rndVal + 61);
	    } else {
		roomCode += (char) (rndVal + 55);
	    }
	}
	return roomCode;
    }

    public boolean checkCode(String roomCode) throws IOException{
	ConnectDBMS dbms = new ConnectDBMS();
	List<ChatroomVo> list;
	list = dbms.getChatroomDao();
	for (ChatroomVo room : list) {
	    if (room.getChatroomCode().equals(roomCode)) {
		return false;
	    }
	}
	return true;
    }
}
