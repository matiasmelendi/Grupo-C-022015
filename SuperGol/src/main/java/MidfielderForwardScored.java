
public class MidfielderForwardScored extends ScoringRule {
    @Override
    public Boolean appliesTo(Team team, Match match) {
        return this.midfielderOrForwardScoredOn(match, team);
    }

    @Override
    public Integer points() {
        return 1;
    }

    private Boolean midfielderOrForwardScoredOn(Match match, Team team){
        return new ListUtils<Player>().containsAny(team.scorersOnMatch(match), team.midfielders()) ||
                new ListUtils<Player>().containsAny(team.scorersOnMatch(match), team.forwarders());
    }

}
