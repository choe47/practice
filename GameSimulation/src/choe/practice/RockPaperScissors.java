package choe.practice;

public class RockPaperScissors {
	final int STONE = 0;
	final int SCISSORS = 1;
	final int PAPER = 2;


	public String playMatch(String player1, String player2) {
		int player1Hand = getHand();
		int player2Hand = getHand();

		if ((player1Hand == STONE && player2Hand == SCISSORS)
			||(player1Hand == SCISSORS && player2Hand == PAPER)
			||(player1Hand == PAPER && player2Hand == STONE)){
			return player1;
		}
		else if ((player2Hand == STONE && player1Hand == SCISSORS)
				||(player2Hand == SCISSORS && player1Hand == PAPER)
				||(player2Hand == PAPER && player1Hand == STONE)){
			return player2;
			}
		else {
			return null;

		}
	}
	/*
	 * public String playLeague() {
	 *
	 * }
	 */
	public int getHand() {
		double randomNum = Math.random() * 3;
		if (randomNum < 1) {
			return STONE;
		} else if (randomNum < 2) {
			return SCISSORS;
		} else {
			return PAPER;
		}
	}

}
