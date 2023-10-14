import Block.Block;
import Block.State.Blank;
import Block.State.Body;
import Block.State.Wall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private final byte boardWidth;//define the board Width dynamically
    private final byte boardHeight;//define the board Height dynamically
    private final Block[][] board;
    private List<Block> snake = new ArrayList<>();

    public Board(byte boardWidth, byte boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.board = new Block[boardHeight][boardWidth];
        initializeBoard();
    }

    private void initializeBoard(){
        createTiles();
        placeSnake();
    }

    private void createTiles(){
        Block tile;
        for (byte i = 0; i < this.boardHeight; i++) {
            for (byte j = 0; j < this.boardWidth; j++) {
                if(isWall(j, i)){
                    tile = new Block(Wall.instance(), j, i);
                }else{
                    tile = new Block(Blank.instance(), j, i);
                }
                board[i][j] = tile;
            }
        }
    }

    private boolean isWall(byte x, byte y){
        if(x == 0) return true;
        else if(y == 0) return true;
        else if (y == (boardHeight - 1)) return true;
        else return x == (boardWidth - 1);
    }

    private void placeSnake(){
        //try to place in the middle of the board
        int posX = this.boardWidth / 2;
        int posY = this.boardHeight / 2;

        //change the state to be a body part
        board[posY][posX].setState(Body.instance());
        board[posY + 1][posX].setState(Body.instance());
        board[posY + 2][posX].setState(Body.instance());
        //include into snake array to control move
        snake.add(board[posY + 2][posX]);
        snake.add(board[posY + 1][posX]);
        snake.add(board[posY][posX]);


    }
    public void displayBoard() {
        //print the board into console
        for (var i = 0; i < this.boardHeight; i++) {
            for (var j = 0; j < this.boardWidth; j++) {
                System.out.print(board[i][j].getState().display());
            }
            System.out.println();
        }
    }
    public void popLastSnakeBodyPiece(){
        //var lastIndex = snake.size() - 1;
        snake.get(0).setState(Blank.instance());
        snake.remove(0);
    }
    public void moveSnakeUp(){
        //add validation to check if the snake is not trying to backwards
        //it can be done validating it the head == (head - 1)
        var snakeHead = snake.get(snake.size()-1);
        var snakeTail = snake.get(0);
        var newHead = board[snakeHead.getPositionX()-1][snakeHead.getPositionY()];

        snake.add(newHead);
        newHead.setState(Body.instance());

        snakeTail.setState(Blank.instance());
        snake.remove(snakeTail);

    }
    public void moveSnakeDown(){
        //add validation to check if the snake is not trying to backwards
        //it can be done validating it the head == (head - 1)
        var snakeHead = snake.get(snake.size()-1);
        var snakeTail = snake.get(0);
        var newHead = board[snakeHead.getPositionX()+1][snakeHead.getPositionY()];

        snake.add(newHead);
        newHead.setState(Body.instance());

        snakeTail.setState(Blank.instance());
        snake.remove(snakeTail);
    }
    public void moveSnakeLeft(){
        //add validation to check if the snake is not trying to backwards
        //it can be done validating it the head == (head - 1)
        var snakeHead = snake.get(snake.size()-1);
        var snakeTail = snake.get(0);
        var newHead = board[snakeHead.getPositionX()][snakeHead.getPositionY()-1];

        snake.add(newHead);
        newHead.setState(Body.instance());

        snakeTail.setState(Blank.instance());
        snake.remove(snakeTail);
    }
    public void moveSnakeRight(){
        //add validation to check if the snake is not trying to backwards
        //it can be done validating it the head == (head - 1)
        var snakeHead = snake.get(snake.size()-1);
        var snakeTail = snake.get(0);
        var newHead = board[snakeHead.getPositionX()][snakeHead.getPositionY()+1];

        snake.add(newHead);
        newHead.setState(Body.instance());

        snakeTail.setState(Blank.instance());
        snake.remove(snakeTail);
    }
}


