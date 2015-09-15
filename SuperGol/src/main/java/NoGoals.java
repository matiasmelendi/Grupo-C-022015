import exceptions.NoMatchResultFound;

public class NoGoals extends ScoringRule {

    @Override
    public Boolean appliesTo(Team team, Match match) {
        return this.noGoalsOnMatchToTeam(match, team);
    }

    @Override
    public Integer points() {
        return 2;
    }

    //TODO: Enhance it on the next iteration
    private Boolean noGoalsOnMatchToTeam(Match match, Team team) {
        try {
            if (match.isLocalTeam(team))
                return match.awayScorers().isEmpty();
            else
                return match.localScorers().isEmpty();
        }catch(NoMatchResultFound e){
            return false;
        }
    }
}
