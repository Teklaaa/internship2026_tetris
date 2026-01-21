package tetris;

import static org.junit.Assert.*;
import org.junit.Test;

public class TetrisTest {

	@Test
	public void testInitialState() {
		Tetris t = new Tetris();

		assertEquals(20, t.field.length);
		assertEquals(10, t.field[0].length);
		assertEquals(4, t.figure.length);
		assertEquals(4, t.figure[0].length);
		assertEquals(0, t.posY);
		assertEquals(4, t.posX);
	}

	@Test
	public void testMoveDown() {
		Tetris t = new Tetris();

		t.addObserver(() -> {});
		assertTrue(t.canMoveDown());

		t.moveDown();
		assertEquals(1, t.posY);

		t.posY = Tetris.HEIGHT - Tetris.FIGURE_SIZE + 1;
		assertFalse(t.canMoveDown());
	}

	@Test
	public void testMoveLeft() {
		Tetris t = new Tetris();
		t.addObserver(() -> {});

		int startX = t.posX;
		assertTrue(t.canMoveLeft());

		t.moveLeft();
		assertEquals(startX - 1, t.posX);
	}

	@Test
	public void testMoveRight() {
		Tetris t = new Tetris();
		t.addObserver(() -> {});

		int startX = t.posX;
		assertTrue(t.canMoveRight());

		t.moveRight();
		assertEquals(startX + 1, t.posX);
	}

	@Test
	public void testCannotMoveLeftAtBorder() {
		Tetris t = new Tetris();
		t.addObserver(() -> {});

		t.posX = 0;
		assertFalse(t.canMoveLeft());

		t.moveLeft();
		assertEquals(0, t.posX);
	}

	@Test
	public void testCannotMoveRightAtBorder() {
		Tetris t = new Tetris();
		t.addObserver(() -> {});

		t.posX = Tetris.WIDTH - Tetris.FIGURE_SIZE;
		assertFalse(t.canMoveRight());

		t.moveRight();
		assertEquals(Tetris.WIDTH - Tetris.FIGURE_SIZE, t.posX);
	}
}
