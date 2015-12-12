import exceptions.FullTourney;
import model.Team;
import model.Tourney;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TourneyTest {

    @Test
    public void aTourneyShouldHaveAName(){
        assertEquals(anyTourney().name(), "A tourney name");
    }

    @Test
    public void aTourneyShouldHaveAMinNumberOfTeamsAllowed(){
        assertTrue(anyTourney().minimumNumberOfTeams().equals(1));
    }

    @Test
    public void aTourneyShouldHaveAMaxNumberOfTeamsAllowed(){
        assertTrue(anyTourney().maximumNumberOfTeams().equals(2));
    }


    /** When tourney isn't full */
    @Test
    public void aTeamCouldBeAddedToTheTourney() throws FullTourney {
        Tourney aTourney = anyTourney();
        aTourney.addTeam(anyTeam());

        assertEquals(aTourney.teams().size(), 1);
    }

    /** When tourney is full */
    @Test(expected = FullTourney.class)
    public void aTeamCouldNotBeAddedToTheTourney() throws FullTourney {
        Tourney aTourney = new Tourney("Selfish tournament", 1, 1);
        aTourney.addTeam(anyTeam());

        /* The max number of teams allowed is 1, then when trying to add a new one it should fail */
        aTourney.addTeam(anyTeam());
    }

    @Test
    public void aTourneyShouldHaveTeams(){
        Tourney aTourneyWithTeams = anyTourney();
        addTeamToTourney(anyTeam(), aTourneyWithTeams);

        assertEquals(aTourneyWithTeams.teams(), expectedTeams());
    }

    @Test
    public void aFixtureCouldBeCreatedForATourney(){
        assertNotNull(anyTourney().fixture());
    }

    /** When request rounds of an empty tourney */
    @Test
    public void shouldHaveZeroRounds(){
        Tourney emptyTourney = anyTourney();

        assertTrue(emptyTourney.rounds().isEmpty());
    }

    /** When request rounds of a tourney with two teams */
    @Test
    public void shouldHaveTwoRoundsTheFirstOneForVisitorAndTheOtherForLocal(){
        Tourney aTourneyWithTeams = anyTourney();
        addTeamToTourney(anyTeam(), aTourneyWithTeams);
        addTeamToTourney(anyTeam(), aTourneyWithTeams);

        assertFalse(aTourneyWithTeams.rounds().isEmpty());
        assertEquals(2, aTourneyWithTeams.rounds().size());
    }

    @Test
    public void twoTourniesWithTheSameNameAreEquals(){
        Tourney aTourney = new Tourney("Tourney", 2, 4);
        Tourney anotherTourney = new Tourney("Tourney", 0, 3);

        assertEquals(aTourney, anotherTourney);
    }

    @Test
    public void twoTourniesWithDifferentNamesAreNotEquals(){
        Tourney aTourney = new Tourney("Tourney", 2, 4);
        Tourney anotherTourney = new Tourney("Another Tourney", 2, 4);

        assertNotEquals(aTourney, anotherTourney);
    }

    /*
    * Helper methods
    * */
    private Tourney addTeamToTourney(Team team, Tourney tourney){
        try{
            tourney.addTeam(team);
        }catch (FullTourney e){
            fail("model.Tourney is Full you can't add another team");
        }

        return tourney;
    }

    private List<Team> expectedTeams(){
        List teams = new ArrayList<Team>();
        teams.add(anyTeam());

        return teams;
    }

    private Team anyTeam(){
        return new Team("A team name");
    }

    private Tourney anyTourney(){
        return new Tourney("A tourney name", 1, 2);
    }
}
