import exceptions.MatchIsDraw;
import exceptions.NoMatchResultFound;
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
}