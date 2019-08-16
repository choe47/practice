package choe.test.game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MultiGameFieldTest {

	@Test
	public void testGetJudgeHand() {
		MultiGameField game = new MultiGameField();
		game.putPlayer("red");
		game.putPlayer("green");
		game.putPlayer("blue");
		game.putPlayer("yellow");

		Map<String, Integer> t1 = game.getJudgeHand();

		assertNotNull(t1);
	}

	@Test
	public void testGetWinnerScore() {
		MultiGameField game = new MultiGameField();
		game.putPlayer("red");
		game.putPlayer("green");
		game.putPlayer("blue");
		game.putPlayer("yellow");

		int t1 = game.getWinnerScore();
		int t2 = 0;

		assertEquals(t1, t2);
	}

	@Test
	public void testGetWinner() {
		MultiGameField game = new MultiGameField();
		game.putPlayer("red");
		game.putPlayer("green");
		game.putPlayer("blue");
		game.putPlayer("yellow");

		List<String> t1 = game.getWinner();

		assertNotNull(t1);
	}

	@Test
	public void testGetWinner2() {
		MultiGameField game = new MultiGameField();


		List<String> t1 = game.getWinner();
		List<String> t2 = new ArrayList<String>();

		assertEquals(t1, t2);
	}

	@Test
	public void testJudge() {
		MultiGameField game = new MultiGameField();
		game.putPlayer("red");
		game.putPlayer("green");
		game.putPlayer("blue");
		game.putPlayer("yellow");
		game.judgeGame();
		int t1 = game.getWinnerScore();
		assertNotNull(t1);
	}
	@Test
	public void testJudge2() {
		MultiGameField game = new MultiGameField();
		game.judgeGame();
		int t1 = game.getWinnerScore();
		assertEquals(t1, 0);
	}

}
