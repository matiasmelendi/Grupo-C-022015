import exceptions.PositionFull;
import model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ScoringRulesTest {

    /** When model.NoGoals rule */
    @Test
    public void whenNoGoalsRuleIsAppliedTheTeamGetTwoPoints(){
        ScoringRule rule = new NoGoals();

        assertEquals(Integer.valueOf(2), rule.points());
    }

    @Test
    public void shouldApplyWhenTeamReceivedNoGoals(){
        ScoringRule rule = new NoGoals();

        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> localScorers = new ArrayList<Player>();
        localScorers.add(anyPlayer());

        Team local = new Team("Local");
        Team away = new Team("Away");
        Match match = new Match(local, away);

        MatchResult result = new MatchResult(match, localScorers, 1, emptyListOfScorers, 0);

        match.setMatchResult(result);

        assertTrue(rule.appliesTo(local, match));
    }

    @Test
    public void shouldNotApplyWhenTeamReceivedGoals(){
        ScoringRule rule = new NoGoals();

        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> localScorers = new ArrayList<Player>();
        localScorers.add(anyPlayer());

        Team local = new Team("Local");
        Team away = new Team("Away");
        Match match = new Match(local, away);
        MatchResult localWins = new MatchResult(match, localScorers, 1, emptyListOfScorers, 0);

        match.setMatchResult(localWins);

        assertFalse(rule.appliesTo(away, match));
    }

    @Test
    public void _shouldNotApplyWhenMatchHasNoResult(){
        ScoringRule rule = new NoGoals();
        Team looserOne = new Team("Looser 1");
        Team looserTwo = new Team("Looser 2");
        Match match = new Match(looserOne, looserTwo);

        assertFalse(rule.appliesTo(looserOne, match));
        assertFalse(rule.appliesTo(looserTwo, match));
    }

    /** When model.WinnerOfTheMatch rule */
    @Test
    public void whenWinnerOfTheMatchRuleIsAppliedTheTeamGetThreePoints(){
        ScoringRule rule = new WinnerOfTheMatch();

        assertEquals(Integer.valueOf(3), rule.points());
    }

    @Test
    public void shouldApplyToATeamWhenItIsTheWinnerOfTheMatch(){
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> localScorers = new ArrayList<Player>();
        localScorers.add(anyPlayer());

        ScoringRule rule = new WinnerOfTheMatch();
        Team winnerTeam = new Team("Winner");
        Team looserTeam = new Team("Looser");
        Match match = new Match(winnerTeam, looserTeam);

        MatchResult localWins = new MatchResult(match, localScorers, 1, emptyListOfScorers, 0);
        match.setMatchResult(localWins);

        assertTrue(rule.appliesTo(winnerTeam, match));
    }

    @Test
    public void shouldNotApplyWhenMatchIsDraw(){
        List<Player> emptyListOfScorers = new ArrayList<Player>();

        ScoringRule rule = new WinnerOfTheMatch();
        Team looserOne = new Team("Looser 1");
        Team looserTwo = new Team("Looser 2");
        Match match = new Match(looserOne, looserTwo);

        MatchResult drawMatch = new MatchResult(match, emptyListOfScorers, 0, emptyListOfScorers, 0);
        match.setMatchResult(drawMatch);

        assertFalse(rule.appliesTo(looserOne, match));
        assertFalse(rule.appliesTo(looserTwo, match));
    }

    @Test
    public void shouldNotApplyWhenMatchHasNoResult(){
        ScoringRule rule = new WinnerOfTheMatch();
        Team looserOne = new Team("Looser 1");
        Team looserTwo = new Team("Looser 2");
        Match match = new Match(looserOne, looserTwo);

        assertFalse(rule.appliesTo(looserOne, match));
        assertFalse(rule.appliesTo(looserTwo, match));
    }

    /** When model.MidfielderForwardScored rule */
    @Test
    public void whenMidfielderForwardScoredRuleIsAppliedTheTeamGetThreePoints(){
        ScoringRule rule = new MidfielderForwardScored();

        assertEquals(Integer.valueOf(1), rule.points());
    }

    @Test
    public void shouldApplyWhenTeamHasAMidfielderScorer(){
        ScoringRule rule = new MidfielderForwardScored();
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> listOfScorers = new ArrayList<Player>();
        Team teamWithMidfielderScorers = new Team("With Midfielder Scorers");
        Player midfielderScorer = new Player("Pepe", Position.MIDFIELDER);
        midfielderScorer.addTeam(teamWithMidfielderScorers);
        addPlayerToTeam(teamWithMidfielderScorers, midfielderScorer);

        listOfScorers.add(midfielderScorer);
        Match match = new Match(teamWithMidfielderScorers, anyTeam());

        MatchResult matchResult = new MatchResult(match, listOfScorers, 6, emptyListOfScorers, 0);
        match.setMatchResult(matchResult);

        assertTrue(rule.appliesTo(teamWithMidfielderScorers, match));
    }

    @Test
    public void shouldApplyWhenTeamHasAForwardScorer(){
        ScoringRule rule = new MidfielderForwardScored();
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> listOfScorers = new ArrayList<Player>();
        Team teamWithForwardScorers = new Team("With Forward Scorers");
        Player forwardScorer = new Player("Pepe", Position.FORWARD);
        forwardScorer.addTeam(teamWithForwardScorers);
        addPlayerToTeam(teamWithForwardScorers, forwardScorer);

        listOfScorers.add(forwardScorer);
        Match match = new Match(teamWithForwardScorers, anyTeam());

        MatchResult matchResult = new MatchResult(match, listOfScorers, 6, emptyListOfScorers, 0);
        match.setMatchResult(matchResult);

        assertTrue(rule.appliesTo(teamWithForwardScorers, match));
    }

    @Test
    public void shouldNotApplyWhenTeamHasNoMidfielderOrForwardScorers(){
        ScoringRule rule = new MidfielderForwardScored();
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> listOfScorers = new ArrayList<Player>();
        Team teamWithDefenderScorers = new Team("With Defender Scorers");
        Player defenderScorer = new Player("Pepe", Position.DEFENDER);
        defenderScorer.addTeam(teamWithDefenderScorers);
        addPlayerToTeam(teamWithDefenderScorers, defenderScorer);

        listOfScorers.add(defenderScorer);
        Match match = new Match(teamWithDefenderScorers, anyTeam());

        MatchResult matchResult = new MatchResult(match, listOfScorers, 6, emptyListOfScorers, 0);
        match.setMatchResult(matchResult);

        assertFalse(rule.appliesTo(teamWithDefenderScorers, match));
    }

    /** When model.DrawMatch rule */
    @Test
    public void whenDrawMatchRuleIsAppliedTheTeamGetThreePoints(){
        ScoringRule rule = new DrawMatch();

        assertEquals(Integer.valueOf(1), rule.points());
    }

    @Test
    public void shouldApplyWhenMatchIsDraw(){
        ScoringRule rule = new DrawMatch();

        assertTrue(rule.appliesTo(anyTeam(), drawMatch()));
    }

    @Test
    public void shouldNotApplyWhenMatchHasAWinner(){
        ScoringRule rule = new DrawMatch();

        assertFalse(rule.appliesTo(anyTeam(), matchWithWinner()));
    }

    /** When model.DefenderScored rule */
    @Test
    public void whenDefenderScoredRuleIsAppliedTheTeamGetThreePoints(){
        ScoringRule rule = new DefenderScored();

        assertEquals(Integer.valueOf(3), rule.points());
    }

    @Test
    public void shouldApplyWhenAtLeastOneDefenderScored(){
        ScoringRule rule = new DefenderScored();
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> listOfScorers = new ArrayList<Player>();
        Team teamWithDefenderScorers = new Team("With Defender Scorers");
        Player defenderScorer = new Player("Pepe", Position.DEFENDER);
        defenderScorer.addTeam(teamWithDefenderScorers);
        addPlayerToTeam(teamWithDefenderScorers, defenderScorer);

        listOfScorers.add(defenderScorer);
        Match match = new Match(teamWithDefenderScorers, anyTeam());

        MatchResult matchResult = new MatchResult(match, listOfScorers, 6, emptyListOfScorers, 0);
        match.setMatchResult(matchResult);

        assertTrue(rule.appliesTo(teamWithDefenderScorers, match));
    }

    @Test
    public void shouldNotApplyWhenMatchHasNoDefendersAsScorers(){
        ScoringRule rule = new DefenderScored();
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> listOfScorers = new ArrayList<Player>();
        Team teamWithGoalkeeperScorers = new Team("With Goalkeeper Scorer");
        Player goalkeeperScorer = new Player("Pepe", Position.GOALKEEPER);
        goalkeeperScorer.addTeam(teamWithGoalkeeperScorers);
        addPlayerToTeam(teamWithGoalkeeperScorers, goalkeeperScorer);

        listOfScorers.add(goalkeeperScorer);
        Match match = new Match(teamWithGoalkeeperScorers, anyTeam());

        MatchResult matchResult = new MatchResult(match, listOfScorers, 3, emptyListOfScorers, 0);
        match.setMatchResult(matchResult);

        assertFalse(rule.appliesTo(teamWithGoalkeeperScorers, match));
    }

    private Team anyTeam(){
        return new Team("A team name");
    }

    private Player anyPlayer(){
        Player player = new Player("Pepe", Position.DEFENDER);
        player.addTeam(anyTeam());

        return player;
    }

    private Match drawMatch() {
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        Team local = new Team("Local");
        Team away = new Team("Away");
        Match match = new Match(local, away);
        MatchResult drawMatch = new MatchResult(match, emptyListOfScorers, 0, emptyListOfScorers, 0);

        match.setMatchResult(drawMatch);

        return match;
    }

    private Match matchWithWinner() {
        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> listOfScorers = new ArrayList<Player>();
        listOfScorers.add(anyPlayer());

        Team local = new Team("Local");
        Team away = new Team("Away");

        Match match = new Match(local, away);
        MatchResult matchResult = new MatchResult(match, listOfScorers, 6, emptyListOfScorers, 0);

        match.setMatchResult(matchResult);

        return match;
    }

    private Team addPlayerToTeam(Team team, Player player){
        try{
            team.addPlayer(player);
        }catch (PositionFull e){
            fail("model.Position is Full you can't add another player");
        }

        return team;
    }

}
