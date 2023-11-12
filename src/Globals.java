import java.util.Scanner;

class Globals{
    public static boolean KEEP_LOOPING = true;
    public static int SCORE = 0;
    public static long START_TIME;
    public static String LAST_DIRECTION;
    public static Board BOARD = new Board((byte) 21,(byte) 9);
    public static ThreadKeepMoving KEEP_MOVING_THREAD;
    public static long THREAD_REFRESH_RATE = 800;
    public static boolean THREAD_SHOULD_RUN = true;
    public static Scanner SCANNER = new Scanner(System.in);//created an object Scanner to capture user input

}