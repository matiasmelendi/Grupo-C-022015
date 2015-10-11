package model;

public class DrawMatch extends ScoringRule {

    @Override
    public Boolean appliesTo(Team team, Match match) {
        return match.isDrawMatch();
    }

    @Override
    public Integer points() {
        return 1;
    }
}
