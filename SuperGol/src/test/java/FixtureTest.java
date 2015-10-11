import exceptions.FullTourney;

import static org.junit.Assert.*;

import model.Fixture;
import model.Team;
import model.Tourney;
import org.junit.Test;

public class FixtureTest {

    private Fixture fixture;

    @Test
    public void sixRoundsShouldBeBuiltForATourneyWithFourTeams() throws FullTourney {
        this.fixture = new Fixture(anyTourneyWith(4));
        assertEquals(6, this.fixture.rounds().size());
    }

    @Test
    public void tenRoundsShouldBeBuiltForATourneyWithFiveTeams() throws FullTourney {
        this.fixture = new Fixture(anyTourneyWith(5));
        assertEquals(10, this.fixture.rounds().size());
    }

    /**
     * Returns any tourney with X amount of Teams.
     *
     * @param amountOfTeams Amount of Teams.
     * @return A model.Tourney with a X amount of Teams already created.
     * @throws FullTourney
     */
    private Tourney anyTourneyWith(Integer amountOfTeams) throws FullTourney {
        Tourney tourney = new Tourney("A tourney name", 1, amountOfTeams);
        for (int i = 1; i <= amountOfTeams; i++) {
            tourney.addTeam(new Team(String.valueOf(i)));
        }
        return tourney;
    }

}
