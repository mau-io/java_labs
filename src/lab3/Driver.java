package lab3;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {

        List<Piece> pieces = new ArrayList<>();

        Pawn pawn     = new Pawn();
        Knight knight = new Knight();
        Bishop bishop = new Bishop();
        Rook rook     = new Rook();
        Queen queen   = new Queen();
        King king     = new King();

        pieces.add(pawn);
        pieces.add(knight);
        pieces.add(bishop);
        pieces.add(rook);
        pieces.add(queen);
        pieces.add(king);

        for (Piece p : pieces) {
            p.move();
        }

        Pawn p1 = new Pawn(true,  new Queen(true));
        Pawn p2 = new Pawn(true);
        Pawn p3 = new Pawn(false);
        Pawn p4 = new Pawn(false, new Queen(true));
        Pawn p5 = new Pawn(true,  new Knight(true));

        /**
         * p1.equals(p2) should return false
         * p1.equals(p4) should return false
         * p1.equals(p5) should return false
         * p2.equals(p3) should return false
         * p4.equals(p5) should return false
         */

        System.out.println("p1.equals(p2) should return " + p1.equals(p2));
        System.out.println("p1.equals(p4) should return " + p1.equals(p4));
        System.out.println("p1.equals(p5) should return " + p1.equals(p5));
        System.out.println("p2.equals(p3) should return " + p2.equals(p3));
        System.out.println("p4.equals(p5) should return " + p4.equals(p5));

    }
}
