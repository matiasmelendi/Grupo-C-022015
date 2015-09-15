import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ScoringRulesTest {

    /** When NoGoals rule */
    @Test
    public void whenNoGoalsRuleIsAppliedTheTeamGetTwoPoints(){
        ScoringRule rule = new NoGoals();

        assertEquals(Integer.valueOf(2), rule.points());
    }

    public void shouldApplyWhenTeamReceivedNoGoals(){
        ScoringRule rule = new NoGoals();

        List<Player> emptyListOfScorers = new ArrayList<Player>();
        List<Player> localScorers = emptyListOfScorers;
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
        List<Player> localScorers = emptyListOfScorers;
        localScorers.add(anyPlayer());

        Team local = new Team("Local");
        Team away = new Team("Away");
        Match match = new Match(local, away);
        MatchResult drawMatch = new MatchResult(match, localScorers, 1, emptyListOfScorers, 0);

        match.setMatchResult(drawMatch);

        assertFalse(rule.appliesTo(away, match));
    }

    /** When WinnerOfTheMatch rule */
    @Test
    public void whenWinnerOfTheMatchRuleIsAppliedTheTeamGetThreePoints(){
        ScoringRule rule = new WinnerOfTheMatch();

        assertEquals(Integer.valueOf(3), rule.points());
    }

    /** When MidfielderForwardScored rule */
    @Test
    public void whenMidfielderForwardScoredRuleIsAppliedTheTeamGetThreePoints(){
        ScoringRule rule = new MidfielderForwardScored();

        assertEquals(Integer.valueOf(1), rule.points());
    }

    /** When DrawMatch rule */
    @Test
    public void whenDrawMatchRuleIsAppliedTheTeamGetThreePoints(){
        ScoringRule rule = new DrawMatch();

        assertEquals(Integer.valueOf(1), rule.points());
    }

    /** When DefenderScored rule */
    @Test
    public void whenDefenderScoredRuleIsAppliedTheTeamGetThreePoints(){
        ScoringRule rule = new DefenderScored();

        assertEquals(Integer.valueOf(3), rule.points());
    }

    private Team anyTeam(){
        return new Team("A team name");
    }

    private Player anyPlayer(){
        return new Player("Pepe", Position.DEFENDER, anyTeam());
    }

}
