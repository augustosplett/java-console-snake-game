package Block.State;
//import Block.Block;
public class Apple implements IState{
    private static final Apple instance = new Apple();

    public static Apple instance(){
        return instance;
    }
    @Override
    public char display() {
        return '¢';
    }

//    @Override
//    public void move(Block block) {
//
//    }
}
