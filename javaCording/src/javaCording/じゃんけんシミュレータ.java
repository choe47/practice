package jp.joyworks.trainings;

public class JankenGameMain {

	static String lineSeparator = System.lineSeparator();
	static final int STONE = 0;
	static final int SCISSORS = 1;
	static final int PAPER = 2;

	public static void main(String[] args) {
		System.out.println("じゃんけん開始" + lineSeparator);

		double randomNum = 0;
		int player1WinCount = 0;
		int player2WinCount = 0;

		// 3回戦実施
		for (int cnt = 0; cnt < 3; cnt++) {
			// Player1の手を決める
			int player1Hand = 0;

			randomNum = Math.random() * 3;
			if (randomNum < 1) {
				player1Hand = STONE;
				System.out.println("グー");
			} else if (randomNum < 2) {
				player1Hand = SCISSORS;
				System.out.println("チョキ");
			} else if (randomNum < 3) {
				player1Hand = PAPER;
				System.out.println("パー");
			}

			// Player2の手を決める
			int player2Hand = 0;
			randomNum = Math.random() * 3;

			randomNum = Math.random() * 3;
			if (randomNum < 1) {
				player2Hand = STONE;
				System.out.println("グー");
			} else if (randomNum < 2) {
				player2Hand = SCISSORS;
				System.out.println("チョキ");
			} else if (randomNum < 3) {
				player2Hand = PAPER;
				System.out.println("パー");
			}

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
}
