import java.util.Scanner;

public class Main {
//    public static boolean keepLooping = true;
//    public static int score = 0;
//    private static long startTime;
//
//    public static String lastDirection = "Q";

    public static void main(String[] args) {
        Globals.START_TIME = System.currentTimeMillis(); // add a timestamp of start to calculate the spent time

        Scanner scanner = new Scanner(System.in);//created an object Scanner to capture user input

        while (Globals.KEEP_LOOPING) {
            System.out.println("W: Move UP, S: Move Down, A: Move Left, D:Move Right");
            System.out.print("Enter your choice: ");
            var choice = scanner.next();
            Globals.LAST_DIRECTION = choice.toUpperCase();
            if(!Globals.KEEP_MOVING_THREAD.isAlive()){Globals.KEEP_MOVING_THREAD.start();}
            //displayGameInfo(Globals.board);
            //Globals.board.displayBoard();
            //handleUserInput(scanner, Globals.board);
        }

        displayGameOver(Globals.BOARD);

        handleRestart(scanner, Globals.BOARD);
    }
    private static void displayGameInfo(Board board) {
        System.out.println("SCORE: " + Globals.SCORE);
        System.out.println("Snake Length: " + board.getSnakeLength());
        long elapsedSeconds = (System.currentTimeMillis() - Globals.START_TIME) / 1000;
        System.out.println("Elapsed Time: " + elapsedSeconds + "s");
    }
//    private static void handleUserInput(Scanner scanner, Board board) {
//        System.out.println("W: Move UP, S: Move Down, A: Move Left, D:Move Right");
//        System.out.print("Enter your choice: ");
//        var choice = scanner.next();
//        Globals.lastDirection = choice.toUpperCase();
//        if(!Globals.keep.isAlive()){Globals.keep.start();}
//        //board.handleChoice(lastDirection);
//    }
    private static void displayGameOver(Board board) {
        System.out.println("Game Over");
        System.out.println("Final Score: " + Globals.SCORE);
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
            Globals.KEEP_LOOPING = true;
            Globals.SCORE = 0;
            Globals.START_TIME = System.currentTimeMillis(); // Reset the start time for the new game
            board.resetBoard();
        }
    }
}

