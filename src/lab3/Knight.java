package lab3;

public class Knight extends Piece {
    Knight() {
        super(2, false);
    }
    Knight(boolean isWhite) {
        super(2, isWhite);
    }

    @Override
    void move() {
        System.out.println("Like an L");
    }

    @Override
    public String toString(){
        return "Knight{value=‘" + value + "’}";
    }
}
