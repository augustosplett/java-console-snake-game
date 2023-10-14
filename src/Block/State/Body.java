package Block.State;
//import Block.Block;
public class Body implements IState{
    private static final Body instance = new Body();

    public static Body instance(){
        return instance;
    }
    @Override
    public char display() {
        return '@';
    }

//    @Override
//    public void move(Block block) {
//
//    }
}
