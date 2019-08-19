package choe.practice.game;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		CardDeck card = new CardDeck();
		BlackJack game = new BlackJack();
		Scanner sc = new Scanner(System.in);

		// start game
		game.playerHand(card.DrawCard());
		game.playerHand(card.DrawCard());
		System.out.println("Player Hands");
		System.out.println(game.getPlayerHand());
		game.dealerHand(card.DrawCard());
		System.out.println("Dealer Hands");
		System.out.println(game.getDealerHand() + " & One Blind Card");
		game.dealerHand(card.DrawCard());
		// pick or stop
		while (game.getPlayerPoint() < 21) {
			System.out.println("========================================");
			System.out.println("Stay or Hit?");
			System.out.println("(please write Stay:[0] or Hit:[1])");
			System.out.println("========================================");
			// scan
			String Scanner;
			Scanner = sc.nextLine();
			int ans = Integer.parseInt(Scanner);
			if (ans == 0) {
				break;
			} else if (ans == 1) {
				game.playerHand(card.DrawCard());
				System.out.println("Player Hands");
				System.out.println(game.getPlayerHand());
				System.out.println("========================================");
				continue;
			} else {
				continue;
			}
		}
		sc.close();
		if(game.getPlayerPoint() > 21) {
			System.out.println("Player point : "+ game.getDealerPoint()+", Player Bust!");
			System.out.println("Dealer Win!");
			System.exit(0);
			}
		// result
		while (game.getDealerPoint() <= 16) {
			System.out.println("Dealer Hands");
			System.out.println(game.getDealerHand() + " = " + game.getDealerPoint());
			System.out.println("Dealer Draw(16 or under)");
			game.dealerHand(card.DrawCard());
			System.out.println("========================================");
		}
		System.out.println("Player Hands");
		System.out.println(game.getPlayerHand() + " = " + game.getPlayerPoint());
		System.out.println("Dealer Hands");
		System.out.println(game.getDealerHand() + " = " + game.getDealerPoint());
		System.out.println("========================================");

		if (game.getPlayerPoint() > 21) {
			System.out.println("Player Bust!");
			System.out.println("Dealer Win!");
		} else if (game.getDealerPoint() > 21) {
			System.out.println("Player Win!");
		} else if (game.getPlayerPoint() > game.getDealerPoint()) {
			System.out.println("Player Win!");
		} else if (game.getPlayerPoint() < game.getDealerPoint()) {
			System.out.println("Dealer Win!");
		} else {
			System.out.println("Next game!");
		}
	}
}
