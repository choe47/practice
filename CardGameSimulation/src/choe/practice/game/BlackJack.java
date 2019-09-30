package choe.practice.game;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {

	private List<Card> playerHand = new ArrayList<Card>();
	private List<Card> dealerHand = new ArrayList<Card>();

	public void putPlayerHand(Card hand) {
		playerHand.add(hand);
		return;
	}

	public void putDealerHand(Card hand) {
		dealerHand.add(hand);
		return;
	}

	public List<Card> getPlayerHand() {
		List<Card> getPlayerHand = new ArrayList<Card>(playerHand);
		return getPlayerHand;
	}

	public List<Card> getDealerHand() {
		List<Card> getDealerHand = new ArrayList<Card>(dealerHand);
		return getDealerHand;
	}
}
