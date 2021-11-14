package Player;

import Pieces.AbstractPiece;
public class King extends AbstractPiece{

	public King(boolean isWhite) {
		super(isWhite);
	}
	
	@Override
	public void draw() {
		if (isWhite) {
			System.out.print("♛");
		} else {
			System.out.print("♔");
		}
	}

	@Override
	public boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol) {
		//can move in any directions
		return Math.abs(destRow - srcRow) <= 1
				|| Math.abs(destCol - srcCol) <= 1;
	}

}
