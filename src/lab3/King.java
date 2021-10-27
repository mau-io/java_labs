package lab3;

public class King extends Piece {

    King() {
        super(1000, false);
    }

    King(boolean isWhite) {
        super(1000, isWhite);
    }

    @Override
    void move() {
        System.out.println("One square");
    }

    @Override
    public String toString(){
        return "King{value=‘" + value + "’}";
    }
}