import exceptions.MatchIsDraw;
import exceptions.NoMatchResultFound;

import java.util.List;

public class Match {

    private Team localTeam;
    private Team awayTeam;
    private Boolean matchResultSet;

    /**
     * Class' Constructor.
     *
     * @param local Local team.
     * @param away  Away team.
     */
    public Match(Team local, Team away) {
        this.localTeam = local;
        this.awayTeam = away;
        this.matchResultSet = false;
    }

    public Team localTeam(){
        return this.localTeam;
    }

    public Team awayTeam(){
        return this.awayTeam;
    }

    public Boolean theWinnerIs(Team team) throws MatchIsDraw, NoMatchResultFound {
        return this.winner().equals(team);
    }

    public Team winner() throws MatchIsDraw, NoMatchResultFound {
        this.verifyMatchWithResultAndNotDrawMatch();
        return this.teamWithMorePoints();
    }

    public List<Player> localScorers(){
        return  this.scorersForTeam(this.localTeam());
    }

    public List<Player> awayScorers(){
        return  this.scorersForTeam(this.awayTeam());
    }

    public void setMatchResult(MatchResult matchResult){
        this.localTeam().saveMatchResult(matchResult);
        this.awayTeam().saveMatchResult(matchResult);
        this.matchResultSet();
    }

    public Boolean isDrawMatch() {
        return this.localTeam().pointsOnMatch(this).equals(this.awayTeam().pointsOnMatch(this));
    }

    public Boolean isLocalTeam(Team team){
        return team.equals(this.localTeam());
    }

    private void verifyMatchWithResultAndNotDrawMatch() throws NoMatchResultFound, MatchIsDraw {
        if (!this.matchResultSet) { throw new NoMatchResultFound(); }
        if (this.isDrawMatch()){ throw new MatchIsDraw("That match is draw then nobody wins"); }
    }

    private void matchResultSet(){
        this.matchResultSet = true;
    }

    private Team teamWithMorePoints(){
        if(this.localTeam().pointsOnMatch(this) > this.awayTeam().pointsOnMatch(this))
            return this.localTeam();
        else
            return this.awayTeam();
    }

    private List<Player> scorersForTeam(Team team){
        return team.scorersOnMatch(this);
    }
}
