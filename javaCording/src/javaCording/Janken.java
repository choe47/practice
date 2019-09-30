package javaCording;



public class Janken {
	static String lineSeparator = System.lineSeparator();
	static final int STONE = 0;
	static final int SCISSORS = 1;
	static final int PAPER = 2;

	public static void main(String[] args) {
		System.out.println("じゃんけん開始" + lineSeparator);

		int player1WinCount = 0;
		int player2WinCount = 0;

		// 3回戦実施
		for (int cnt = 0; cnt < 3; cnt++) {
			// Player1, 2の手を決める
			int player1Hand = getHand();
			int player2Hand = getHand();
			// 勝敗の判定
			if ((player1Hand == STONE && player2Hand == SCISSORS)
				|| (player1Hand == SCISSORS && player2Hand == PAPER)
				|| (player1Hand == PAPER && player2Hand == STONE)) {
				player1WinCount++;
				System.out.println(lineSeparator + "Player1が勝ちました" + lineSeparator);
			} else if ((player2Hand == STONE && player1Hand == SCISSORS)
				|| (player2Hand == SCISSORS && player1Hand == PAPER)
				|| (player2Hand == PAPER && player1Hand == STONE)) {
				player2WinCount++;
				System.out.println(lineSeparator + "Player2が勝ちました" + lineSeparator);
			} else {
				System.out.println(lineSeparator + "引き分けです。");
			}

		}
		// 最終判定
		System.out.println("じゃんけん終了" + lineSeparator);

		if (player1WinCount > player2WinCount) {
			System.out.println(player1WinCount + " 対 " + player2WinCount + " でPlayer1の勝ちです。" + lineSeparator);
		} else if (player1WinCount < player2WinCount) {
			System.out.println(player1WinCount + " 対 " + player2WinCount + " でPlayer2の勝ちです。" + lineSeparator);
		} else {
			System.out.println(player1WinCount + " 対 " + player2WinCount + " で引き分けです。" + lineSeparator);
		}
	}
	public static int getHand(){
		double randomNum = Math.random() * 3;
		if (randomNum < 1) {
			System.out.println("グー");
			return STONE;
		} else if (randomNum < 2) {
			System.out.println("チョキ");
			return SCISSORS;
		} else  {
			System.out.println("パー");
			return PAPER;
		}
	}
}
