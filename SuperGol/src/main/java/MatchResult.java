import java.util.List;

public class MatchResult {

    private List<Player> localScorers;
    private List<Player> awayScorers;
    private Integer localPoints;
    private Integer awayPoints;
    private Match match;

    public MatchResult(Match match, List<Player> localScorers, Integer localPoints, List<Player> awayScorers, Integer awayPoints){
        this.match = match;
        this.localScorers = localScorers;
        this.awayScorers = awayScorers;
        this.localPoints = localPoints;
        this.awayPoints = awayPoints;
    }

    public Match match(){
        return this.match;
    }

    public List<Player> scorersOfTeam(Team team){
        if (this.match.isLocalTeam(team))
            return this.localScorers;
        else
            return this.awayScorers;
    }

    public Integer pointsOfTeam(Team team){
        if (this.match.isLocalTeam(team)) return this.localPoints; else return this.awayPoints;
    }
}
