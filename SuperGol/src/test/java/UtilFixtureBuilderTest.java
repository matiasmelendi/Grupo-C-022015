import exceptions.FullTourney;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilFixtureBuilderTest {

    @Test
    public void forTwoTeams_shouldReturnTwoRounds() throws FullTourney {
        Integer actualAmountOfRounds = amountOfRoundsForAmountOfTeams(2);
        assertEquals(Integer.valueOf(2), actualAmountOfRounds);
    }

    @Test
    public void forThreeTeams_shouldReturnSixRounds() throws FullTourney {
        Integer actualAmountOfRounds = amountOfRoundsForAmountOfTeams(3);
        assertEquals(Integer.valueOf(6), actualAmountOfRounds);
    }

    @Test
    public void forFourTeams_shouldReturnSixRounds() throws FullTourney {
        Integer actualAmountOfRounds = amountOfRoundsForAmountOfTeams(4);
        assertEquals(Integer.valueOf(6), actualAmountOfRounds);
    }

    @Test
    public void forFiveTeams_shouldReturnTenRounds() throws FullTourney {
        Integer actualAmountOfRounds = amountOfRoundsForAmountOfTeams(5);
        assertEquals(Integer.valueOf(10), actualAmountOfRounds);
    }

    @Test
    public void aTourneyNeedsADummyTeam() throws FullTourney {
        Tourney tourneyToCheck = anyTourneyWith(3);
        UtilFixtureBuilder.addDummyIfNeeded(tourneyToCheck);
        assertEquals(Integer.valueOf(4), tourneyToCheck.amountOfTeams());
    }

    @Test
    public void aTourneyDoesntNeedADummyTeam() throws FullTourney {
        Tourney tourneyToCheck = anyTourneyWith(4);
        UtilFixtureBuilder.addDummyIfNeeded(tourneyToCheck);
        assertEquals(Integer.valueOf(4), tourneyToCheck.amountOfTeams());
    }

    @Test
    public void removeDummyTeamIfNeeded() throws FullTourney {
        Tourney tourneyToCheck = anyTourneyWith(3);
        UtilFixtureBuilder.addDummyIfNeeded(tourneyToCheck);
        assertEquals(Integer.valueOf(4), tourneyToCheck.amountOfTeams());
        UtilFixtureBuilder.removeDummyIfNeeded(tourneyToCheck);
        assertEquals(Integer.valueOf(3), tourneyToCheck.amountOfTeams());
    }

    @Test
    public void dontRemoveDummyTeamIfNotNeeded() throws FullTourney {
        Tourney tourneyToCheck = anyTourneyWith(4);
        UtilFixtureBuilder.removeDummyIfNeeded(tourneyToCheck);
        assertEquals(Integer.valueOf(4), tourneyToCheck.amountOfTeams());
    }

    // Helper Methods.

    /**
     * Returns the amount of Rounds for a X amount of teams.
     *
     * @param amountOfTeams Amount of Teams.
     * @return The amount of Rounds for a X amount of teams.
     * @throws FullTourney
     */
    private Integer amountOfRoundsForAmountOfTeams(Integer amountOfTeams) throws FullTourney {
        return UtilFixtureBuilder.calculateAmountOfRounds(anyTourneyWith(amountOfTeams));
    }

    /**
     * Returns any tourney with X amount of Teams.
     *
     * @param amountOfTeams Amount of Teams.
     * @return A Tourney with X amount of Teams.
     * @throws FullTourney
     */
    private Tourney anyTourneyWith(Integer amountOfTeams) throws FullTourney {
        // Plus one, to contemplate cases with Dummy Teams.
        Tourney tourney = new Tourney("A tourney name", 1, amountOfTeams + 1);
        for (int i = 1; i <= amountOfTeams; i++) {
            tourney.addTeam(new Team(String.valueOf(i)));
        }
        return tourney;
    }

}
