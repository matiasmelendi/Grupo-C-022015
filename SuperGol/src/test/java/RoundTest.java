import model.Round;
import model.Team;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RoundTest {

    private Round round;

    @Test
    public void threeTeamsShouldCreateOneMatchInARound() {
        round = anyRoundWithTeams(3);
        assertEquals(1, round.matches().size());
    }

    @Test
    public void fourTeamsShouldCreateTwoMatchesInARound() {
        round = anyRoundWithTeams(4);
        assertEquals(2, round.matches().size());
    }

    /**
     * Returns a List with an amount of teams created.
     *
     * @param teamsWanted Amount of teams wanted.
     * @return A List with an amount of teams created.
     */
    private List<Team> teams(Integer teamsWanted) {
        List<Team> teams = new ArrayList<Team>();
        for (int i = 1; i <= teamsWanted; i++) {
            teams.add(new Team(Integer.toString(i)));
        }
        return teams;
    }

    /**
     * Returns a round with the Teams already known by it.
     *
     * @param teamsWanted Teams wanted for the round.
     * @return A round with the teams already known by it.
     */
    private Round anyRoundWithTeams(Integer teamsWanted) {
        return new Round(1, teams(teamsWanted), 6);
    }

}
