package lab3;

public class Rook extends Piece {

    Rook() {
        super(5, false);
    }

    Rook(boolean isWhite) {
        super(5, isWhite);
    }

    @Override
    void move() {
        System.out.println("Horizontally or vertically");
    }

    @Override
    public String toString(){
        return "Rook{value=‘" + value + "’}";
    }
}
