import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldHaveAUsernamePasswordAndZeroScore(){
        assertEquals("Pepe123", pepe().username());
        assertTrue(pepe().hasPassword());
        assertEquals(pepe().score(), Integer.valueOf(0));
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
        pepe.updateScore(15);

        assertEquals(pepe.score(), Integer.valueOf(15));
    }

    private Team anyTeam(){
        return new Team("A team name");
    }

    private User pepe(){
        return new User("Pepe123", "123ASDQWE", null);
    }
}
