package model;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String username;
    private String password;
    private Team team;
    private Map<Tourney, Integer> scores;

    public User(String username, String password, Team aTeam){
        this.username = username;
        this.password = password;
        this.team = aTeam;
        this.scores = new HashMap<Tourney, Integer>();
    }

    public String username(){
        return this.username;
    }

    public Boolean hasPassword(){
        return !this.password.isEmpty();
    }

    public Team team(){
        return this.team;
    }

    public Integer scoreFor(Tourney aTourney){
        return this.scores.get(aTourney);
    }

    public void updateScoreFor(Tourney tourney, Integer newScore){
        this.scores.put(tourney, newScore);
    }
}
