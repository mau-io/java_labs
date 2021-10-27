package lab3;

public class Bishop extends Piece {

    Bishop() {
        super(3, false);
    }

    Bishop(boolean isWhite) {
        super(3, isWhite);
    }

    @Override
    void move() {
        System.out.println("Diagonally");
    }

    @Override
    public String toString(){
        return "Bishop{value=‘" + value + "’}";
    }
}
