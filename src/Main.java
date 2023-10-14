//import Block.Block;
//import Block.State.Apple;
//import Block.State.Blank;
//import Block.State.Body;
//import Block.State.Wall;
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        var block1 = new Block(Apple.instance());
//        var block2 = new Block(Blank.instance());
//        var block3 = new Block(Body.instance());
//        var block4 = new Block(Wall.instance());
//        System.out.println(block1.getState().display());
//        System.out.println(block2.getState().display());
//        System.out.println(block3.getState().display());
//        System.out.println(block4.getState().display());
        var board = new Board((byte) 20,(byte)10);
        board.displayBoard();
    }
}