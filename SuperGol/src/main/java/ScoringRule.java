
public abstract class ScoringRule {

    public abstract Boolean appliesTo(Team team, Match match);

    public abstract Integer points();
}
