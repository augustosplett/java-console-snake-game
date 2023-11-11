import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
class Globals{
    public static boolean keepLooping = true;
    public static int score = 0;
    public static long startTime;
    public static String lastDirection = "Q";
    public static Board board = new Board((byte) 21,(byte) 9);//created a board to initialize the game
    public static KeepMoving keep = new KeepMoving();
}
public class Main {
//    public static boolean keepLooping = true;
//    public static int score = 0;
//    private static long startTime;
//
//    public static String lastDirection = "Q";

    public static void main(String[] args) {
        Globals.startTime = System.currentTimeMillis(); // add a timestamp of start to calculate the spent time

        Scanner scanner = new Scanner(System.in);//created an object Scanner to capture user input

        while (Globals.keepLooping) {
            System.out.println("W: Move UP, S: Move Down, A: Move Left, D:Move Right");
            System.out.print("Enter your choice: ");
            var choice = scanner.next();
            Globals.lastDirection = choice.toUpperCase();
            if(!Globals.keep.isAlive()){Globals.keep.start();}
            //displayGameInfo(Globals.board);
            //Globals.board.displayBoard();
            //handleUserInput(scanner, Globals.board);
        }

        displayGameOver(Globals.board);

        handleRestart(scanner, Globals.board);
    }
    private static void displayGameInfo(Board board) {
        System.out.println("SCORE: " + Globals.score);
        System.out.println("Snake Length: " + board.getSnakeLength());
        long elapsedSeconds = (System.currentTimeMillis() - Globals.startTime) / 1000;
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
        System.out.println("Final Score: " + Globals.score);
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
            Globals.keepLooping = true;
            Globals.score = 0;
            Globals.startTime = System.currentTimeMillis(); // Reset the start time for the new game
            board.resetBoard();
        }
    }
}

class KeepMoving extends Thread{
    boolean running = true;
    public void run(){

        while(running){
            try {
                TimeUnit.MILLISECONDS.sleep(800);
                Globals.board.handleChoice(Globals.lastDirection);
                //displayGameInfo(Globals.board);
                Globals.board.displayBoard();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void stopThread() {
        running = false;
    }
}