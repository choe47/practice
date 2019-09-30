package choe.practice.game;

public class Main {
	public static void main(String[] args) {
		Dealer deal = new Dealer();
		try {
			deal.startGame();

			deal.playerTurn();

			if (deal.judgePlayerTurn() == 0) {

				deal.dealerTurn();

				deal.judgeGame();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
