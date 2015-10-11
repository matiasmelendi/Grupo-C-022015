package model;

import exceptions.PlayerNotFound;
import exceptions.PositionFull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Formation {

    private List<Player> players;
    private Map<Position, Integer> allowedPlayers;

    public Formation(Integer numberOfDefenders, Integer numberOfMidfielders, Integer numberOfForwarders){
        this.players = new ArrayList<Player>();
        this.allowedPlayers = new HashMap<Position, Integer>();
        this.allowedPlayers.put(Position.GOALKEEPER, 1);
        this.allowedPlayers.put(Position.DEFENDER, numberOfDefenders);
        this.allowedPlayers.put(Position.MIDFIELDER, numberOfMidfielders);
        this.allowedPlayers.put(Position.FORWARD, numberOfForwarders);
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
        return this.allowedPlayers.get(position);
    }
}
