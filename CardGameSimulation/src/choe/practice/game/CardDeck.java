package choe.practice.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDeck {

	private Card[] card = new Card[52];
	private List<Card> list = new ArrayList<Card>();

	public CardDeck() {
		card[0] = new Card("Diamond", "Ace");
		card[1] = new Card("Diamond", "2");
		card[2] = new Card("Diamond", "3");
		card[3] = new Card("Diamond", "4");
		card[4] = new Card("Diamond", "5");
		card[5] = new Card("Diamond", "6");
		card[6] = new Card("Diamond", "7");
		card[7] = new Card("Diamond", "8");
		card[8] = new Card("Diamond", "9");
		card[9] = new Card("Diamond", "10");
		card[10] = new Card("Diamond", "Jack");
		card[11] = new Card("Diamond", "Queen");
		card[12] = new Card("Diamond", "King");
		card[13] = new Card("Clover", "Ace");
		card[14] = new Card("Clover", "2");
		card[15] = new Card("Clover", "3");
		card[16] = new Card("Clover", "4");
		card[17] = new Card("Clover", "5");
		card[18] = new Card("Clover", "6");
		card[19] = new Card("Clover", "7");
		card[20] = new Card("Clover", "8");
		card[21] = new Card("Clover", "9");
		card[22] = new Card("Clover", "10");
		card[23] = new Card("Clover", "Jack");
		card[24] = new Card("Clover", "Queen");
		card[25] = new Card("Clover", "King");
		card[26] = new Card("Heart", "Ace");
		card[27] = new Card("Heart", "2");
		card[28] = new Card("Heart", "3");
		card[29] = new Card("Heart", "4");
		card[30] = new Card("Heart", "5");
		card[31] = new Card("Heart", "6");
		card[32] = new Card("Heart", "7");
		card[33] = new Card("Heart", "8");
		card[34] = new Card("Heart", "9");
		card[35] = new Card("Heart", "10");
		card[36] = new Card("Heart", "Jack");
		card[37] = new Card("Heart", "Queen");
		card[38] = new Card("Heart", "King");
		card[39] = new Card("Spade", "Ace");
		card[40] = new Card("Spade", "2");
		card[41] = new Card("Spade", "3");
		card[42] = new Card("Spade", "4");
		card[43] = new Card("Spade", "5");
		card[44] = new Card("Spade", "6");
		card[45] = new Card("Spade", "7");
		card[46] = new Card("Spade", "8");
		card[47] = new Card("Spade", "9");
		card[48] = new Card("Spade", "10");
		card[49] = new Card("Spade", "Jack");
		card[50] = new Card("Spade", "Queen");
		card[51] = new Card("Spade", "King");
		for (int i = 0; i < card.length; ++i) {
			list.add(i, card[i]);
		}
	}

	public Card DrawCard() throws Exception {
		if (list.size() == 0) {
			throw new Exception();
		}
		Random rnd = new Random();
		int cardIndex = rnd.nextInt(list.size());
		return list.remove(cardIndex);
	}
}
/*
 * Object[] cards = card.keySet(); String randomCards = (String) cards[new
 * Random().nextInt(cards.length)]; card.remove(randomCards); return
 * randomCards;
 */

/*
 * private Card card = new Card(); private List<String, String> cardDeck = new
 * HashMap<String, String>();
 *
 *
 * public CardDeck() { for (int i = 0; i<card.symbol().length; ++i) { for (int j
 * = 0; j<card.number().length; ++j) {
 * cardDeck.put(card.getSymbol(i)+"_"+card.getNumber(j)); } } }
 *
 * public String DrawCard() throws Exception { if (cardDeck.size() == 0) { throw
 * new Exception(); } Object[] cards = cardDeck.keySet().toArray(); String
 * randomCards = (String) cards[new Random().nextInt(cards.length)];
 * cardDeck.remove(randomCards); return randomCards; } public int
 * getCardPoint(){
 *
 * } } private Map<String, Integer> card = new HashMap<String, Integer>();
 *
 *
 *
 * public CardDeck() { // Diamonds card.put("Ace of Diamonds", 1);
 * card.put("2 of Diamonds", 2); card.put("3 of Diamonds", 3);
 * card.put("4 of Diamonds", 4); card.put("5 of Diamonds", 5);
 * card.put("6 of Diamonds", 6); card.put("7 of Diamonds", 7);
 * card.put("8 of Diamonds", 8); card.put("9 of Diamonds", 9);
 * card.put("10 of Diamonds", 10); card.put("Jack of Diamonds", 10);
 * card.put("Queen of Diamonds", 10); card.put("King of Diamonds", 10); //
 * Clovers card.put("Ace of Clovers", 1); card.put("2 of Clovers", 2);
 * card.put("3 of Clovers", 3); card.put("4 of Clovers", 4);
 * card.put("5 of Clovers", 5); card.put("6 of Clovers", 6);
 * card.put("7 of Clovers", 7); card.put("8 of Clovers", 8);
 * card.put("9 of Clovers", 9); card.put("10 of Clovers", 10);
 * card.put("Jack of Clovers", 10); card.put("Queen of Clovers", 10);
 * card.put("King of Clovers", 10); // Hearts card.put("Ace of Hearts", 1);
 * card.put("2 of Hearts", 2); card.put("3 of Hearts", 3);
 * card.put("4 of Hearts", 4); card.put("5 of Hearts", 5);
 * card.put("6 of Hearts", 6); card.put("7 of Hearts", 7);
 * card.put("8 of Hearts", 8); card.put("9 of Hearts", 9);
 * card.put("10 of Hearts", 10); card.put("Jack of Hearts", 10);
 * card.put("Queen of Hearts", 10); card.put("King of Hearts", 10); // Spades
 * card.put("Ace of Spades", 1); card.put("2 of Spades", 2);
 * card.put("3 of Spades", 3); card.put("4 of Spades", 4);
 * card.put("5 of Spades", 5); card.put("6 of Spades", 6);
 * card.put("7 of Spades", 7); card.put("8 of Spades", 8);
 * card.put("9 of Spades", 9); card.put("10 of Spades", 10);
 * card.put("Jack of Spades", 10); card.put("Queen of Spades", 10);
 * card.put("King of Spades", 10); }
 *
 * public String DrawCard() throws Exception { if (card.size() == 0) { throw new
 * Exception(); } Object[] cards = card.keySet().toArray(); String randomCards =
 * (String) cards[new Random().nextInt(cards.length)]; card.remove(randomCards);
 * return randomCards; }
 *
 * }
 */