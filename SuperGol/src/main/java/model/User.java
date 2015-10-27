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

    //*******************************
    //It's only used for hibernate.
    //*******************************
    private double id;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Map<Tourney, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<Tourney, Integer> scores) {
        this.scores = scores;
    }

}
