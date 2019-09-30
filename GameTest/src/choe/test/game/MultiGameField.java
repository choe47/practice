package choe.test.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiGameField {
	private List<String> playerName = new ArrayList<String>();
	private List<Integer> playerPoint = new ArrayList<Integer>();
	private List<String> playerHand = new ArrayList<String>();



	public String putPlayer(String Name) {
		if (playerName.contains(Name)) {
			return null;
		}

		playerName.add(Name);
		for (int i = 0; i < playerName.size(); ++i) {
			if (playerName.get(i) == Name) {
				playerPoint.add(i, 0);
				playerHand.add(i, "none");
				return null;
			}
		}
		return null;
	}

	public int getWinnerScore() {
		if (playerPoint.isEmpty()) {
			return 0;
		}
		int score = Collections.max(playerPoint);
		return score;
	}

	public ArrayList<String> getWinner() {
		List<String> winner = new ArrayList<String>();
		for (int i=0; i<playerName.size(); ++i) {
			if(playerPoint.get(i) == getWinnerScore()) {
				winner.add(playerName.get(i));
			}
		}
		return (ArrayList<String>) winner;
	}

	public void judgeGame() {
		HashMap<String, Integer> judgeHand = new HashMap<String, Integer>();
		judgeHand = getJudgeHand();
		if (judgeHand.get("ROCK") == 0 && judgeHand.get("SCISSORS") != 0 && judgeHand.get("PAPER") != 0) {
			for (int i = 0; i < playerName.size(); ++i) {
				if (playerHand.get(i) == "SCISSORS") {
					playerPoint.set(i, playerPoint.get(i) + 1);
				}
			}
		} else if (judgeHand.get("SCISSORS") == 0 && judgeHand.get("ROCK") != 0 && judgeHand.get("PAPER") != 0) {
			for (int i = 0; i < playerName.size(); ++i) {
				if (playerHand.get(i) == "PAPER") {
					playerPoint.set(i, playerPoint.get(i) + 1);
				}
			}
		} else if (judgeHand.get("PAPER") == 0 && judgeHand.get("SCISSORS") != 0 && judgeHand.get("ROCK") != 0) {
			for (int i = 0; i < playerName.size(); ++i) {
				if (playerHand.get(i) == "ROCK") {
					playerPoint.set(i, playerPoint.get(i) + 1);
				}
			}
		}
		return;
	}

	public HashMap<String, Integer> getJudgeHand() {
		Map<String, Integer> judgeHand = new HashMap<String, Integer>();
		judgeHand.put("ROCK", 0);
		judgeHand.put("SCISSORS", 0);
		judgeHand.put("PAPER", 0);
		for (int i = 0; i < playerName.size(); ++i) {
			playerHand.set(i, getHand());
			if (playerHand.get(i) == "ROCK") {
				judgeHand.put("ROCK", judgeHand.get("ROCK") + 1);
			} else if (playerHand.get(i) == "SCISSORS") {
				judgeHand.put("SCISSORS", judgeHand.get("SCISSORS") + 1);
			} else if (playerHand.get(i) == "PAPER") {
				judgeHand.put("PAPER", judgeHand.get("PAPER") + 1);
			} else {
				// ex
				return null;
			}
		}
		return (HashMap<String, Integer>) judgeHand;
	}

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
}
