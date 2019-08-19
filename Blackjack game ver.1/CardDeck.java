package choe.practice.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CardDeck {

	private Map<String, Integer> gameCard = fullCardDeck();

	public HashMap<String, Integer> fullCardDeck() {
		Map<String, Integer> card = new HashMap<String, Integer>();
		// Diamonds
		card.put("Ace of Diamonds", 1);
		card.put("2 of Diamonds", 2);
		card.put("3 of Diamonds", 3);
		card.put("4 of Diamonds", 4);
		card.put("5 of Diamonds", 5);
		card.put("6 of Diamonds", 6);
		card.put("7 of Diamonds", 7);
		card.put("8 of Diamonds", 8);
		card.put("9 of Diamonds", 9);
		card.put("10 of Diamonds", 10);
		card.put("Jack of Diamonds", 10);
		card.put("Queen of Diamonds", 10);
		card.put("King of Diamonds", 10);
		// Clovers
		card.put("Ace of Clovers", 1);
		card.put("2 of Clovers", 2);
		card.put("3 of Clovers", 3);
		card.put("4 of Clovers", 4);
		card.put("5 of Clovers", 5);
		card.put("6 of Clovers", 6);
		card.put("7 of Clovers", 7);
		card.put("8 of Clovers", 8);
		card.put("9 of Clovers", 9);
		card.put("10 of Clovers", 10);
		card.put("Jack of Clovers", 10);
		card.put("Queen of Clovers", 10);
		card.put("King of Clovers", 10);
		// Hearts
		card.put("Ace of Hearts", 1);
		card.put("2 of Hearts", 2);
		card.put("3 of Hearts", 3);
		card.put("4 of Hearts", 4);
		card.put("5 of Hearts", 5);
		card.put("6 of Hearts", 6);
		card.put("7 of Hearts", 7);
		card.put("8 of Hearts", 8);
		card.put("9 of Hearts", 9);
		card.put("10 of Hearts", 10);
		card.put("Jack of Hearts", 10);
		card.put("Queen of Hearts", 10);
		card.put("King of Hearts", 10);
		// Spades
		card.put("Ace of Spades", 1);
		card.put("2 of Spades", 2);
		card.put("3 of Spades", 3);
		card.put("4 of Spades", 4);
		card.put("5 of Spades", 5);
		card.put("6 of Spades", 6);
		card.put("7 of Spades", 7);
		card.put("8 of Spades", 8);
		card.put("9 of Spades", 9);
		card.put("10 of Spades", 10);
		card.put("Jack of Spades", 10);
		card.put("Queen of Spades", 10);
		card.put("King of Spades", 10);
		return (HashMap<String, Integer>) card;
	}

	public String DrawCard() {
		if (gameCard.size() != 0) {
			Object[] cards = gameCard.keySet().toArray();
			String randomCards = (String) cards[new Random().nextInt(cards.length)];
			gameCard.remove(randomCards);
			return randomCards;
		}
		return null;

	}
}
