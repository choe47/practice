package choe.practice;

public class Main {

	public static void main(String[] args) {
		int gameNum = 3;
		GameField game = new GameField();
		GamePlayer player1 = new GamePlayer("red");
		GamePlayer player2 = new GamePlayer("green");
		game.setPlayer(player1.getName());
		game.setPlayer(player2.getName());
		for (int i = 0; i < gameNum; ++i) {
			int matchNum = i + 1;
			System.out.println("match " + matchNum + " result : ");
			if (game.playMatch(player1.getHand(), player2.getHand()) == 1) {
				System.out.println(player1.getName());
				game.putPoint(player1.getName());
			} else if (game.playMatch(player1.getHand(), player2.getHand()) == -1) {
				System.out.println(player2.getName());
				game.putPoint(player2.getName());
			} else {
				System.out.println("draw");
			}
		}
		System.out.println("final result : ");
		if (game.getMatchWinner(player1.getName(), player2.getName()) == null) {
			System.out.println("draw");
		} else {
			System.out.println(game.getMatchWinner(player1.getName(), player2.getName()));
		}
	}
}
