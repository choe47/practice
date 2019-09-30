package choe.practice.game.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import choe.practice.game.BlackJack;

public class BlackjackTest {
	BlackJack game = new BlackJack();
	@Test
	public void putPlayerHandTest() {
		List<String> t1 = game.putPlayerHand("Ace of Diamonds");
		assertNotNull(t1);
		//t1=[Ace of Diamonds]
	}

	@Test
	public void putPlayerHandTest2() {
		List<String> t1 = game.putPlayerHand("");
		assertNotNull(t1);
	}

	@Test
	public void putDealerHandTest() {
		List<String> t1 = game.putDealerHand("Ace of Diamonds");
		assertNotNull(t1);
	}

	@Test
	public void putDealerHandTest2() {
		List<String> t1 = game.putDealerHand("");
		assertNotNull(t1);
	}
}
