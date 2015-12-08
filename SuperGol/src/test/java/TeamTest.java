import exceptions.AbsentCaptain;
import exceptions.PositionFull;
import model.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void aTeamShouldHaveAName(){
        assertEquals(barcelona().name(), "F.C Barcelona");
    }

    @Test
    public void aTeamShouldHaveACaptain() throws AbsentCaptain {
        assertEquals(barcelona().captain(), messi());
    }

    @Test
    public void teamsWithDifferentNamesAreDifferents(){
        Team team1 = new Team("Pepe 1");
        Team team2 = new Team("Pepe 2");

        assertFalse(team1.equals(team2));
    }

    @Test
    public void teamsWithTheSameNameAreEquals(){
        Team team1 = new Team("Pepe 1");
        Team team2 = new Team("Pepe 1");

        assertTrue(team1.equals(team2));
    }

    @Test
    public void aCreatorCouldBeAssigned(){
        Team team = anyTeam();
        User creator = new User("Memin", "zxcasdqwe", team);

        team.beAssignedTo(creator);

        assertEquals(creator, team.creator());
    }

    /** When a team has no captain */
    @Test(expected = AbsentCaptain.class)
    public void itShouldFail() throws AbsentCaptain {
        anyTeam().captain();
    }

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

    /** When a match result is stored */
    @Test
    public void itShouldKnowHisPointsAndTheScorers(){
        Team team1 = anyTeam();
        Match match = new Match(team1, anyTeam());
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        MatchResult result = new MatchResult(match, emptyListOfScorers, 1, emptyListOfScorers, 1);

        team1.saveMatchResult(result);

        assertEquals(Integer.valueOf(1), team1.pointsOnMatch(match));
        assertEquals(emptyListOfScorers, team1.scorersOnMatch(match));
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
        return new Team("A team name");
    }

    private Player messi(){
        Player messi = new Player("Leo Messi", Position.FORWARD, anyTeam());
        messi.becomeCaptain();

        return messi;
    }

    private Team barcelona(){
        Team barcelona = new Team("F.C Barcelona");
        addPlayerToTeam(barcelona, messi());

        return barcelona;
    }

    private Team addPlayerToTeam(Team team, Player player){
        try{
            team.addPlayer(player);
        }catch (PositionFull e){
            fail("model.Position is Full you can't add another player");
        }

        return team;
    }
}
