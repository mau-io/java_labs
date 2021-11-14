package Board;

public class Driver {
	public static void main(String[] args) {

		Game chess = new Game();

		while (chess.getGameRunning()) {
			chess.printBoard();
			chess.move();
		}

  }
}
