import exceptions.PositionFull;

import java.util.List;

public class Team {

    private Formation formation;

    public Team(){
        this.formation = new Formation(3,4,3);
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

    @Override
    public boolean equals(Object anotherTeam){
        return true;
    }

}
