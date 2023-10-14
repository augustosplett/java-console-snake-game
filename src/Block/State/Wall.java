package Block.State;
//import Block.Block;
public class Wall implements IState{
    private static final Wall instance = new Wall();

    public static Wall instance(){
        return instance;
    }
    @Override
    public char display() {
        return '#';
    }

//    @Override
//    public void move(Block block) {
//
//    }
}
