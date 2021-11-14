package Pieces;

public abstract class AbstractPiece {
	
	public boolean isWhite;

	/**
	 * If piece is white set true, false otherwise
	 */
	public AbstractPiece(boolean isWhite) {
		this.isWhite = isWhite;
	}

	/**
	 * Returns true if white, false otherwise
	 */
	public boolean isWhite() {
		return isWhite;
	}

	/**
	 * Draws given piece into the console
	 */
	public abstract void draw();

	/**
	 * Checks whether a given move is valid. Returns true if valid, false
	 * otherwise
	 */
	public abstract boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol);

	public void printPossibleMoves(int srcRow, int srcCol, AbstractPiece[][] board) {
		// check all directions
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				// int to char	
				char srcColChar = (char) (srcCol + 'a');
				char srcRowChar = (char) (7 - (srcRow - '1'));

				if (isValidMove(srcRow, srcCol, i, j)) {
					System.out.println("Valid move from " +  srcColChar + "" + srcRowChar + " to " + (char) (j + 'a') + "" + (char) (7 - (i - '1')));
				}
			}
		}
	}
}
