package lab3;

public abstract class Piece {

    protected int value;
    protected boolean isWhite;

    Piece(int value, boolean isWhite) {
        setValue(value);
        setIsWhite(isWhite);
    }

    abstract void move();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setIsWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean getIsWhite() {
        return isWhite;
    }

    public boolean equals(Piece piece) {
        return  piece.getValue()   == this.getValue() &&
                piece.getIsWhite() == this.getIsWhite();
    }

    @Override
    public String toString() {
        return "Piece{value=" + value + "}";
    }
}