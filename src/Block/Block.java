package Block;

import Block.State.IState;

public class Block {

    private IState State;

    public Block(IState state) {
        this.State = state;
    }

    public IState getiState() {
        return State;
    }

    public void setState(IState state) {
        this.State = state;
    }
}
