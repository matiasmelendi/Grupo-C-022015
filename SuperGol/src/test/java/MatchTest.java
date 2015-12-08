import exceptions.MatchIsDraw;
import exceptions.NoMatchResultFound;
import model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MatchTest {

    /** When a match is created */
    @Test
    public void itShouldKnowLocalAndAwayTeams(){
        Team local = new Team("Local");
        Team away = new Team("Away");
        Match match = new Match(local, away);

        assertEquals(local, match.localTeam());
        assertEquals(away, match.awayTeam());
    }

    /** When a match has finished and it's not a draw */
    @Test
    public void itShouldHaveAWinner() throws MatchIsDraw, NoMatchResultFound {
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        Team local = new Team("Local");
        Team away = new Team("Away");
        Match match = new Match(local, away);
        MatchResult localTeamWins = new MatchResult(match, emptyListOfScorers, 10, emptyListOfScorers, 0);

        match.setMatchResult(localTeamWins);

        assertTrue(match.theWinnerIs(local));
        assertFalse(match.theWinnerIs(away));
        assertEquals(local, match.winner());
    }

    /** When a match has no result and I'm trying to know the winner */
    @Test(expected = NoMatchResultFound.class)
    public void itShouldFailBecauseThereIsNoResult() throws NoMatchResultFound, MatchIsDraw {
        Match match = new Match(new Team("Local"), new Team("Away"));

        match.winner();
    }

    /** When a match is draw and I'm trying to know the winner */
    @Test(expected = MatchIsDraw.class)
    public void itShouldFailBecauseItIsADrawMatch() throws MatchIsDraw, NoMatchResultFound {
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        Team local = new Team("Local");
        Team away = new Team("Away");
        Match match = new Match(local, away);
        MatchResult drawMatch = new MatchResult(match, emptyListOfScorers, 0, emptyListOfScorers, 0);

        match.setMatchResult(drawMatch);

        match.winner();
    }

    /** When both teams have the same points on the match */
    @Test
    public void itShouldBeADrawMatch(){
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        Team local = new Team("Local");
        Team away = new Team("Away");
        Match match = new Match(local, away);
        MatchResult drawMatch = new MatchResult(match, emptyListOfScorers, 0, emptyListOfScorers, 0);

        match.setMatchResult(drawMatch);

        assertTrue(match.isDrawMatch());
    }

    @Test
    public void itShouldRespondIfATeamIsTheLocalTeam(){
        Team localTeam = new Team("Local");
        Team awayTeam = new Team("Away");
        Match match = new Match(localTeam, awayTeam);

        assertFalse(match.isLocalTeam(awayTeam));
        assertTrue(match.isLocalTeam(localTeam));
    }

    /** When match has no scorers */
    @Test
    public void itShouldReturnAnEmptyListOfScorersForEachTeam() throws NoMatchResultFound {
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        Team local = new Team("Local");
        Team away = new Team("Away");
        Match match = new Match(local, away);
        MatchResult drawMatch = new MatchResult(match, emptyListOfScorers, 0, emptyListOfScorers, 0);

        match.setMatchResult(drawMatch);

        assertEquals(emptyListOfScorers, match.localScorers());
        assertEquals(emptyListOfScorers, match.awayScorers());
    }

    /** When local team has scorers */
    @Test
    public void itShouldReturnAListOfScorers() throws NoMatchResultFound {
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> listOfScorers = new ArrayList<Player>();
        listOfScorers.add(anyPlayer());

        Team local = new Team("Local");
        Team away = new Team("Away");

        Match match = new Match(local, away);
        MatchResult matchResult = new MatchResult(match, listOfScorers, 6, emptyListOfScorers, 0);

        match.setMatchResult(matchResult);

        assertEquals(listOfScorers, match.localScorers());
        assertEquals(emptyListOfScorers, match.awayScorers());
    }

    /** When match has no result */
    @Test(expected = NoMatchResultFound.class)
    public void itShouldFailBecauseMatchHasNoResult() throws NoMatchResultFound {
        Team local = new Team("Local");
        Team away = new Team("Away");
        Match match = new Match(local, away);

        match.localScorers();
    }

    /** When match has no result */
    @Test(expected = NoMatchResultFound.class)
    public void _itShouldFailBecauseMatchHasNoResult() throws NoMatchResultFound {
        Team local = new Team("Local");
        Team away = new Team("Away");
        Match match = new Match(local, away);

        match.awayScorers();
    }

    private Player anyPlayer(){
        return new Player("Pepe", Position.DEFENDER, anyTeam());
    }
    private Team anyTeam(){
        return new Team("A team name");
    }

}
