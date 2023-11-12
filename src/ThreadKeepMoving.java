import java.util.concurrent.TimeUnit;

class ThreadKeepMoving extends Thread{
    public void run(){

        while(Globals.THREAD_SHOULD_RUN ){
            try {
                TimeUnit.MILLISECONDS.sleep(Globals.THREAD_REFRESH_RATE);
                Globals.BOARD.handleChoice(Globals.LAST_DIRECTION);
                //displayGameInfo(Globals.board);
                Globals.BOARD.displayBoard();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void stopThread() {
        Globals.THREAD_SHOULD_RUN = false;
    }
}