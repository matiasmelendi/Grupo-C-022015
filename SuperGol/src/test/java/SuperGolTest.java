import exceptions.FullTourney;
import exceptions.PositionFull;
import model.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SuperGolTest {

    /** When the application has no users */
    @Test
    public void shouldReturnAnEmptyListOfUsers(){
        assertTrue(superGol().users().isEmpty());
    }

    /** When the application has one user */
    @Test
    public void shouldReturnAListIncludingOnlyOneUser(){
        SuperGol superGol = superGol();
        User aUser = anyUser();
        superGol.addUser(aUser);

        assertFalse(superGol.users().isEmpty());
        assertTrue(superGol.users().contains(aUser));
        assertEquals(superGol.users().size(), 1);
    }

    @Test
    public void shouldReturnARankingForATourney(){
        SuperGol superGol = superGol();

        Team teamOne = new Team("TeamOne");
        Team teamTwo = new Team("TeamTwo");
        Team teamThree = new Team("TeamThree");

        User userOne = anyUserWithTeam(teamOne);
        User userTwo = anyUserWithTeam(teamTwo);
        User userThree = anyUserWithTeam(teamThree);

        teamOne.beAssignedTo(userOne);
        teamTwo.beAssignedTo(userTwo);
        teamThree.beAssignedTo(userThree);

        Tourney aTourney = new Tourney("La copa del Rey", 2, 10);
        List<Team> expectedRanking = Arrays.asList(teamTwo, teamThree, teamOne);

        addTeamToTourney(teamTwo, aTourney);
        addTeamToTourney(teamOne, aTourney);
        addTeamToTourney(teamThree, aTourney);

        userOne.updateScoreFor(aTourney, 5);
        userThree.updateScoreFor(aTourney, 25);
        userTwo.updateScoreFor(aTourney, 100);

        superGol.addUser(userTwo);
        superGol.addUser(userOne);
        superGol.addUser(userThree);

        assertEquals(expectedRanking, superGol.rankingFor(aTourney));
    }

    @Test
    public void couldUpdateUsersScore(){
        SuperGol superGol = superGol();
        Tourney aTourney = new Tourney("La copa del Rey", 2, 10);
        Team teamOne = new Team("TeamOne");
        Team teamTwo = new Team("TeamTwo");
        User userOne = anyUserWithTeam(teamOne);
        User userTwo = anyUserWithTeam(teamTwo);

        addTeamToTourney(teamTwo, aTourney);
        addTeamToTourney(teamOne, aTourney);

        userOne.updateScoreFor(aTourney, 0);
        userTwo.updateScoreFor(aTourney, 0);

        superGol.addUser(userTwo);
        superGol.addUser(userOne);

        Map<Team, Integer> newScores = new HashMap<Team, Integer>();
        newScores.put(teamOne, 150);
        newScores.put(teamTwo, 100);

        superGol.updateScoresFor(aTourney, newScores);

        assertEquals(userOne.scoreFor(aTourney), Integer.valueOf(150));
        assertEquals(userTwo.scoreFor(aTourney), Integer.valueOf(100));
    }

    //    @Test
    public void couldCalculateScoresForTourneyInARound() {
        SuperGol superGol = superGol();

        Tourney aTourney = new Tourney("La copa del Rey", 2, 10);

        Team teamOne = new Team("TeamOne");
        Team teamTwo = new Team("TeamTwo");
        User userOne = new User("Memo 1", "123123123", teamOne);
        User userTwo = new User("Memo 2", "123123123", teamTwo);

        addTeamToTourney(teamTwo, aTourney);
        addTeamToTourney(teamOne, aTourney);

        userOne.updateScoreFor(aTourney, 0);
        userTwo.updateScoreFor(aTourney, 0);

        superGol.addUser(userTwo);
        superGol.addUser(userOne);

        Player defender = new Player("Pepe", Position.DEFENDER, teamOne);
        addPlayerToTeam(teamOne, defender);

        Round round = new Round(0, Arrays.asList(teamOne, teamTwo), 2);
        Match match = round.matches().get(0);

        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> listOfScorers = new ArrayList<Player>();
        listOfScorers.add(defender);

        MatchResult localTeamWins = new MatchResult(match, listOfScorers, 8, emptyListOfScorers, 0);
        match.setMatchResult(localTeamWins);

        superGol.calculateScoresForTourneyInARound(aTourney, round);

        assertEquals(Integer.valueOf(5), userTwo.scoreFor(aTourney));
        assertEquals(Integer.valueOf(0), userOne.scoreFor(aTourney));
    }

    private void addTeamToTourney(Team team, Tourney tourney){
        try{
            tourney.addTeam(team);
        }catch (FullTourney e){
            fail("model.Tourney is Full you can't add another team");
        }
    }

    private SuperGol superGol(){
        return new SuperGol();
    }

    private User anyUser(){
        return new User("Memo", "123123123", null);
    }

    private User anyUserWithTeam(Team aTeam){
        return new User("Memo", "123123123", aTeam);
    }

    private Team addPlayerToTeam(Team team, Player player) {
        try {
            team.addPlayer(player);
        } catch (PositionFull e) {
            fail("model.Position is Full you can't add another player");
        }

        return team;
    }
}
