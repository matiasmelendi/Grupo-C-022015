package model;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void aTeamShouldKnowTheDefenderPlayers(){
        Team team = anyTeam();
        team.addPlayer(anyPlayer());

        assertEquals(expectedDefenders(), team.defenders());
    }

    @Test
    public void whenATeamIsCreatedItShouldNotHavePlayers(){
        assertTrue(anyTeam().players().isEmpty());
    }

    @Test
    public void whenIAddAPlayerThePlayersCountShouldIncrementByOne(){
        Team team = anyTeam();
        team.addPlayer(anyPlayer());

        assertEquals(team.players().size(), 1);
    }

    /*
    * Helper methods
    * */

    private List<Player> expectedDefenders(){
        List<Player> defenders = new ArrayList<Player>();

        defenders.add(anyPlayer());

        return defenders;
    }

    private Player anyPlayer(){
        return new Player("Pepe", Position.DEFENDER, anyTeam());
    }

    private Team anyTeam(){
        return new Team();
    }
}
