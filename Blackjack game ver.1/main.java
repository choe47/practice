package choe.practice.game;

public class Main {
	public static void main(String[] args) {
		Dealer deal = new Dealer();
		deal.startGame();
		deal.playerTurn();
		deal.dealerTurn();
		deal.judgeGame();
	}
}
