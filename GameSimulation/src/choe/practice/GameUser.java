package choe.practice;

import java.util.HashMap;
import java.util.Map;

public class GameUser {
	private Map<String, Integer> user = new HashMap<String, Integer>();

	public void RegisterUser(String username) {
		if (user.containsKey(username) == true) {
			System.out.println(username + " is already registed");
			return;
		}
		user.put(username, null);
	}

	public void putPoint(String username) {
		if (user.containsKey(username) == false) {
			System.out.println(username + " is not found");
			return;
		}
		for (String key : user.keySet()) {
			if (key.equals(username)) {
				int point = user.get(username) + 1;
				user.put(username, point);
				return;
			} else {
			}
			return;
		}
	}

	public String getUserPoint(String username) {
		if (user.containsKey(username) == false) {
			System.out.println(username + " is not found");
			return null;
		}
		for (String key : user.keySet()) {
			if (key.equals(username)) {
				String userPoint = user.get(key).toString();
				return userPoint;
			} else {
				System.out.println(username + " not found");
			}
		}
		return null;
	}

	public String checkMatchWinner(String player1, String player2) {
		// check player1
		if (user.containsKey(player1) == false) {
			System.out.println(player1 + " is not found");
			return null;
		}
		// check player2
		if (user.containsKey(player2) == false) {
			System.out.println(player2 + " is not found");
			return null;
		}
		// check same player
		if (player1 == player2) {
			System.out.println("Same Player");
			return null;
		}
		// get winner
		if (user.get(player1) > user.get(player2)) {
			System.out.println(player1 + " is Winner");
			return player1;

		} else if (user.get(player1) < user.get(player2)) {
			System.out.println(player2 + " is Winner");
			return player2;
		} else {
			System.out.println("draw");
			return null;
		}

	}
	/*
	 * Check League Winner public String checkLeagueWinner() { for (String key1 :
	 * user.keySet()) {
	 *
	 * } }
	 */
}
