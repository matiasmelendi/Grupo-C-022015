
public class DefenderScored extends ScoringRule {
    @Override
    public Boolean appliesTo(Team team, Match match) {
        return this.defenderScoredOn(match, team);
    }

    @Override
    public Integer points() {
        return 3;
    }

    private Boolean defenderScoredOn(Match match, Team team){
        return new ListUtils<Player>().containsAny(team.scorersOnMatch(match), team.defenders());
    }
}
