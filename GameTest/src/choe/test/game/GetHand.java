package choe.test.game;

public class GetHand {

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
