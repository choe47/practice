package choe.practice.game.test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import choe.practice.game.Dealer;

class DealTest {
	private Dealer deal = new Dealer();
	@Test
	void testDrawCard() {

		for(int i = 0; i<100; ++i) {
		deal.DrawCard();
		}
		String t1 = deal.DrawCard();
		assertNotNull(t1);
	}

}
