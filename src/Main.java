import java.util.Scanner;

public class Main {
    public static boolean keepLooping = true;
    public static int score = 0;
    public static void main(String[] args) {


        var board = new Board((byte) 21,(byte) 9);
        Scanner scanner = new Scanner(System.in);

        while (keepLooping) {
            System.out.println("SCORE: " + score );
            board.displayBoard();
            System.out.println("W: Move UP, S: Move Down, A: Move Left, D:Move Right");
            System.out.print("Enter your choice: ");
            var choice = scanner.next();
            handleChoice(choice.toUpperCase(), board);
        }
        System.out.println("---END GAME---");
    }
    public static void handleChoice( String choice, Board board){
        switch (choice){
            case "W": board.moveSnakeUp(); break;
            case "S": board.moveSnakeDown(); break;
            case "A": board.moveSnakeLeft(); break;
            case "D": board.moveSnakeRight(); break;
            default:
                System.out.println("--Invalid Entry!--");
        }
    }
}