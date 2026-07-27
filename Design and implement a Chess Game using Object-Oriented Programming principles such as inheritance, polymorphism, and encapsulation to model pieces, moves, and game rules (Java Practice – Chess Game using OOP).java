import java.util.Scanner;
class Piece {
    private String name;
    Piece(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void move() {
        System.out.println(name + " moves.");
    }
}
class Pawn extends Piece {
    Pawn() {
        super("Pawn");
    }
    @Override
    public void move() {
        System.out.println("Pawn moves one step forward.");
    }
}
class Rook extends Piece {
    Rook() {
        super("Rook");
    }
    @Override
    public void move() {
        System.out.println("Rook moves horizontally or vertically.");
    }
}
class Bishop extends Piece {
    Bishop() {
        super("Bishop");
    }
    @Override
    public void move() {
        System.out.println("Bishop moves diagonally.");
    }
}
class Knight extends Piece {
    Knight() {
        super("Knight");
    }
    @Override
    public void move() {
        System.out.println("Knight moves in L shape.");
    }
}
class Queen extends Piece {
    Queen() {
        super("Queen");
    }
    @Override
    public void move() {
        System.out.println("Queen moves in all directions.");
    }
}
class King extends Piece {
    King() {
       super("King");
    }
    @Override
    public void move() {
        System.out.println("King moves one step in any direction.");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Chess Game ===");
        System.out.println("1. Pawn");
        System.out.println("2. Rook");
        System.out.println("3. Bishop");
        System.out.println("4. Knight");
        System.out.println("5. Queen");
        System.out.println("6. King");
        System.out.print("Choose a piece: ");
        int choice = sc.nextInt();
        Piece piece = null;
        switch (choice) {
            case 1:
                piece = new Pawn();
                break;
            case 2:
                piece = new Rook();
                break;
            case 3:
                piece = new Bishop();
                break;
            case 4:
                piece = new Knight();
                break;
            case 5:
                piece = new Queen();
                break;
            case 6:
                piece = new King();
                break;
            default:
                System.out.println("Invalid Choice");
                System.exit(0);
        }
        System.out.println("Selected Piece : " + piece.getName());
       piece.move();
        sc.close();
    }
}
