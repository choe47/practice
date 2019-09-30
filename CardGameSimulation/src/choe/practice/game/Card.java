package choe.practice.game;

public class Card {
	/*

	public String[] symbol() {
		String[] symbols = {"Diamonds", "Clovers", "Hearts", "Spades"};
		return symbols;
	}
	public String[] number() {
		String[] numbers = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		return numbers;
	}
	*/

	private String symbol;
	private String number;

	public Card(String symbol, String number) {
		this.symbol = symbol;
		this.number = number;
	}

	public String getSymbol() {
		return symbol;
	}
	public String getNumber() {
		return number;
	}
}
