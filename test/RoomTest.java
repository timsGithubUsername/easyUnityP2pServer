import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    Room room;

    @BeforeEach
    void initEach(){
        room = new Room();
    }

    @Test
    void addPlayer() {
        //test if room is empty
        assertEquals(0, room.getPlayers().size());
        //test joining from players
        room.addPlayer(new Socket());
        assertEquals(1, room.getPlayers().size());
        room.addPlayer(new Socket());
        assertEquals(2, room.getPlayers().size());
        //test closing of room if players overflow
        while(!room.isRoomFull() && room.getPlayers().size() <= Config.MAX_ROOM_SIZE) room.addPlayer(new Socket());
        room.addPlayer(new Socket());
        assertEquals(0, room.getPlayers().size());
    }

    @Test
    void isRoomFull() {
        //test if full room is full
        while(!room.isRoomFull() && room.getPlayers().size() <= Config.MAX_ROOM_SIZE) room.addPlayer(new Socket());
        assertEquals(Config.getRoomSize(), room.getPlayers().size());
    }

    @Test
    void closeRoom() {
        //test succesful closing of a room
        while(!room.isRoomFull() && room.getPlayers().size() <= Config.MAX_ROOM_SIZE) room.addPlayer(new Socket());
        room.closeRoom();
        assertEquals(0, room.getPlayers().size());
    }
}