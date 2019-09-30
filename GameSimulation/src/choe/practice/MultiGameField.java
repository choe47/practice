package choe.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiGameField {

	private List<String> playerName = new ArrayList<String>();
	private List<String> playerHand = new ArrayList<String>();
	private List<Integer> playerPoint = new ArrayList<Integer>();
	public Map<String, Integer> judgeHand = new HashMap<String, Integer>();

	public String getHand() {
		double randomNum = Math.random() * 3;
		if (randomNum < 1) {
			return "ROCK";
		} else if (randomNum < 2) {
			return "SCISSORS";
		} else {
			return "PAPER";
		}
	}

	public String putPlayer(String Name) {
		for (int i = 0; i<playerName.size(); ++i) {
			if (playerName.get(i) == Name) {
				return null;
			}
		}
		playerName.add(Name);
		for (int i = 0; i<playerName.size(); ++i) {
			if (playerName.get(i) == Name) {
				playerHand.set(i, getHand());
				playerPoint.set(i, 0);
				return playerName.get(i)+", "+playerHand.get(i)+", "+playerPoint.get(i);
			}
		}
		return null;
	}
	public int getWinner () {
		Integer max = Collections.max(playerPoint);
		return max;
	}

	public void judge() {
		Map<String, Integer> judgeHand = new HashMap<String, Integer>();
		judgeHand.put("ROCK",0);
		judgeHand.put("SCISSORS",0);
		judgeHand.put("PAPER",0);
		for (int i = 0; i<playerName.size(); ++i) {
			if (playerHand.get(i) == "ROCK") {
				judgeHand.put("ROCK", judgeHand.get("ROCK")+1);
			}
			else if (playerHand.get(i) == "SCISSORS") {
				judgeHand.put("SCISSORS", judgeHand.get("SCISSORS")+1);
			}
			else if (playerHand.get(i) == "PAPER") {
				judgeHand.put("PAPER", judgeHand.get("PAPER")+1);
			}
			else {
				//ex
				return;
			}
		}
		if (judgeHand.get("ROCK")==0 && judgeHand.get("SCISSORS")!=0 && judgeHand.get("PAPER")!=0) {
			for (int i = 0; i<playerName.size(); ++i) {
				if (playerName.get(i) == "SCISSORS") {
					playerPoint.set(i, playerPoint.get(i)+1);
				}
			}
		}
		else if (judgeHand.get("SCISSORS")==0 && judgeHand.get("ROCK")!=0 && judgeHand.get("PAPER")!=0) {
			for (int i = 0; i<playerName.size(); ++i) {
				if (playerName.get(i) == "PAPER") {
					playerPoint.set(i, playerPoint.get(i)+1);
				}
			}
		}
		else if (judgeHand.get("PAPER")==0 && judgeHand.get("SCISSORS")!=0 && judgeHand.get("ROCK")!=0) {
			for (int i = 0; i<playerName.size(); ++i) {
				if (playerName.get(i) == "ROCK") {
					playerPoint.set(i, playerPoint.get(i)+1);
				}
			}
		}
		for (int i = 0; i<playerName.size(); ++i) {
			playerHand.set(i, getHand());
		}
		return;
	}
}
