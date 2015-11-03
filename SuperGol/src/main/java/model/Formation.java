package model;

import exceptions.PlayerNotFound;
import exceptions.PositionFull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Formation {

    private List<Player> players;
    private List<Integer> allowedPlayers;

    public Formation(Integer numberOfDefenders, Integer numberOfMidfielders, Integer numberOfForwarders){
        this.players = new ArrayList<Player>();
        this.allowedPlayers = new ArrayList<Integer>();
        this.allowedPlayers.add(Position.GOALKEEPER.value(), 1);
        this.allowedPlayers.add(Position.DEFENDER.value(), numberOfDefenders);
        this.allowedPlayers.add(Position.MIDFIELDER.value(), numberOfMidfielders);
        this.allowedPlayers.add(Position.FORWARD.value(), numberOfForwarders);
    }

    public List<Player> defenders(){
        return this.playersOnPosition(Position.DEFENDER);
    }

    public List<Player> midfielders(){
        return this.playersOnPosition(Position.MIDFIELDER);
    }

    public List<Player> forwarders(){
        return this.playersOnPosition(Position.FORWARD);
    }

    public Player goalkeeper() throws PlayerNotFound {
        try{
            return this.playersOnPosition(Position.GOALKEEPER).get(0);
        }catch (IndexOutOfBoundsException e){
            throw new PlayerNotFound("Goalkeeper is not selected yet!");
        }
    }

    public List<Player> players(){
        return this.players;
    }

    public Boolean canAddPlayer(Player player){
        return this.canAddPlayerWithPosition(player.position());
    }

    public void addPlayer(Player aPlayer) throws PositionFull {
        if(!this.canAddPlayer(aPlayer)){ throw new PositionFull(); }
        this.players.add(aPlayer);
    }

    private List<Player> playersOnPosition(Position position){
        List filteredPlayers = new ArrayList<Player>();

        for (Player player : this.players){
            if (player.position().equals(position)){ filteredPlayers.add(player);}
        }

        return filteredPlayers;
    }

    private Boolean canAddPlayerWithPosition(Position position){
        return this.playersOnPosition(position).size() < this.allowedNumberOfPlayersOnPosition(position);
    }

    private Integer allowedNumberOfPlayersOnPosition(Position position){
        return this.allowedPlayers.get(position.value());
    }

    //*******************************
    //It's only used for hibernate.
    //*******************************
    private double id;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Integer> getAllowedPlayers() {
        return allowedPlayers;
    }

    public void setAllowedPlayers(List<Integer> allowedPlayers) {
        this.allowedPlayers = allowedPlayers;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}
