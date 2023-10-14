import Block.Block;
import Block.State.Apple;
import Block.State.Blank;
import Block.State.Body;
import Block.State.Wall;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        var block1 = new Block(Apple.instance());
        var block2 = new Block(Blank.instance());
        var block3 = new Block(Body.instance());
        var block4 = new Block(Wall.instance());
//        System.out.println(block1.getiState().display(););
        System.out.println(block1.getiState().display());
        System.out.println(block2.getiState().display());
        System.out.println(block3.getiState().display());
        System.out.println(block4.getiState().display());

    }
}