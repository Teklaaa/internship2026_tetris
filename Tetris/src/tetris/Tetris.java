package tetris;

public class Tetris implements EventProcessor {

	private static final int INITIAL_POS_X = 4;
	private static final int INITIAL_POS_Y = 0;
	static final int FIGURE_SIZE = 4;
	static final int WIDTH = 10;
	static final int HEIGHT = 20;

	private static final int[][] L = {
			{0, 1, 0, 0},
			{0, 1, 0, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 0},
	};
	
	
	public int[][] field = new int[HEIGHT][WIDTH];
	public int[][] figure = L;
	public int posY = INITIAL_POS_Y;
	public int posX = INITIAL_POS_X;
	private Observer observer;
	
	@Override
	public void moveDown() {
		posY++;
		observer.stateChanged();
	}

	public void addObserver(Observer o) {
		observer = o;
	}

	public boolean canMoveDown() {
		for (int i = 0; i < figure.length; i++) {
			for (int j = 0; j < figure[i].length; j++) {
				if (figure[i][j] == 0) continue;
				if (posY + i + 1 >= Tetris.HEIGHT) return false;
			}
		}
		return true;
	}

}
