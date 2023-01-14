/**
 * This class holds all configurations for the server.
 *
 * ToDo all non-final values should be loaded by a file! Also, the value MAX_ROOM_SIZE is 10 without any reason, maybe
 * there is a better and more reasonable number.
 */
public class Config {

    final static int  MAX_ROOM_SIZE = 10;
    final static int  MIN_ROOM_SIZE = 2;

    private static int roomSize =  2;

    public static int getRoomSize() {
        return roomSize;
    }
}
