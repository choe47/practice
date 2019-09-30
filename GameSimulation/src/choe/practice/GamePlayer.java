package choe.practice;

enum RSPHAND {
	ROCK, SCISSORS, PAPER
}

public class GamePlayer {

	private String name;

	public GamePlayer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public RSPHAND getHand() {
		double randomNum = Math.random() * 3;
		if (randomNum < 1) {
			return RSPHAND.ROCK;
		} else if (randomNum < 2) {
			return RSPHAND.SCISSORS;
		} else {
			return RSPHAND.PAPER;
		}
	}

}