package model;


import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String password;
    private Team team;
    private List<Integer> scores;

    public User(String username, String password, Team aTeam){
        this.username = username;
        this.password = password;
        this.team = aTeam;
        this.scores = new ArrayList<Integer>();
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
        return this.scores.get(aTourney.getId());
    }

    public void updateScoreFor(Tourney tourney, Integer newScore){
        this.scores.add(tourney.getId(), newScore);
    }

    @Override
    public boolean equals(Object _anotherUser){
        User anotherUser = (User) _anotherUser;

        return this.username().equals(anotherUser.username());
    }

    //*******************************
    //It's only used for hibernate.
    //*******************************

    public User(){

    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

}
