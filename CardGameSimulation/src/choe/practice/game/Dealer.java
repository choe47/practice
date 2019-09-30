package choe.practice.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealer {
	private BlackJack game = new BlackJack();
	private CardDeck deck = new CardDeck();

	private int BlackJack = 21;

	public void startGame() throws Exception {
		game.putPlayerHand(deck.DrawCard());
		game.putPlayerHand(deck.DrawCard());
		System.out.println("Player Hands");
		System.out.println(playerCardFront());
		game.putDealerHand(deck.DrawCard());
		System.out.println("Dealer Hands");
		System.out.println(dealerCardFront() + " & One Blind Card");
		game.putDealerHand(deck.DrawCard());
		return;
	}

	public void playerTurn() throws Exception {
		Scanner sc = new Scanner(System.in);
		while (getPlayerPoint() < BlackJack) {
			System.out.println("========================================");
			System.out.println("Stay or Hit?");
			System.out.println("(please write Stay:[0] or Hit:[1])");
			System.out.println("========================================");
			String choice;
			choice = sc.nextLine();
			if (choice.equals("0")) {
				break;
			} else if (choice.equals("1")) {
				game.putPlayerHand(deck.DrawCard());
				System.out.println("Player Hands");
				System.out.println(playerCardFront());
				System.out.println("========================================");
			}
		}
		sc.close();
		return;
	}

	public int judgePlayerTurn() {
		if (getPlayerPoint() > BlackJack) {
			System.out.println("Player point : " + getPlayerPoint() + ", Player Bust!");
			System.out.println("Dealer point : " + dealerCardFront() + " = " + getDealerPoint());
			System.out.println("Dealer Win!");
			return 1;
		}
		return 0;
	}

	public void dealerTurn() throws Exception {
		while (getDealerPoint() <= 16) {
			System.out.println("Dealer Hands");
			System.out.println(dealerCardFront() + " = " + getDealerPoint());
			System.out.println("Dealer Draw Card(16 or under)");
			game.putDealerHand(deck.DrawCard());
			System.out.println("========================================");
		}
		return;
	}

	public void judgeGame() {
		System.out.println("Player Hands");
		System.out.println(playerCardFront() + " = " + getPlayerPoint());
		System.out.println("Dealer Hands");
		System.out.println(dealerCardFront() + " = " + getDealerPoint());
		System.out.println("========================================");

		if (getPlayerPoint() > BlackJack) {
			System.out.println("Player Bust!");
			System.out.println("Dealer Win!");
		} else if (getDealerPoint() > BlackJack) {
			System.out.println("Dealer Bust!");
			System.out.println("Player Win!");
		} else if (getPlayerPoint() > getDealerPoint()) {
			System.out.println("Player Win!");
		} else if (getPlayerPoint() < getDealerPoint()) {
			System.out.println("Dealer Win!");
		} else {
			System.out.println("Next game!");
		}

		return;
	}

	public ArrayList<String> playerCardFront(){
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < game.getPlayerHand().size(); ++i) {
			list.add((game.getPlayerHand().get(i)).getSymbol()+" "+(game.getPlayerHand().get(i)).getNumber());
		}
		return (ArrayList<String>) list;
	}
	public ArrayList<String> dealerCardFront(){
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < game.getDealerHand().size(); ++i) {
			list.add((game.getDealerHand().get(i)).getSymbol()+" "+(game.getDealerHand().get(i)).getNumber());
		}
		return (ArrayList<String>) list;
	}



	public int getPoint(Card handCard) {
		if ((handCard.getNumber() == "Jack") || (handCard.getNumber() == "Queen") || (handCard.getNumber() == "King")) {
			return 10;
		} else if (handCard.getNumber() == "Ace") {
			return 1;
		} else {
			int number = Integer.parseInt(handCard.getNumber());
			return number;
		}

	}

	public int getPlayerPoint() {
		int point = 0;
		for (int i = 0; i < game.getPlayerHand().size(); ++i) {
			point = point + getPoint(game.getPlayerHand().get(i));
		}
		return point;
	}

	public int getDealerPoint() {
		int point = 0;
		for (int i = 0; i < game.getDealerHand().size(); ++i) {
			point = point + getPoint(game.getDealerHand().get(i));
		}
		return point;
	}

}
