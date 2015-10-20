package model;

import exceptions.AbsentCaptain;
import exceptions.PositionFull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team {

    //It's only used for hibernate.
    private double id;

    private Formation formation;
    private String name;
    private User creator;
    private Map<Match, MatchResult> matchResults;

    public Team(String teamName){
        this.name = teamName;
        this.formation = new Formation(3,4,3);
        this.matchResults = new HashMap<Match, MatchResult>();
    }

    public void beAssignedTo(User creator){
        this.creator = creator;
    }

    public User creator(){
        return this.creator;
    }

    public String name(){
        return this.name;
    }

    public Player captain() throws AbsentCaptain {
        for(Player player : this.players()){
            if(player.isCaptain()) { return player; }
        }
        throw new AbsentCaptain();
    }

    public List<Player> players(){
        return this.formation.players();
    }

    public void addPlayer(Player aPlayer) throws PositionFull {
        this.formation.addPlayer(aPlayer);
    }

    public List<Player> defenders(){
        return this.formation.defenders();
    }

    public List<Player> midfielders(){
        return this.formation.midfielders();
    }

    public List<Player> forwarders(){
        return this.formation.forwarders();
    }

    public void saveMatchResult(MatchResult matchResult){
        this.matchResults.put(matchResult.match(), matchResult);
    }

    public Integer pointsOnMatch(Match match){
        return this.resultForMatch(match).pointsOfTeam(this);
    }

    public List<Player> scorersOnMatch(Match match) {
        return this.resultForMatch(match).scorersOfTeam(this);
    }

    @Override
    public boolean equals(Object anotherTeam){
        Team _anotherTeam = (Team) anotherTeam;

        return this.name.equals(_anotherTeam.name());
    }

    private MatchResult resultForMatch(Match match){
        return this.matchResults.get(match);
    }
}
