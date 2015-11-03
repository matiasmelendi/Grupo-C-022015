package model;

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


    //*******************************
    //It's only used for hibernate.
    //*******************************
    private double id;

    public MatchResult(){

    }

    public List<Player> getLocalScorers() {
        return localScorers;
    }

    public void setLocalScorers(List<Player> localScorers) {
        this.localScorers = localScorers;
    }

    public List<Player> getAwayScorers() {
        return awayScorers;
    }

    public void setAwayScorers(List<Player> awayScorers) {
        this.awayScorers = awayScorers;
    }

    public Integer getLocalPoints() {
        return localPoints;
    }

    public void setLocalPoints(Integer localPoints) {
        this.localPoints = localPoints;
    }

    public Integer getAwayPoints() {
        return awayPoints;
    }

    public void setAwayPoints(Integer awayPoints) {
        this.awayPoints = awayPoints;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

}
