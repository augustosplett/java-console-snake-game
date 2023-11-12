import java.util.concurrent.TimeUnit;

class ThreadKeepMoving extends Thread{
    boolean running = true;
    public void run(){

        while(running){
            try {
                TimeUnit.MILLISECONDS.sleep(800);
                Globals.BOARD.handleChoice(Globals.LAST_DIRECTION);
                //displayGameInfo(Globals.board);
                Globals.BOARD.displayBoard();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void stopThread() {
        running = false;
    }
}