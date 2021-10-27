package lab3;

public class Pawn extends Piece {

    protected boolean promoted;
    protected Piece newPiece;

    Pawn() {
        super(1, false);
        setPromoted(false);
        setNewPiece(null);
    }

    Pawn(boolean isWhite) {
        super(1, isWhite);
        setPromoted(false);
        setNewPiece(null);
    }

    Pawn(boolean isWhite, Piece newPiece) {
        super(1, isWhite);
        setPromoted(true);
        setNewPiece(newPiece);
    }

    public void promote(Piece newPiece) {
       setPromoted(true);
       setNewPiece(newPiece);
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public Piece getNewPiece() {
        return newPiece;
    }

    public void setNewPiece(Piece newPiece) {
        this.newPiece = newPiece;
    }

    public Piece getNewPiece(Piece newPiece) {
        return this.newPiece;
    }

    @Override
    void move() {
        System.out.println("Forward 1");
    }

    @Override
    public String toString(){
        return "Pawn{value=‘" + value + "’}";
    }

    @Override
    public boolean equals(Piece piece) {
        if (!this.promoted) return super.equals(piece);

        return  this.newPiece.getValue()   == piece.getValue() &&
                this.newPiece.getIsWhite() == piece.getIsWhite();
    }
}
