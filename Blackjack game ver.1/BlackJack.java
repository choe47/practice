package choe.practice.game;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {

	private List<String> playerHand = new ArrayList<String>();
	private List<String> dealerHand = new ArrayList<String>();
	private CardDeck card = new CardDeck();

	public List<String> playerHand(String hand) {
		playerHand.add(hand);
		return (List<String>) playerHand;
	}

	public List<String> dealerHand(String hand) {
		dealerHand.add(hand);
		return (List<String>) dealerHand;
	}

	public List<String> getPlayerHand() {
		return playerHand;
	}

	public List<String> getDealerHand() {
		return dealerHand;
	}

	public int getPlayerPoint() {
		int point = 0;
		for (int i = 0; i < playerHand.size(); ++i) {
			point = point + card.fullCardDeck().get(getPlayerHand().get(i));
		}
		return point;
	}

	public int getDealerPoint() {
		int point = 0;
		for (int i = 0; i < dealerHand.size(); ++i) {
			point = point + card.fullCardDeck().get(getDealerHand().get(i));
		}
		return point;
	}
}
