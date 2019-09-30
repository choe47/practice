package choe.practice.game.test;

import static org.junit.Assert.*;

import org.junit.Test;

import choe.practice.game.Dealer;

class DealerTest {
	@Test
	public void testDrawCard() {
		Dealer deal = new Dealer();
		for(int i = 0; i<100; ++i) {
		deal.DrawCard();
		}
		String t1 = deal.DrawCard();
		assertNotNull(t1);
	}

}
