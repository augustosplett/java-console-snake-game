package Block.State;
//import Block.Block;
public class Blank implements IState{
    private static final Blank instance = new Blank();

    public static Blank instance(){
        return instance;
    }
    @Override
    public char display() {
        return ' ';
    }

//    @Override
//    public void move(Block block) {
//
//    }
}
