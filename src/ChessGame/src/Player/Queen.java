package Player;

import Pieces.AbstractPiece;
public class Queen extends AbstractPiece{

	public Queen(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (isWhite){
			System.out.print("♛");
		}
		else{
			System.out.print("♕");
		}
		
	}
	
	private static Boolean diagonalPath(int srcRow, int srcCol, int destRow,
			int destCol) {
		// returns true if the path is diagonal
		// arguments are initial and final coordinates of move in chessboard
		// array
		// good for checking if a move is valid
		return ((Math.abs(srcRow - destRow) == Math.abs(srcCol - destCol)));
	}

	private static Boolean straightPath(int srcRow, int srcCol, int destRow,
			int destCol) {
		// returns true if the path is straight
		// arguments are initial and final coordinates of move in chessboard
		// array
		// good for checking if a move is valid
		return !((srcRow != destRow) && (srcCol != destCol));
	}


	@Override
	public boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol) {
		return (diagonalPath(srcRow, srcCol, destRow, destCol))
				|| straightPath(srcRow, srcCol, destRow, destCol);
	
	}
}
