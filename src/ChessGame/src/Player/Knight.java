package Player;

import Pieces.AbstractPiece;
public class Knight extends AbstractPiece{

	public Knight(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (isWhite) {
			System.out.print("♞");
		} else {
			System.out.print("♘");
		}
	}

	@Override
	public boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol) {
		if (Math.abs(srcRow - destRow) == 2 && Math.abs(srcCol - destCol) == 1) {
			return true;
		} else if (Math.abs(srcRow - destRow) == 1 && Math.abs(srcCol - destCol) == 2) {
			return true;
		} else {
			return false;
		}
	}
}
