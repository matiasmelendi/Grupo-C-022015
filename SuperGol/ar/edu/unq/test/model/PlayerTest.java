package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void aPlayerPositionShouldChangeWhenANewOneIsAssigned() {
        Player player = anyPlayerWithPosition(Position.DEFENDER);
        Position newPosition = Position.FORWARD;
        player.changePosition(newPosition);
        assertEquals(player.position(), newPosition);
    }

    private Player anyPlayerWithPosition(Position position) {
        return new Player("Player Name", position, anyTeam());
    }

    private Team anyTeam() {
        return new Team();
    }

}