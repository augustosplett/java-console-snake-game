import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Globals.START_TIME = System.currentTimeMillis(); // add a timestamp of start to calculate the spent time

        Globals.KEEP_MOVING_THREAD= new ThreadKeepMoving();

        gameLoop();

    }
    public static void gameInstructions(){
        System.out.println("To move the snake, use the following keys: ");
        System.out.println("W: Move UP, S: Move Down, A: Move Left, D:Move Right");
        System.out.println("Enter your choice: ");
    }
    public static void gameLoop(){
        gameInstructions();

        movingLoop();

        displayGameOver(Globals.BOARD);

        handleRestart(Globals.SCANNER, Globals.BOARD);
    }
    public static void movingLoop(){
        while (Globals.KEEP_LOOPING) {
            var choice = Globals.SCANNER.next();
            Globals.LAST_DIRECTION = choice.toUpperCase();
            if(!Globals.KEEP_MOVING_THREAD.isAlive() && Globals.KEEP_LOOPING){Globals.KEEP_MOVING_THREAD.start();}
        }
    }
    private static void displayGameOver(Board board) {
        System.out.println("Game Over");
        System.out.println("Final Score: " + Globals.SCORE);
        System.out.println("Final Snake Length: " + board.getSnakeLength());
    }
    private static void displayGameInfo(Board board) {
        System.out.println("SCORE: " + Globals.SCORE);
        System.out.println("Snake Length: " + board.getSnakeLength());
        long elapsedSeconds = (System.currentTimeMillis() - Globals.START_TIME) / 1000;
        System.out.println("Elapsed Time: " + elapsedSeconds + "s");
    }

    public static void handleRestart(Scanner scanner, Board board) {
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
            Globals.LAST_DIRECTION = null;
            Globals.THREAD_SHOULD_RUN = true;
            Globals.KEEP_MOVING_THREAD= new ThreadKeepMoving();
            System.out.println(Globals.KEEP_MOVING_THREAD.isAlive());
            board.resetBoard();
            gameLoop();
        }
    }
}

