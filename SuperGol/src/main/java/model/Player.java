package model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private Position position;
    private List<Team> teams;
    private Boolean captain;

    /**
     * Class' constructor.
     *
     * @param name     Name of the model.Player.
     * @param position model.Position of the model.Player.
     */
    public Player(String name, Position position) {
        this.name = name;
        this.position = position;
        this.teams = new ArrayList<Team>();
        this.captain = Boolean.FALSE;
    }

    public void addTeam(Team team){
        this.teams.add(team);
    }

    /**
     * Returns the name of the model.Player.
     *
     * @return Name of the model.Player.
     */
    public String name() {
        return this.name;
    }

    /**
     * Makes this player become a Captain.
     */
    public void becomeCaptain() {
        this.captain = Boolean.TRUE;
    }

    /**
     * Makes this player a normal model.Player.
     */
    public void unassignCaptain() {
        this.captain = Boolean.FALSE;
    }

    /**
     * Returns if this player is Captain.
     *
     * @return If this player is Captain.
     */
    public Boolean captain() {
        return this.captain;
    }

    /**
     * Change the position of this player.
     *
     * @param position The new position.
     */
    public void changePosition(Position position) {
        this.position = position;
    }

    /**
     * Returns the model.Player's position.
     *
     * @return This player position.
     */
    public Position position() {
        return this.position;
    }

    /**
     * Returns the model.Player's team.
     *
     * @return This player team.
     */
    public List<Team> teams() {
        return this.teams;
    }

    @Override
    public boolean equals(Object _anotherPlayer){
        Player anotherPlayer = (Player) _anotherPlayer;

        return this.name().equals(anotherPlayer.name()) &&
               this.position().equals(anotherPlayer.position()) &&
               this.captain().equals(anotherPlayer.captain());
    }

    //*******************************
    //It's only used for hibernate.
    //*******************************

    public Player(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}