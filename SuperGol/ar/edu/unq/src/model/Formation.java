package model;

import java.util.ArrayList;
import java.util.List;

public class Formation {

    private List<Player> players = new ArrayList<Player>();

    public List<Player> defenders(){
        return this.players;
    }

    public List<Player> players(){
        return this.players;
    }

    public void addPlayer(Player aPlayer){
        this.players.add(aPlayer);
    }
}
