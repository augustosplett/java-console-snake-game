class Globals{
    public static boolean KEEP_LOOPING = true;
    public static int SCORE = 0;
    public static long START_TIME;
    public static String LAST_DIRECTION;
    public static Board BOARD = new Board((byte) 21,(byte) 9);
    public static ThreadKeepMoving KEEP_MOVING_THREAD = new ThreadKeepMoving();
}