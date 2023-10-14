package Block;

import Block.State.IState;

public class Block {

    private IState State;
    private final byte positionX;
    private final byte positionY;

    public Block(IState state,byte positionX, byte positionY) {
        this.State = state;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public IState getState() {
        return State;
    }

    public void setState(IState state) {
        this.State = state;
    }
}
