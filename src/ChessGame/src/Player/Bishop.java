package Player;

import Pieces.AbstractPiece;
public class Bishop extends AbstractPiece{

	public Bishop(boolean isWhite) {
		super(isWhite);
	}
	
	@Override
	public void draw() {
		if (isWhite) {
			System.out.print("♝");
		} else {
			System.out.print("♗");
		}
	}

	@Override
	public boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol) {
		if (Math.abs(srcRow - destRow) == Math.abs(srcCol - destCol)) {
			return true;
		}
		return false;
	}
}
