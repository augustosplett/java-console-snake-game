import java.util.ArrayList;
import java.util.Scanner;

//import Block.Block;
//import Block.State.Apple;
//import Block.State.Blank;
//import Block.State.Body;
//import Block.State.Wall;
public class Main {
    public static void main(String[] args) {

        var board = new Board((byte) 21,(byte) 9);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.displayBoard();
            System.out.println("W: Move UP, S: Move Down, A: Move Left, D:Move Right");
            System.out.print("Enter your choice: ");
            var choice = scanner.next();
            handleChoice(choice.toUpperCase(), board);
        }
    }
    public static void handleChoice( String choice, Board board){
        switch (choice){
            case "W": board.moveSnakeUp(); break;
            case "S": board.moveSnakeDown(); break;
            case "A": board.moveSnakeLeft(); break;
            case "D": board.moveSnakeRight(); break;
        }
    }
}