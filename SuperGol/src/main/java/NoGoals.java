
public class NoGoals extends ScoringRule {
    @Override
    public Boolean appliesTo(Team team, Match match) {
        return this.noGoalsOnMatchToTeam(match, team);
    }

    @Override
    public Integer points() {
        return 2;
    }

    private Boolean noGoalsOnMatchToTeam(Match match, Team team){
        if (match.isLocalTeam(team))
            return match.awayScorers().isEmpty();
        else
            return match.localScorers().isEmpty();
    }
}
