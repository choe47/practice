package choe.practice.game;

import java.util.Scanner;

public class Dealer {
	private BlackJack game = new BlackJack();
	private CardDeck card = new CardDeck();
	private int BlackJack = 21;

	public void startGame() {
		game.putPlayerHand(card.DrawCard());
		game.putPlayerHand(card.DrawCard());
		System.out.println("Player Hands");
		System.out.println(game.getPlayerHand());
		game.putDealerHand(card.DrawCard());
		System.out.println("Dealer Hands");
		System.out.println(game.getDealerHand() + " & One Blind Card");
		game.putDealerHand(card.DrawCard());
		return;
	}

	public void playerTurn() {
		Scanner sc = new Scanner(System.in);
		String choice;
		while (game.getPlayerPoint() < BlackJack) {
			System.out.println("========================================");
			System.out.println("Stay or Hit?");
			System.out.println("(please write Stay:[0] or Hit:[1])");
			System.out.println("========================================");
			// scan
			choice = sc.nextLine();

			if (choice.equals("0")) {
				break;
			} else if (choice.equals("1")) {
				game.putPlayerHand(card.DrawCard());
				System.out.println("Player Hands");
				System.out.println(game.getPlayerHand());
				System.out.println("========================================");
				continue;
			} else {
				continue;
			}
		}
		sc.close();
		judgePlayerTurn();
		return;
	}
	public void judgePlayerTurn() {
		if (game.getPlayerPoint() > BlackJack) {
			System.out.println("Player point : " + game.getPlayerPoint() + ", Player Bust!");
			System.out.println("Dealer point : " + game.getDealerHand() + " = " + game.getDealerPoint());
			System.out.println("Dealer Win!");
			System.exit(0);
		}
		return;
	}

	public void dealerTurn() {
		while (game.getDealerPoint() <= 16) {
			System.out.println("Dealer Hands");
			System.out.println(game.getDealerHand() + " = " + game.getDealerPoint());
			System.out.println("Dealer Draw(16 or under)");
			game.putDealerHand(card.DrawCard());
			System.out.println("========================================");
		}
		return;
	}

	public void judgeGame() {
		System.out.println("Player Hands");
		System.out.println(game.getPlayerHand() + " = " + game.getPlayerPoint());
		System.out.println("Dealer Hands");
		System.out.println(game.getDealerHand() + " = " + game.getDealerPoint());
		System.out.println("========================================");

		if (game.getPlayerPoint() > BlackJack) {
			System.out.println("Player Bust!");
			System.out.println("Dealer Win!");
		} else if (game.getDealerPoint() > BlackJack) {
			System.out.println("Dealer Bust!");
			System.out.println("Player Win!");
		} else if (game.getPlayerPoint() > game.getDealerPoint()) {
			System.out.println("Player Win!");
		} else if (game.getPlayerPoint() < game.getDealerPoint()) {
			System.out.println("Dealer Win!");
		} else {
			System.out.println("Next game!");
		}
		return;
	}
}
