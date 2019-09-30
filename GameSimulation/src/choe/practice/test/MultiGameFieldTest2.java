package choe.practice.test;

import choe.practice.MultiGameField;
import static org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class MultiGameFieldTest2 {


	@Test
	public void testPutPlayer() {
		MultiGameField game = new MultiGameField();
		String t1 = game.putPlayer("blue");
		assertEquals(t1, "blue, ROCK, 0");
	}




}
