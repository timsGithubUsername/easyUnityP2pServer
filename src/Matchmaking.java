import java.net.Socket;

/**
 * This class delegates players (sockets) to rooms
 */
public class Matchmaking {
    private Room room;

    /**
     * Adding a player (socket) to a room
     *
     * @param player a socket to add to a room
     * @return the room where the player is added
     */
    public Room addPlayer(Socket player){
        if(room == null || room.isRoomFull())  room  = new Room();
        room.addPlayer(player);

        return room;
    }
}
