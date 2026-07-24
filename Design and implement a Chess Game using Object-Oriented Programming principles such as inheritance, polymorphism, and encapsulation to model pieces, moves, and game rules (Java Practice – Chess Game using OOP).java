class Piece {
    private String name;

    Piece(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move(String from, String to) {
        System.out.println(name + " moved from " + from + " to " + to);
    }
}

class Pawn extends Piece {

    Pawn() {
        super("Pawn");
    }

    @Override
    public void move(String from, String to) {
        System.out.println("Pawn moved from " + from + " to " + to);
    }
}

public class ChessGame {

    public static void main(String[] args) {

        System.out.println("=== Chess Game (Console Version) ===\n");

        System.out.println("Initial Board Setup");
        System.out.println("8 r n b q k b n r");
        System.out.println("7 p p p p p p p p");
        System.out.println("6 . . . . . . . .");
        System.out.println("5 . . . . . . . .");
        System.out.println("4 . . . . . . . .");
        System.out.println("3 . . . . . . . .");
        System.out.println("2 P P P P P P P P");
        System.out.println("1 R N B Q K B N R");
        System.out.println("  a b c d e f g h");

        Piece white = new Pawn();
        Piece black = new Pawn();

        System.out.println("\nWhite's Turn");
        white.move("e2", "e4");

        System.out.println("\nBlack's Turn");
        black.move("e7", "e5");

        System.out.println("\nCheck!");
        System.out.println("White King is in Check.");

        System.out.println("\nCheckmate!");
        System.out.println("Black Wins the Game.");
    }
}
