import exceptions.FullTourney;
import model.Team;
import model.Tourney;
import model.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldHaveAUsernameAndPassword(){
        assertEquals("Pepe123", pepe().username());
        assertTrue(pepe().hasPassword());
    }

    @Test
    public void shouldHaveATeamSelected(){
        Team anyTeam = anyTeam();
        User pepe = new User("Pepe123", "123ASDQWE", anyTeam);
        assertEquals(anyTeam, pepe.team());
    }

    @Test
    public void shouldBePossibleToUpdateTheScore(){
        User pepe = pepe();
        Tourney aTourney = new Tourney("La copa del Rey", 1, 3);
        addTeamToTourney(pepe().team(), aTourney);

        pepe.updateScoreFor(aTourney, 15);

        assertEquals(pepe.scoreFor(aTourney), Integer.valueOf(15));
    }

    @Test
    public void twoUsersShouldBeEqualsWhenUsernameAreTheSame(){
        User userOne = new User("USER","", null);
        User userTwo = new User("USER","123", null);

        assertEquals(userOne, userTwo);
    }

    @Test
    public void twoUsersShouldBeDifferentWhenUsernameAreNotTheSame(){
        User userOne = new User("USER1","", null);
        User userTwo = new User("USER2","", null);

        assertNotEquals(userOne, userTwo);
    }

    private void addTeamToTourney(Team team, Tourney tourney){
        try{
            tourney.addTeam(team);
        }catch (FullTourney e){
            fail("model.Tourney is Full you can't add another team");
        }
    }

    private Team anyTeam(){
        return new Team("A team name");
    }

    private User pepe(){
        return new User("Pepe123", "123ASDQWE", anyTeam());
    }
}
