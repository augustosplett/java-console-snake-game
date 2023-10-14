import Block.Block;
import Block.State.Blank;
import Block.State.Wall;

public class Board {

    private final byte boardWidth;
    private final byte boardHeight;
    private final Block[][] board;

    public Board(byte boardWidth, byte boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.board = new Block[boardHeight][boardWidth];
        initializeBoard();
    }

    private void initializeBoard(){
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
    public void displayBoard() {
        for (var i = 0; i < this.boardHeight; i++) {
            for (var j = 0; j < this.boardWidth; j++) {
                System.out.print(board[i][j].getState().display());
            }
            System.out.println();
        }
    }
}


