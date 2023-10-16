import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static boolean keepLooping = true;
    public static int score = 0;
    private static long startTime;
    public static void main(String[] args) {
        startTime = System.currentTimeMillis(); // add a timestamp of start to calculate the spent time
        var board = new Board((byte) 21,(byte) 9);
        Scanner scanner = new Scanner(System.in);

        while (keepLooping) {
            displayGameInfo(board);
            board.displayBoard();
            handleUserInput(scanner, board);
        }
        displayGameOver(board);
        handleRestart(scanner, board);

    }
    private static void displayGameInfo(Board board) {
        System.out.println("SCORE: " + score);
        System.out.println("Snake Length: " + board.getSnakeLength());
        long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Elapsed Time: " + elapsedSeconds + "s");
    }
    private static void handleUserInput(Scanner scanner, Board board) {
        System.out.println("W: Move UP, S: Move Down, A: Move Left, D:Move Right");
        System.out.print("Enter your choice: ");
        var choice = scanner.next();
        board.handleChoice(choice.toUpperCase());
    }
    private static void displayGameOver(Board board) {
        System.out.println("Game Over");
        System.out.println("Final Score: " + score);
        System.out.println("Final Snake Length: " + board.getSnakeLength());
    }
    private static void handleRestart(Scanner scanner, Board board) {
        String choice;
        do {
            System.out.print("Play again? (y/n): ");
            choice = scanner.next().toLowerCase();
            if (!choice.equals("y") && !choice.equals("n")) {
                System.out.println("Invalid choice. Please enter 'y' for yes or 'n' for no.");
            }
        } while (!choice.equals("y") && !choice.equals("n"));

        if (choice.equals("y")) {
            keepLooping = true;
            score = 0;
            startTime = System.currentTimeMillis(); // Reset the start time for the new game
            board.resetBoard();
        }
    }
}