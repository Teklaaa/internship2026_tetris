package tetris;

import static org.junit.Assert.*;

import org.junit.Test;

public class TetrisTest {

	@Test
	public void test() {
		Tetris t = new Tetris();
		assertEquals(20, t.field.length);
		assertEquals(10, t.field[0].length);
		assertEquals(4, t.figure.length);
		assertEquals(4, t.figure[0].length);
		assertEquals(0, t.posY);
		assertEquals(4, t.posX);
		
		Observer o = new Observer() {
			@Override
			public void stateChanged() {
			}
		};
		
		t.addObserver(o);

		assertTrue(t.canMoveDown());

		EventProcessor ep = t;
		ep.moveDown();
		assertEquals(1, t.posY);
		
		t.posY = Tetris.HEIGHT - Tetris.FIGURE_SIZE + 1;
		assertFalse(t.canMoveDown());
	}

}
