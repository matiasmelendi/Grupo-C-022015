import exceptions.PositionFull;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void aTeamShouldKnowTheDefenderPlayers(){
        Team team = anyTeam();
        Player defender = anyPlayer();
        addPlayerToTeam(team, defender);

        assertEquals(expectedDefenders(), team.defenders());
    }

    @Test
    public void aTeamShouldKnowTheMidfielderPlayers(){
        Team team = anyTeam();
        addPlayerToTeam(team, midfielder());

        assertEquals(expectedMidfielders(), team.midfielders());
    }

    @Test
    public void aTeamShouldKnowTheForwarderPlayers() {
        Team team = anyTeam();
        addPlayerToTeam(team, forwarder());

        assertEquals(expectedForwarders(), team.forwarders());
    }

    @Test
    public void whenATeamIsCreatedItShouldNotHavePlayers(){
        assertTrue(anyTeam().players().isEmpty());
    }

    @Test
    public void whenIAddAPlayerThePlayersCountShouldIncrementByOne() throws PositionFull {
        Team team = anyTeam();
        team.addPlayer(anyPlayer());

        assertEquals(team.players().size(), 1);
    }

    @Test(expected = PositionFull.class)
    public void whenIAddAPlayerAndHisPositionIsTotallyCoveredItShouldFail() throws PositionFull {
        Team team = anyTeam();
        Player defender = anyPlayer();

        team.addPlayer(defender);
        team.addPlayer(defender);
        team.addPlayer(defender);

        /* Only three forwarders are allowed on a 3-4-3 formation */
        team.addPlayer(defender);
    }

    /*
    * Helper methods
    * */

    private Player forwarder(){
        Player forwarder = anyPlayer();
        forwarder.changePosition(Position.FORWARD);

        return forwarder;
    }

    private Player midfielder(){
        Player midfielder = anyPlayer();
        midfielder.changePosition(Position.MIDFIELDER);

        return midfielder;
    }

    private List<Player> expectedDefenders(){
        List<Player> defenders = new ArrayList<Player>();

        defenders.add(anyPlayer());

        return defenders;
    }

    private List<Player> expectedMidfielders(){
        List<Player> midfielders = new ArrayList<Player>();

        midfielders.add(midfielder());

        return midfielders;
    }

    private List<Player> expectedForwarders(){
        List<Player> forwarders = new ArrayList<Player>();

        forwarders.add(forwarder());

        return forwarders;
    }

    private Player anyPlayer(){
        return new Player("Pepe", Position.DEFENDER, anyTeam());
    }

    private Team anyTeam(){
        return new Team();
    }

    private Team addPlayerToTeam(Team team, Player player){
        try{
            team.addPlayer(player);
        }catch (PositionFull e){
            fail("Position is Full you can't add another player");
        }

        return team;
    }
}
