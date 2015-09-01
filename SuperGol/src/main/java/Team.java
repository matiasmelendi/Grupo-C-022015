import java.util.List;

public class Team {

    private Formation formation;

    public Team(){
        this.formation = new Formation();
    }

    public List<Player> players(){
        return this.formation.players();
    }

    public void addPlayer(Player aPlayer){
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
