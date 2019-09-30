package choe.practice;

import java.util.HashMap;
import java.util.Map;

public class GameField {
	// <name, point>
	private Map<String, Integer> user = new HashMap<String, Integer>();

	public void setPlayer(String player) {
		if (user.containsKey(player) == false) {
			user.put(player, 0);
			return;
		}
		return;
	}

	public int playMatch(RSPHAND player1Hand, RSPHAND player2Hand) {
		if ((player1Hand == RSPHAND.ROCK && player2Hand == RSPHAND.SCISSORS)
				|| (player1Hand == RSPHAND.SCISSORS && player2Hand == RSPHAND.PAPER)
				|| (player1Hand == RSPHAND.PAPER && player2Hand == RSPHAND.ROCK)) {
			return 1;
		} else if ((player2Hand == RSPHAND.ROCK && player1Hand == RSPHAND.SCISSORS)
				|| (player2Hand == RSPHAND.SCISSORS && player1Hand == RSPHAND.PAPER)
				|| (player2Hand == RSPHAND.PAPER && player1Hand == RSPHAND.ROCK)) {
			return -1;
		} else {
			return 0;

		}
	}

	public void putPoint(String player) {
		if (user.containsKey(player) == false) {
			return;
		}
		for (String key : user.keySet()) {
			if (key.equals(player)) {
				int point = user.get(player) + 1;
				user.put(player, point);
				return;
			}
		}
		return;
	}

	//動作
	public int getPoint(String player) {
		for (String key : user.keySet()) {
			if (key.equals(player)) {
				return user.get(key);
			}
		}
		//理由
		return -1;
	}

	public String getMatchWinner(String player1, String player2) {
		//例外
		// check player1
		if (user.containsKey(player1) == false) {
			return null;
		}
		// check player2
		if (user.containsKey(player2) == false) {
			return null;
		}
		// check same player
		if (player1 == player2) {
			return null;
		}

		// get winner
		if (user.get(player1) > user.get(player2)) {
			return player1;

		} else if (user.get(player1) < user.get(player2)) {
			return player2;
		} else {
			return null;
		}

	}
	/*
	public String playMultiMatch(RSPHAND player1Hand, RSPHAND player2Hand, int gameNum) {

	}
	 */
	/*
	 * Check League Winner public String checkLeagueWinner() { for (String key1 :
	 * user.keySet()) {
	 *
	 * } }
	 */
}
