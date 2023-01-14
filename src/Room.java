import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 * This class organizes all players in one room. Here all players of the room are collected to provide their information
 * (sockets) during a match and during matchmaking.
 *
 * ToDo this room must be passed to an instance that transmits the communication during matchmaking.
 */
public class Room {
    private final long ID = System.currentTimeMillis();

    private boolean roomFull = false;
    private final ArrayList<Socket> players = new ArrayList<>();

    public ArrayList<Socket> getPlayers(){
        return players;
    }

    public long getID(){
        return ID;
    }

    /**
     * Check if a room is full and return the value
     *
     * @return is this room full
     */
    public boolean isRoomFull() {
        roomFull = players.size() >= Config.getRoomSize();
        return roomFull;
    }

    /**
     * Add a player to this room.
     * This room close if you try to add a player to this room but the room is already full! You need to check this!
     *
     * @param player the player to add
     */
    public void addPlayer(Socket player){
        if(!isRoomFull()){
            players.add(player);
        }
        else try {
            throw new Exception("Room Full!");
        } catch (Exception e) {
            e.printStackTrace();
            closeRoom();
        }
    }

    /**
     * Close all sockets from the players and remove them from "players"
     *
     */
    public void closeRoom(){
        while (players.size() > 0){
            try {
                players.get(0).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            players.remove(0);
        }
    }
}
