import exceptions.PlayerNotFound;
import exceptions.PositionFull;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FormationTest {

    @Test
    public void shouldBeCreatedWithoutPlayers(){
        ArrayList<Player>  emptyListOfPlayer = new ArrayList<Player>();

        assertEquals(aFormation().players(), emptyListOfPlayer);
    }


    /**    When adding new players    */
    @Test
    public void shouldIncrementTheNumberOfPlayers() throws PositionFull {
        Formation formation = aFormation();

        formation.addPlayer(anyPlayer());

        assertEquals(formation.players().size(), 1);
    }

    @Test(expected = PositionFull.class)
    public void shouldNotAddPlayersOnAFullPosition() throws PositionFull {
        Formation formation = aFormation();

        formation.addPlayer(forwarder());
        formation.addPlayer(forwarder());
        formation.addPlayer(forwarder());

        /* Only three forwarders are allowed on a 3-4-3 formation */
        formation.addPlayer(forwarder());
    }

    /**    When formation has more than one player with different positions    */
    @Test
    public void shouldReturnTheDefendersOnly(){
        Player defender = anyPlayer();
        Player goalkeeper = goalkeeper();
        Formation formation = aFormation();

        addPlayerToFormation(formation, defender);
        addPlayerToFormation(formation, goalkeeper);

        assertTrue(formation.defenders().contains(defender));
        assertFalse(formation.defenders().contains(goalkeeper));
    }

    /**  When formation has no defenders    */
    @Test
    public void shouldReturnAnEmptyListOfDefenders(){
        assertTrue(aFormation().defenders().isEmpty());
    }


    /**  When formation has a goalkeeper   */
    @Test
    public void shouldReturnTheGoalkeeperOnly() throws PlayerNotFound {
        Player goalkeeper = goalkeeper();
        Formation formation = aFormation();

        addPlayerToFormation(formation, goalkeeper);

        assertEquals(formation.goalkeeper(), goalkeeper);
    }

    /**  When formation has no goalkeeper */
    @Test(expected = PlayerNotFound.class)
    public void shouldCommunicateThatPlayerIsNotFound() throws PlayerNotFound {
        aFormation().goalkeeper();
    }

    /** When formation has midfielders */
    @Test
    public void shouldReturnTheMidfieldersOnly(){
        Player midfielder = midfielder();
        Player goalkeeper = goalkeeper();
        Formation formation = aFormation();

        addPlayerToFormation(formation, midfielder);
        addPlayerToFormation(formation, goalkeeper);

        assertTrue(formation.midfielders().contains(midfielder));
        assertFalse(formation.midfielders().contains(goalkeeper));
    }

    /** When formation has no midfielders */
    @Test
    public void shouldReturnAnEmptyListOfMidfielders(){
        assertTrue(aFormation().midfielders().isEmpty());
    }

    /** When formation has forwarders */
    @Test
    public void shouldReturnTheForwardersOnly(){
        Player forwarder = forwarder();
        Player goalkeeper = goalkeeper();
        Formation formation = aFormation();

        addPlayerToFormation(formation, forwarder);
        addPlayerToFormation(formation, goalkeeper);

        assertTrue(formation.forwarders().contains(forwarder));
        assertFalse(formation.forwarders().contains(goalkeeper));
    }

    /** When formation has no forwarders */
    @Test
    public void shouldReturnAnEmptyListOfForwarders(){
        assertTrue(aFormation().forwarders().isEmpty());
    }

    /******************************/
    /** Having a 3-4-3 formation  */
    /******************************/

    /** When formation is empty */
    @Test
    public void couldAddMorePlayers(){
        assertTrue(aFormation().canAddPlayer(anyPlayer()));
    }

    @Test
    public void couldAddMoreDefendersWhenThisPositionIsNotFull(){
        Player defender = anyPlayer();
        Formation formation = aFormation();

        addPlayerToFormation(formation, defender);
        addPlayerToFormation(formation, defender);

        assertTrue(formation.canAddPlayer(defender));
    }

    @Test
    public void couldNotAddMoreDefendersWhenThisPositionIsFull(){
        Player defender = anyPlayer();
        Formation formation = aFormation();

        addPlayerToFormation(formation, defender);
        addPlayerToFormation(formation, defender);
        addPlayerToFormation(formation, defender);

        assertFalse(formation.canAddPlayer(defender));
    }

    @Test
    public void couldAddMoreMidfieldersWhenThisPositionIsNotFull(){
        Player midfielder = midfielder();
        Formation formation = aFormation();

        addPlayerToFormation(formation, midfielder);

        assertTrue(formation.canAddPlayer(midfielder));
    }

    @Test
    public void couldNotAddMoreMidfieldersWhenThisPositionIsFull(){
        Player midfielder = midfielder();
        Formation formation = aFormation();

        addPlayerToFormation(formation, midfielder);
        addPlayerToFormation(formation, midfielder);
        addPlayerToFormation(formation, midfielder);
        addPlayerToFormation(formation, midfielder);

        assertFalse(formation.canAddPlayer(midfielder));
    }

    @Test
    public void couldAddMoreForwardersWhenThisPositionIsNotFull(){
        Player forwarder = forwarder();
        Formation formation = aFormation();

        addPlayerToFormation(formation, forwarder);
        addPlayerToFormation(formation, forwarder);

        assertTrue(formation.canAddPlayer(forwarder));
    }

    @Test
    public void couldNotAddMoreForwardersWhenThisPositionIsFull(){
        Player forwarder = forwarder();
        Formation formation = aFormation();

        addPlayerToFormation(formation, forwarder);
        addPlayerToFormation(formation, forwarder);
        addPlayerToFormation(formation, forwarder);

        assertFalse(formation.canAddPlayer(forwarder));
    }

    /*
    * Helper methods
    * */
    private Formation addPlayerToFormation(Formation formation, Player player){
        try{
            formation.addPlayer(player);
        }catch (PositionFull e){
            fail("Position is Full you can't add another player");
        }

        return formation;
    }

    private Player forwarder(){
        Player forwarder = anyPlayer();
        forwarder.changePosition(Position.FORWARD);

        return forwarder;
    }

    private Player midfielder(){
        Player midfielder = anyPlayer();
        midfielder.changePosition(Position.MIDFIELDER);

        return midfielder;
    }

    private Player goalkeeper(){
        Player goalkeeper = anyPlayer();
        goalkeeper.changePosition(Position.GOALKEEPER);

        return goalkeeper;
    }

    private Team anyTeam(){
        return new Team();
    }

    private Player anyPlayer(){
        return new Player("Pepe", Position.DEFENDER, anyTeam());
    }

    private Formation aFormation(){
        return new Formation(3,4,3);
    }
}

