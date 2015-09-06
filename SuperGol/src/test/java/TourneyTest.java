import com.sun.xml.internal.bind.v2.TODO;
import exceptions.FullTourney;
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

    //TODO: Replace this test when fixture class is created
    @Test
    public void aFixtureCouldBeCreatedForATourney(){
        assertNotNull(anyTourney().fixture());
    }

    /*
    * Helper methods
    * */
    private Tourney addTeamToTourney(Team team, Tourney tourney){
        try{
            tourney.addTeam(team);
        }catch (FullTourney e){
            fail("Tourney is Full you can't add another team");
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
