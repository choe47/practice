package choe.test.game;

public class Main {
	public static void main(String[] args) {
		MultiGameField game = new MultiGameField();
		// player put
		game.putPlayer("red");
		game.putPlayer("green");
		game.putPlayer("blue");
		game.putPlayer("yellow");
		game.putPlayer("red2");
		game.putPlayer("green2");
		game.putPlayer("blue2");
		game.putPlayer("yellow2");
		//judge
		int gameCount = 30;
		for (int i = 0; i < gameCount; ++i) {
			game.judgeGame();
		}
		//winnerscore
		System.out.println("Winner Score : "+game.getWinnerScore());
		//winner
		 for(int i = 0; i < game.getWinner().size(); ++i) {
	            System.out.println("Winner : "+game.getWinner().get(i));
	        }
	}
}
