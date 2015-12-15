package model;

import exceptions.AbsentCaptain;
import exceptions.PositionFull;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private Formation formation;
    private String name;
    private User creator;
    private List<MatchResult> matchResults;
    private byte[] logo;

    public Team(String teamName){
        this.name = teamName;
        this.formation = new Formation(3,4,3);
        this.matchResults = new ArrayList<MatchResult>();
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
            if(player.captain()) { return player; }
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
        this.matchResults.add((int)matchResult.match().getId(), matchResult);
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
        return this.matchResults.get((int)match.getId());
    }


    //*******************************
    //It's only used for hibernate.
    //*******************************

    public Team(){

    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<MatchResult> getMatchResults() {
        return matchResults;
    }

    public void setMatchResults(List<MatchResult> matchResults) {
        this.matchResults = matchResults;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }


}
