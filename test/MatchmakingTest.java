import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class MatchmakingTest {
    Matchmaking matchmaking;

    @BeforeEach
    void initEach(){
        matchmaking  = new Matchmaking();
    }

    @Test
    void addPlayer() {
        //test if a player is successfully added
        Room oneRoom  =  matchmaking.addPlayer(new Socket());
        assertEquals(1, oneRoom.getPlayers().size());
        //test if a couple of players are successfully added
        while (!oneRoom.isRoomFull()) matchmaking.addPlayer(new Socket());
        assertEquals(Config.getRoomSize(), oneRoom.getPlayers().size());
        //test if a full room opens a new one
        Room otherRoom = matchmaking.addPlayer(new Socket());
        assertNotEquals(oneRoom.getID(), otherRoom.getID());
    }
}