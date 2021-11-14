package Board;

import java.util.Scanner;
import Pieces.AbstractPiece;
import Player.*;

public class Game {
	private Boolean gameRunning;
	private AbstractPiece[][] chessboard = new AbstractPiece[8][8]; // [row][column]

	Scanner user_input = new Scanner(System.in);
	private static int srcRow, srcCol, destRow, destCol;
	private static Boolean whitesTurnToMove = true; // White starts first
	// Set to true if move is invalid. Asks for user input again in move() method.
	private static Boolean invalidMove = false;
	String move;

	public Game() {
		initialiseBoard(chessboard);
		gameRunning = true;
	}

	public Boolean getGameRunning() {
		return this.gameRunning;
	}

	private static void initialiseBoard(AbstractPiece[][] chessboard) {
		// a chessboard with 8x8 matrix of pieces
		// rows [0] and [1] are black
		// rows [6] and [7] are white
		for (int row = 0; row < chessboard.length; row++) {
			for (int col = 0; col < chessboard[row].length; col++) {
				
				if (row == 0) {

					switch (col) {
					case 0:
						chessboard[row][col] = new Rook(false);
						break;
					case 1:
						chessboard[row][col] = new Knight(false);
						break;
					case 2:
						chessboard[row][col] = new Bishop(false);
						break;
					case 3:
						chessboard[row][col] = new Queen(false);
						break;
					case 4:
						chessboard[row][col] = new King(false);
						break;
					case 5:
						chessboard[row][col] = new Bishop(false);
						break;
					case 6:
						chessboard[row][col] = new Knight(false);
						break;
					case 7:
						chessboard[row][col] = new Rook(false);
						break;
					}
				} else if (row == 1) {
					chessboard[row][col] = new Pawn(false);
				} else if (row == 6) {
					chessboard[row][col] = new Pawn(true);
				} else if (row == 7) {
					switch (col) {
					case 0:
						chessboard[row][col] = new Rook(true);
						break;
					case 1:
						chessboard[row][col] = new Knight(true);
						break;
					case 2:
						chessboard[row][col] = new Bishop(true);
						break;
					case 3:
						chessboard[row][col] = new Queen(true);
						break;
					case 4:
						chessboard[row][col] = new King(true);
						break;
					case 5:
						chessboard[row][col] = new Bishop(true);
						break;
					case 6:
						chessboard[row][col] = new Knight(true);
						break;
					case 7:
						chessboard[row][col] = new Rook(true);
						break;
					}
				} else {
					chessboard[row][col] = null;
				}
			}
		}

	}

	public void printBoard() {
		for (int row = 0; row < chessboard.length; row++) {
			System.out.print(8 - row + "\t");
			for (int col = 0; col < chessboard[row].length; col++) {
				if (chessboard[row][col] != null) {
					chessboard[row][col].draw();
					System.out.print("\t");

				} else {
					System.out.print("•\t");
				}
			}
			System.out.print(8 - row + "\t");
			System.out.println();
		}
		System.out.println("\n");
		System.out.println("\ta\tb\tc\td\te\tf\tg\th");
	}

	private boolean moveValid() {

		// invalid if the move origin or destination is outside the board
		if (srcRow < 0 || srcRow > 7 || srcCol < 0 || srcCol > 7 || destRow < 0
				|| destRow > 7 || destCol < 0 || destCol > 7) {
			System.out.println("Move is outside the board");
			return false;
		}

		// Invalid if origin is null
		if (chessboard[srcRow][srcCol] == null) {
			System.err.println("Origin is empty");
			return false;
		}
		// Invalid if player moves when it's not their turn
		if (
				(chessboard[srcRow][srcCol].isWhite && !whitesTurnToMove)
				|| (!chessboard[srcRow][srcCol].isWhite && whitesTurnToMove)
		) {

			System.err.println("It's not your turn");
			return false;
		}

		// return false if specific piece rules are not obeyed
		if (!chessboard[srcRow][srcCol].isValidMove(srcRow, srcCol, destRow, destCol)) {
			System.err.println("This piece doesn't move like that");
			return false;
		}

		// this statement stops the statement for checking if white lands on
		// white from performing isWhite() on a null space
		if (chessboard[destRow][destCol] == null) {
			return true;
		}

		// invalid if the white lands on white
		if (chessboard[srcRow][srcCol].isWhite
				&& chessboard[destRow][destCol].isWhite) {
			System.err.println("White cannot land on white");
			return false;
		}

		// invalid if the black lands on black
		if (!chessboard[srcRow][srcCol].isWhite
				&& !chessboard[destRow][destCol].isWhite) {
			System.err.println("Black cannot land on black");
			return false;
		}

		return true;
	}

	// this method is called when the user enters a move in the form of a string (e.g. "a1 a3") 
	// and it is checked to see if it is valid and then if it is, it is executed and the board is updated accordingly (e.g. the piece at a1 is moved to a3) 
	public void move() {

		if (invalidMove) {
			System.err.println("Move is invalid. Please try again:");
			invalidMove = false;
		}

		else if (whitesTurnToMove) {
			System.out.println("___________________________________________________\n"
							+ "White's turn to move\n"
							+ "___________________________________________________\n");
		} else {
			System.out.println("___________________________________________________\n"
							+ "Black's turn to move\n"
							+ "___________________________________________________\n");
		}


		System.out.print( "Enter UCI (type 'help' for help):");
		move = user_input.nextLine();

		if (move.equalsIgnoreCase("exit")) {
			gameRunning = false;
			System.out.println("Thanks for playing.");
			return;
		}

		// if move is equal to 'help' print out the instructions
		if (move.equalsIgnoreCase("help")) {
				System.out.println("___________________________________________________\n"
							+ "To move a piece, enter the coordinates of the piece\n"
							+ "and the coordinates of where you want to move it.\n"
							+ "For example, to move the piece at d2 to d3, enter\n"
							+ "d2 to d3.");
			
				System.out.println("___________________________________________________\n"
							+ "* type 'help' for help"
							+ "* type 'board' to see the board again\n"
							+ "* type 'resign' to resign\n"
							+ "* type 'moves' to list all possible moves\n"
							+ "* type a square (e.g. b1, e2) to list possible moves for that square\n"
							+ "* type UCI (press d2 to d3, For example, to move the piece at d2 to d3). \n"
					        + "* type 'exit' to exit the game.\n");
				move();
		}
		
		// if move is equal to 'board' print out the board
		if (move.equalsIgnoreCase("board")) {
			printBoard();
			move();
		}

		// if move is equal to 'resign' end the game
		if (move.equalsIgnoreCase("resign")) {
			gameRunning = false;
			if (whitesTurnToMove) {
				System.out.println("Black wins!");
			} else {
				System.out.println("White wins!");
			}
			return;
		}

		if (move.matches("[a-h][1-8]")) {
			String lowerCase = move.toLowerCase();
			srcCol = lowerCase.charAt(0) - 'a';
			srcRow = 7 - (lowerCase.charAt(1) - '1');
			System.out.println("srcRow " + srcRow
					 +" srcCol "+ srcCol);
			chessboard[srcRow][srcCol].printPossibleMoves(srcRow, srcCol, chessboard);
			move();
		}

		// check if the string is in the correct format
		if (!move.matches("[a-h][1-8] to [a-h][1-8]")) {
			System.err.println("Invalid move format. Please try again:");
			move();
		}

		// convert to lower case
		String lowerCase = move.toLowerCase();
		// parse move string into components
		String[] components = lowerCase.split(" ");

		// if you assume that move is "e1 to e5" then
		// use chars in components to set the array coordinates of the
		// move origin and move destination
		srcCol = components[0].charAt(0) - 'a';
		srcRow = 7 - (components[0].charAt(1) - '1');

		destCol = components[2].charAt(0) - 'a';
		destRow = 7 - (components[2].charAt(1) - '1');

		if (moveValid()) {		
			// put piece in destination
			chessboard[destRow][destCol] = chessboard[srcRow][srcCol];
			// empty the origin of the move
			chessboard[srcRow][srcCol] = null;
			whitesTurnToMove = !whitesTurnToMove;

			// Special Move #1 Promotion
			// check if the move results in a pawn reaching the other side of the board
			if (chessboard[destRow][destCol] instanceof Pawn) {
				if (destRow == 0) {
					chessboard[destRow][destCol] = new Queen(true);
				} else if (destRow == 7) {
					chessboard[destRow][destCol] = new Queen(false);
				}
			}

		} else {
			invalidMove = true;
			move();
		}

	}

}
