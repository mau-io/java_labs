package Player;

import Pieces.AbstractPiece;
public class Rook extends AbstractPiece{

	public Rook(boolean isWhite) {
		super(isWhite);
	}
	
	@Override
	public void draw() {
		if (isWhite){
			System.out.print("♜");
		}
		else{
			System.out.print("♖");
		}		
	}
	
	@Override
	public boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol) {
		if (srcRow == destRow || srcCol == destCol){
			return true;
		}
		return false;
	}
}
