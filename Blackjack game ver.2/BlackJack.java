package choe.practice.game;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {

	private List<String> playerHand = new ArrayList<String>();
	private List<String> dealerHand = new ArrayList<String>();
	private CardDeck card = new CardDeck();

	public List<String> putPlayerHand(String hand) {
		playerHand.add(hand);
		List<String> getPlayerHand = playerHand;
		return getPlayerHand;
	}

	public List<String> putDealerHand(String hand) {
		dealerHand.add(hand);
		List<String> getDealerHand = dealerHand;
		return getDealerHand;
	}

	public List<String> getPlayerHand() {
		List<String> getPlayerHand = playerHand;
		return getPlayerHand;
	}

	public List<String> getDealerHand() {
		List<String> getDealerHand = dealerHand;
		return getDealerHand;
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
