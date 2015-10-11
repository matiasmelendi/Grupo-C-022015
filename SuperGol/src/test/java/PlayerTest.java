import model.Player;
import model.Position;
import model.Team;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void aPlayerPositionShouldChangeWhenANewOneIsAssigned() {
        Player player = anyPlayerWithPosition(Position.DEFENDER);
        Position newPosition = Position.FORWARD;
        player.changePosition(newPosition);

        assertEquals(player.position(), newPosition);
    }

    /** When a player is equals to another player */
    @Test
    public void itShouldBeTrue(){
        Player playerOne = anyPlayer();
        Player playerTwo = anyPlayer();

        assertTrue(playerOne.equals(playerTwo));
    }

    /** When comparing different players */
    @Test
    public void itShouldNotBeEquals(){
        Player playerOne = anyPlayer();
        Player playerTwo = anyPlayerWithPosition(Position.FORWARD);

        assertFalse(playerOne.equals(playerTwo));
    }

    /** When a captain is unassigned */
    @Test
    public void itShouldBeANormalPlayer(){
        Player exCaptain = captain();

        exCaptain.unassignCaptain();

        assertFalse(exCaptain.isCaptain());
    }

    private Player captain(){
        Player captain = anyPlayer();
        captain.becomeCaptain();

        return captain;
    }

    private Player anyPlayer(){
        return this.anyPlayerWithPosition(Position.DEFENDER);
    }

    private Player anyPlayerWithPosition(Position position) {
        return new Player("model.Player Name", position, anyTeam());
    }

    private Team anyTeam() {
        return new Team("A team name");
    }

}